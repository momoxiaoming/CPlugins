package com.google.plugin

import com.android.build.api.transform.Format
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.pipeline.TransformManager
import com.google.plugin.encrypt.EncryptStringClassVisitor
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.FileCollection
import com.google.gson.Gson
import org.objectweb.asm.*
import org.objectweb.asm.commons.ClassRemapper
import org.objectweb.asm.commons.SimpleRemapper
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.lang.StringBuilder
import java.util.jar.JarFile
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import javax.lang.model.SourceVersion
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import kotlin.random.Random

/**
 * jni混淆（支持对aar中的jni混淆）
 * 目标：
 * 1，so文件名随机
 * 2，native方法名和类名随机
 * create on 2022/5/13
 */
class JniMessPlugin : Transform(), Plugin<Project> {

     companion object {
        const val EXT_NAME = "jniMess"
        const val TRANSFORM_NAME = "jniMess"
        const val DEFAULT_CONFIG_FILE_NAME = "jniMess_config.json"
        const val seeds = "abcdefghijklmnopqrstuvwxyz"

        /**
         * 修改自己的类名
         */
        const val MODIFY_FLAG_MY_CLASS_NAME = 1

        /**
         * 修改自己的方法名
         */
        const val MODIFY_FLAG_MY_METHOD_NAME = 1 shl 1

        /**
         * 修改引用的类名和方法名
         */
        const val MODIFY_FLAG_REF = 1 shl 2

        /**
         * 修改load的so名字
         */
        const val MODIFY_FLAG_LOAD_SO_NAME = 1 shl 3

        /**
         * 修改类中的字符串
         */
        const val MODIFY_FLAG_RANDOM_STRING = 1 shl 4

        var logEnable=false

         fun log(msg: String) {
            if(logEnable){
                println("jniMess::$msg")
            }
        }
    }

    private var ext:JniMessExtension? = null

    private val stringsList by lazy{
        mutableListOf<String>()
    }

    /**
     * k: old
     * v: new
     */
    private val stringMap by lazy {
        mutableMapOf<String, String>()
    }

    /**
     * 查找配置文件
     */
    private fun findConfigFile(project: Project): File? {
        val ext: JniMessExtension = project.extensions.getByName(EXT_NAME) as JniMessExtension
        logEnable=ext.logEnable
        var file: File?
        if (ext.configFile.isNotEmpty()) {
            file = File(ext.configFile)
            if (file.exists()) {
                log("jmess config file found,path=${file.path}")
                return file
            }
        }
        file = File(project.rootProject.projectDir, DEFAULT_CONFIG_FILE_NAME)
        if (file.exists()) {
            log("jmess config file found in root dir,path=${file.path}")
            return file
        }
        return null
    }

    private var messConfig: MessConfig? = null

    /**
     * so文件名映射关系
     */
    private val soMap by lazy {
        mutableMapOf<String, String>()
    }

    /**
     * 保存jni类的修改映射关系
     */
    private val clzMap by lazy {
        mutableMapOf<String, String>()
    }

    /**
     * 保存native方法映射关系
     */
    private val methodMap by lazy {
        mutableMapOf<String, String>()
    }

    private fun generateMethodMapKey(clzName: String, methodName: String): String {
        val cn = if (!clzName.contains("/")) clzName.replace(".", "/") else clzName
        return "$cn#method#$methodName"
    }

    private fun generateSoMapKey(clzName: String, soName: String): String {
        val cn = if (!clzName.contains("/")) clzName.replace(".", "/") else clzName
        return "$cn#soName#$soName"
    }

    private fun extractSoNameFromKey(key:String):String{
        return key.split("#")[2]
    }

    /**
     * 生成类与方法映射关系
     */
    private fun fillMaps() {
        messConfig?.jniInfoList?.forEach { jniInfo ->
            val newClzName = generateRandomClzName()
            val clzName = jniInfo.clzName.replace(".", "/")
            clzMap[clzName] = newClzName
            log("fillMaps,map class: $clzName->$newClzName")
            usedClzList.add(newClzName)
            val newSoName = generateRandomSoName()
            soMap[generateSoMapKey(jniInfo.loadSoClzName.replace(".","/"),jniInfo.soName)] = newSoName
            log("fillMaps,map so name: ${jniInfo.soName}->$newSoName")
            usedSoNameList.add(newSoName)
            jniInfo.nativeMethods?.forEach { m ->
                val newMethodName = generateRandomMethodName()
                val mk = generateMethodMapKey(jniInfo.clzName, m)
                methodMap[mk] = newMethodName
                log("fillMaps,map method: $mk->$newMethodName")
                usedMethodList.add(newMethodName)
            }
        }

        if (messConfig?.javaStringConfig?.enable == true) {
            messConfig?.javaStringConfig?.list?.forEach {
                it.strings?.forEach { str->
                    val newString = genNewStringResource(str)
                    stringMap[str] = newString
                    log("genNewStringResource for javaString,$str->$newString")
                }
            }
        }
        if (messConfig?.manifestConfig?.enable == true) {
            messConfig?.manifestConfig?.manifestObsItems?.forEach {
                val newString = genNewStringResource(it.str)
                stringMap[it.str] = newString
                log("genNewStringResource for manifest,${it.str}->$newString")
            }
        }
    }

    private val usedSoNameList by lazy {
        mutableListOf<String>()
    }

    private val usedClzList by lazy {
        mutableListOf<String>()
    }

    private val usedMethodList by lazy {
        mutableListOf<String>()
    }



    /**
     * 加载配置信息
     */
    private fun loadMessConfig(project: Project) {
        try {
            val configFile = findConfigFile(project)
                ?: throw FileNotFoundException("jniMess config file not found,please place a file named 'jniMess_config.json' to rootProject's rootdir or your custom dir")
            val content = configFile.readText()
            messConfig = Gson().fromJson(content, MessConfig::class.java)
            log("loadMessConfig=$messConfig")
        } catch (e: Throwable) {
            throw RuntimeException("read jni mess config file error", e)
        }
    }

    private fun generateRandomWord(minSize: Int, maxSize: Int): String {
        val sb = StringBuilder()
        do {
            sb.clear()
            val size = Random.nextInt(minSize, maxSize + 1)
            for (i in 0 until size) {
                sb.append(seeds[Random.nextInt(0, seeds.length)])
            }
        } while (SourceVersion.isKeyword(sb.toString()))
        return sb.toString()
    }

    private fun generateRandomClassWord(): String {
        return generateRandomWord(1, 4)
    }

    private fun generateRandomClzName(): String {
        val sb = StringBuilder()
        do {
            sb.clear()
            val size = Random.nextInt(2, 5)
            for (i in 0 until size) {
                val w = generateRandomClassWord()
                log("generateRandomClzName,w=$w")
                sb.append(w)
                if (i < size - 1) {
                    sb.append("/")
                }
            }
        } while (usedClzList.contains(sb.toString()))
        val result =  sb.toString()
        if(!result.startsWith("com/")){
            return "com/$result"
        }
        return result
    }

    private fun generateRandomMethodName(): String {
        var result = ""
        do {
            result = generateRandomClassWord()
        } while (usedMethodList.contains(result))
        return result
    }

    private fun generateRandomSoName(): String {
        var result = ""
        do {
            result = generateRandomWord(3, 8)
        } while (usedSoNameList.contains(result))
        return result
    }

    override fun apply(project: Project) {
        log("apply")
        project.dependencies.add("implementation", "com.vi.security:stringEncryptTool:2.2.31")
        project.extensions.create(EXT_NAME, JniMessExtension::class.java)
        project.extensions.getByType(AppExtension::class.java).registerTransform(this)
        project.afterEvaluate { p ->
            ext = p.extensions.getByName(EXT_NAME) as JniMessExtension
            log("afterEvaluate,enable=${ext?.enable}")
            if (ext?.enable == true) {
                try {
                    loadMessConfig(p)
                } catch (e: Throwable) {
                    e.printStackTrace()
                    log("loadMessConfig err2")
                }
                log("messConfig.enable=${messConfig?.enable}")
                if (messConfig?.enable == true) {
                    fillMaps()
                    val tasks = p.getAllTasks(true)
                    tasks.entries.forEach {
                        it.value.forEach { task ->
                            task.doLast {t->
                                log("${task.name} doLast")
                                t.outputs.files.forEach { f->
                                    log("${task.name}.outfile=${f.path}")
                                }
                                if (t.name.matches(Regex("merge.*ReleaseNativeLibs"))) {
                                    log("${task.name} doLast")
                                    findAndModifySoName(task.outputs.files)
                                } else if (t.name.matches(Regex("process.*ReleaseManifest"))) {
                                    modifyManifestString(t)
                                }
                            }
                            task.doFirst { t->
                                log("${task.name} doFirst")
                                t.inputs.files.forEach { f->
                                    log("${task.name}.inputFile=${f.path}")
                                }
                                if(t.name.matches(Regex("merge.*ReleaseResources"))){
                                    modifyStrings(t)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun genNewStringResource(src:String): String {
        var result: String
        do {
            result = generateRandomWord(1, 4)
        } while (stringsList.contains(result))
        stringsList.add(result)
        if (src.startsWith(".")) {
            result = ".$result"
        } else if (src.startsWith(":")) {
            result = ":$result"
        }
        return result
    }

    private fun modifyManifestString(t:Task){
        if (messConfig?.enable == true && messConfig?.manifestConfig?.enable == true && messConfig?.manifestConfig?.manifestObsItems?.isNotEmpty() == true) {
            t.outputs.files.forEach {
                if (it.path.contains("merged_manifests")) {
                    val targetFile = File(it, "AndroidManifest.xml")
                    var text = targetFile.readText(Charsets.UTF_8)
                    var changed = false
                    messConfig?.manifestConfig?.manifestObsItems?.forEach { info->
                        val newString = stringMap[info.str]
                        if (newString != null) {
                            log("modifyManifestString,${info.str}->$newString")
                            text = text.replace(info.str, newString)
                            changed = true
                        }
                    }
                    if (changed) {
                        FileUtils.write(targetFile, text, charset("UTF-8"))
                    }
                }
            }
        }
    }

    private fun modifyStrings(t: Task){
        if (messConfig?.enable == true && messConfig?.stringConfig?.enable == true && messConfig?.stringConfig?.strings?.isNotEmpty() == true) {
            t.inputs.files.forEach { f->
                if (f.path.contains("daemon", true)) {
                    val targetFile = File(f,"values${File.separator}values.xml")
                    if (targetFile.exists()) {

                        val dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                        val dc = dBuilder.parse(targetFile)
                        dc.documentElement.normalize()
                        var changed = false

                        messConfig?.stringConfig?.strings?.forEach { s ->
                            val strings = dc.getElementsByTagName("string")
                            if (strings != null && strings.length > 0) {
                                for (i in 0 until strings.length) {
                                    val node = strings.item(i).firstChild
                                    val stringName = strings.item(i).attributes.getNamedItem("name").nodeValue
                                    val stringValue = node.nodeValue
                                    if (s == stringName) {
                                        val newString = genNewStringResource(stringValue)
                                        log("modifyStrings,name=$stringName,$stringValue->$newString")
                                        node.nodeValue = newString
                                        changed = true
                                    }
                                }
                            }
                        }

                        //save xml
                        if (changed) {
                            dc.documentElement.normalize()
                            val transformerFactory: TransformerFactory = TransformerFactory.newInstance()
                            val transformer: Transformer = transformerFactory.newTransformer()
                            val source = DOMSource(dc)
                            val result = StreamResult(targetFile)
                            transformer.setOutputProperty(OutputKeys.ENCODING, Charsets.UTF_8.name())
                            transformer.transform(source, result)
                        }
                    }
                }
            }
        }
    }

    private fun findAndModifySoName(parent: FileCollection) {
        parent.forEach { file ->
            if (file.path.contains("merged_native_libs")) {
                file.eachFileRecurse { f ->
                    soMap.entries.forEach { entry ->
                        val soName = "lib${extractSoNameFromKey(entry.key)}.so"
                        val newSoName = "lib${entry.value}.so"
                        if (soName == f.name) {
                            val dest = File(f.parent, newSoName)
                            try {
                                f.renameTo(dest)
                                log("modify so name success:${f.path}->${dest.path}")
                            } catch (e: Throwable) {
                                throw IllegalStateException("failed to modify so file name:${f.path}")
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getName(): String {
        return TRANSFORM_NAME
    }

    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> {
        return TransformManager.CONTENT_CLASS
    }

    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    override fun isIncremental(): Boolean {
        return false
    }

    class ClassInfo {
        var bytes: ByteArray? = null
        var path: String = ""
    }

    /**
     * 修改class文件或jar包
     * 有几种情况：
     * 1，包含native方法的类，需要修改方法名、类名
     * 2，加载so库的类，需要修改加载的so库的名称
     * 3，引用native方法和类的地方，需要修改引用的类名称及方法名称
     */
    override fun transform(transformInvocation: TransformInvocation) {
        val isReleaseBuild = transformInvocation.context.variantName.toLowerCase().contains("release")
        var enable = messConfig?.enable ?: false
        if (!enable) {
            log("transform,messConfig.enable=false,disable")
        }
        if (!isReleaseBuild) {
            log("transform,not release build,disable")
            enable = false
        }
        if (ext?.enable == false) {
            log("transform,ext.enable==false,disable")
            enable = false
        }

        log("transform,messConfig=$messConfig,enable=$enable")
        val outputProvider = transformInvocation.outputProvider
        if (!isIncremental) {
            outputProvider?.deleteAll()
        }

        if (outputProvider == null) {
            log("outputProvider is null !!!!")
            return
        }
        transformInvocation.inputs?.forEach {
            it.directoryInputs.forEach { dirInput ->
                val destDir = outputProvider.getContentLocation(
                    dirInput.name,
                    dirInput.contentTypes,
                    dirInput.scopes,
                    Format.DIRECTORY
                )
                if (enable) {
                    dirInput.file.eachFileRecurse { file ->
                        modifyClassIfNeeded(dirInput.file, file)
                    }
                }
                FileUtils.copyDirectoryToDirectory(dirInput.file,destDir)
            }
            it.jarInputs.forEach { jarInput ->
                var destName = jarInput.file.name
                val hexName = DigestUtils.md5Hex(destName).substring(0,8)
                if (destName.endsWith(".jar")) {
                    destName = destName.substring(0, destName.length - 4)
                }
                val destJar = outputProvider.getContentLocation(
                    destName + "_" + hexName,
                    jarInput.contentTypes,
                    jarInput.scopes,
                    Format.JAR
                )
                if (!destJar.exists()) {
                    try {
                        destJar.createNewFile()
                    } catch (e: Throwable) {
                        log("modifyJarIfNeeded,create dest jar failed")
                    }
                }
                if (!destJar.exists()) {
                    throw java.lang.IllegalStateException("modifyJarIfNeeded,create dest jar failed")
                }
                if (enable) {
                    modifyJarIfNeeded(jarInput.file, destJar)
                } else {
                    FileUtils.copyFile(jarInput.file, destJar)
                }
            }
        }
    }

    private fun getClzNameFromClassFile(filename: String): String {
        return if (filename.endsWith(".class")) filename.substring(
            0,
            filename.length - ".class".length
        ) else filename
    }

    /**
     * 对原class文件进行变换，生成新的class字节流
     */
    private fun modifyClass(
        oldPath: String?,
        clzName: String,
        oriBytes: ByteArray,
        flag: Int
    ): ClassInfo? {
        log("modifyClass,name=$clzName,flag=$flag,oldPath=$oldPath")

        var newStringBytes = oriBytes
        if ((flag and MODIFY_FLAG_RANDOM_STRING) != 0) {
            newStringBytes = changeStringOfClass(clzName, oriBytes)
        }

        val cr = ClassReader(newStringBytes)
        val cw = ClassWriter(cr, ClassWriter.COMPUTE_MAXS)
        val oldClzName = getClzNameFromClassFile(clzName)
        var newClzName = clzMap[oldClzName]
        if (newClzName == null) {
            if ((flag and MODIFY_FLAG_MY_CLASS_NAME) != 0) {
                throw NullPointerException("modifyClass failed because change class name error for $oldClzName,new class name is null")
            } else {
                newClzName = oldClzName
            }
        }
        val remapper = object : SimpleRemapper(oldClzName, newClzName) {
            override fun mapValue(value: Any): Any? {
                log("mapValue,v=$value,myClass=$oldClzName,valueType=${value::class.java.name}")
                var value_new: Any?
                //这里主要用来改class中的字符串
                value_new = methodMap[generateMethodMapKey(oldClzName,value.toString())]
                if (value_new == null) {
                    value_new = soMap[generateSoMapKey(oldClzName, value.toString())]
                }
                if (value_new != null && value != value_new) {
                    log("mapValue,change value:$value->$value_new,myClass=$oldClzName")
                }
                val v = value_new ?: value
                return super.mapValue(v)
            }

            override fun mapMethodName(owner: String, name: String, desc: String?): String? {
                log("mapMethodName,owner=$owner,name=$name,desc=$desc,myClass=$oldClzName")
                var owner_new = owner
                var name_new = name
                if ((flag and MODIFY_FLAG_MY_METHOD_NAME) != 0||(flag and MODIFY_FLAG_REF) != 0) {
                    owner_new = clzMap[owner]?:owner
                    name_new = methodMap[generateMethodMapKey(owner,name)]?:name
                    if (owner_new != owner || name_new != name) {
                        log("mapMethodName,owner_new=$owner_new,name_new=$name_new,oldMethodName=$name,myClass=$oldClzName")
                    }
                }
                return super.mapMethodName(owner_new, name_new, desc)
            }

            override fun mapType(type: String): String? {
                log("mapType,type=$type,myClass=$oldClzName")
                var type_new = type
                if ((flag and MODIFY_FLAG_REF) != 0) {
                    type_new = clzMap[type]?:type
                    if (type_new != type) {
                        log("mapType,$type->$type_new,oldType=$type,myClass=$oldClzName")
                    }
                }
                return super.mapType(type_new)
            }

            override fun map(key: String): String? {
                log("map2,key=$key,myClass=$oldClzName")
                val v = super.map(key)
                if (clzMap.containsKey(key)) {
                    val newValue = clzMap[key]
                    log("map,change value:$v->$newValue")
                    return newValue
                }
                return v
            }
        }
        val cv = ClassRemapper(cw, remapper)
        cr.accept(cv, ClassReader.EXPAND_FRAMES)
        val clzInfo = ClassInfo()
        clzInfo.bytes = cw.toByteArray()
        if ((flag and MODIFY_FLAG_MY_METHOD_NAME) != 0) {
            log("encryptStringForClass,oldClass=$oldClzName,newClass=$newClzName")
            clzInfo.bytes = encryptStringForClass(clzInfo.bytes)
        }
        log("modifyClass,change class name: $oldClzName->$newClzName,newBytes=${clzInfo.bytes}")

        if (newClzName != oldClzName && oldPath != null) {
            clzInfo.path = oldPath.replace(oldClzName, newClzName)
        } else {
            clzInfo.path = oldPath ?: ""
        }
        return clzInfo
    }

    /**
     * 修改类中的字符串
     */
    private fun changeStringOfClass(clzName: String, oriBytes: ByteArray):ByteArray{
        log("changeStringOfClass")
        val cr = ClassReader(oriBytes)
        val cw = ClassWriter(cr, ClassWriter.COMPUTE_MAXS)

        val cv = object:ClassVisitor(Opcodes.ASM6,cw){

            override fun visitMethod(
                access: Int,
                name: String?,
                desc: String?,
                signature: String?,
                exceptions: Array<out String>?
            ): MethodVisitor {
                var mv = super.visitMethod(access, name, desc, signature, exceptions)
                log("changeStringOfClass,mv=$mv")
                mv = object:MethodVisitor(Opcodes.ASM6,mv){
                    override fun visitLdcInsn(cst: Any?) {
                        var newCst = cst
                        if (cst is String) {
                            newCst = stringMap[cst] ?: cst
                            log("visitLdcInsn,changeString,$cst->$newCst")
                        }
                        super.visitLdcInsn(newCst)
                    }
                }
                return mv
            }
        }
        cr.accept(cv, ClassReader.EXPAND_FRAMES)
        return cw.toByteArray() ?: oriBytes
    }

    /**
     * 加密class中的字符串,因为这里改了类名后，字符串加密插件无法找到原来配置的包名了
     */
    private fun encryptStringForClass(bytes: ByteArray?): ByteArray? {
        bytes ?: return null
        val cr = ClassReader(bytes)
        val cw = ClassWriter(cr, ClassWriter.COMPUTE_MAXS)
        val cv = EncryptStringClassVisitor(cw)
        cr.accept(cv, ClassReader.EXPAND_FRAMES)
        return cw.toByteArray() ?: bytes
    }

    /**
     * 判断某个class是否需要修改
     * 有几种情况，
     * 1，需要修改类名
     * 2，需要修改native方法名
     * 3，需要修改引用的类名或方法名
     * @return 无需修改返回0，否则返回需要修改的flag组合
     */
    private fun getClassModifyFlag(clzName: String): Int {
        if (messConfig?.enable == false) {
            return 0
        }
        var flag = 0
        run loop@{
            messConfig?.jniInfoList?.forEach { jniInfo ->
                if (jniInfo.clzName.replace(".", "/") + ".class" == clzName) {
                    flag = (flag or MODIFY_FLAG_MY_CLASS_NAME)
                    log("$clzName need modify class name")
                    jniInfo.nativeMethods?.takeIf { it.isNotEmpty() }?.let {
                        flag = (flag or MODIFY_FLAG_MY_METHOD_NAME)
                        log("class $clzName need modify native method name")
                    }
                }
                if (jniInfo.loadSoClzName.replace(".", "/") + ".class" == clzName) {
                    flag = (flag or MODIFY_FLAG_LOAD_SO_NAME)
                    log("$clzName need modify so name")
                }
                jniInfo.refClasses?.forEach { clz ->
                    if (clzName == clz.replace(".", "/") + ".class") {
                        flag = (flag or MODIFY_FLAG_REF)
                        log("class $clzName need modify ref name")
                    }
                }
            }
            if (messConfig?.manifestConfig?.enable == true) {
                messConfig?.manifestConfig?.manifestObsItems?.forEach {
                    it.clzList?.forEach { clz->
                        if (clzName == "${clz.replace(".", "/")}.class") {
                            flag = (flag or MODIFY_FLAG_RANDOM_STRING)
                            log("$clz ->MODIFY_FLAG_RANDOM_STRING")
                        }
                    }
                }
            }
            if (messConfig?.javaStringConfig?.enable == true) {
                messConfig?.javaStringConfig?.list?.forEach {
                    if (clzName == "${it.clzName.replace(".", "/")}.class") {
                        flag = (flag or MODIFY_FLAG_RANDOM_STRING)
                        log("${it.clzName} ->MODIFY_FLAG_RANDOM_STRING")
                    }
                }
            }
        }
        return flag
    }

    /**
     * 修改jar包
     */
    private fun modifyJarIfNeeded(oriJarPath: File, destJar: File) {
        val destFos = ZipOutputStream(FileOutputStream(destJar))
        val oriJarFile = JarFile(oriJarPath)
        val entries = oriJarFile.entries()
        while (entries.hasMoreElements()) {
            val entry = entries.nextElement()
            val modifyFlag = getClassModifyFlag(entry.name)
            val zis = oriJarFile.getInputStream(entry)
            val oriBytes = IOUtils.toByteArray(zis)
            if (modifyFlag == 0) {
                destFos.putNextEntry(ZipEntry(entry.name))
                destFos.write(oriBytes, 0, oriBytes.size)
            } else {
                val oldClzName = getClzNameFromClassFile(entry.name)
                val mapName = clzMap[oldClzName]
                var newEntryName = mapName ?: entry.name
                if (!newEntryName.endsWith(".class")) {
                    newEntryName += ".class"
                }
                destFos.putNextEntry(ZipEntry(newEntryName))
                val newBytes = modifyClass(null, entry.name, oriBytes, modifyFlag)?.bytes
                val toWriteBytes = newBytes ?: oriBytes
                destFos.write(toWriteBytes, 0, toWriteBytes.size)
            }
            zis.close()
        }
        destFos.flush()
        destFos.close()
    }

    /**
     * 修改单个class文件
     * @return 修改后的class文件(可能与原class文件类名不一样）
     */
    private fun modifyClassIfNeeded(dir: File, file: File): File? {
        var clzName = file.path.substring(dir.path.length)
        if (clzName.first() == File.separatorChar) {
            clzName = clzName.substring(1)
        }
        val modifyFlag = getClassModifyFlag(clzName)
        if (modifyFlag == 0) {
            return null
        }
        modifyClass(file.path, clzName, file.readBytes(), modifyFlag)?.takeIf { it.bytes != null }
            ?.let { clzInfo ->
                val fos = FileOutputStream(clzInfo.path)
                fos.write(clzInfo.bytes!!)
                fos.flush()
                fos.close()
                log("modifyClassIfNeeded end,oriClass=${file.path},new class=${clzInfo.path}")
                return File(clzInfo.path)
            }
        return null
    }
}