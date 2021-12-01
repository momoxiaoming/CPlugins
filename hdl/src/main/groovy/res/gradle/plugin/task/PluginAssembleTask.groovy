package res.gradle.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import res.gradle.plugin.Constans
import res.gradle.plugin.utils.AESUtils

/**
 * app打包后,执行此任务
 * 1.找出最终的mapping 相关文件
 * 2.根据现有mapping,合并出插件需要的mapping文件
 * 3.执行插件编译任务
 * 4.将app生成的apk,通过重编译,将插件apk置于assets下
 * 5.输出最终的宿主apk
 */
public class PluginAssembleTask extends DefaultTask {

    @Input
    Project rootProj

    @Input
    String buildType

    private static String apkToolPath              = ""
    private static String zipalignPath             =""
    private static String apksignerPath            =""


    //定义几个主要路径
    private static String MAIN_PATH                = ""
    private static String MAIN_PLUGIN_APK_PATH     = ""  //加密后的插件路径
    private static String MAIN_APP_APK_PATH        = ""  //最终的宿主apk路径
    private static String MAIN_APP_APK_DUMP_PATH   = ""  //dump 路径

    static boolean isLinux() {
        return org.gradle.internal.os.OperatingSystem.current().isLinux()
    }
    static boolean isWindows() {
        return org.gradle.internal.os.OperatingSystem.current().isWindows()
    }
    @TaskAction
    void confuse() {
        initCmdPath()

        initDirPath()
        // 取出宿主apk
        def appApk = getApk("${project.rootProject.projectDir}/app/build/outputs/apk/${buildType.toLowerCase()}/")
        //dump宿主apk
        dumpApk(appApk)

        //回编宿主apk
        def file=createApk(appApk.name)

       def zipalignFile= zipalign(file)
        //尝试签名
        signApk(zipalignFile)
    }

    /**
     * 初始化各种命令路径
     */
    private void initCmdPath(){
        if(isLinux()){
            apkToolPath=rootProj.rootProject.paths.linuxPath.apktool
            zipalignPath=rootProj.rootProject.paths.linuxPath.zipalign
            apksignerPath=rootProj.rootProject.paths.linuxPath.apksigner
        }else{
            apkToolPath=rootProj.rootProject.paths.defaultPath.apktool
            zipalignPath=rootProj.rootProject.paths.defaultPath.zipalign
            apksignerPath=rootProj.rootProject.paths.defaultPath.apksigner
        }
    }

    private File zipalign(File apk){
        println("开始apk对齐")
        def alignApk=new File(apk.parentFile,"${apk.name}-align.apk")
        if(alignApk.exists()){
            alignApk.delete()
        }
        rootProj.exec {
            args("-c")
            List<String> args = new ArrayList<>()
            args.add(zipalignPath)
            args.add("-v")
            args.add("-p")
            args.add("4")
            args.add("${apk.path}")
            args.add("${alignApk.path}")
            println("dump 命令-->"+args.toArray().join(" "))
            commandLine(args.toArray())
        }
        apk.delete()
        return alignApk
    }

    private void signApk(File apk){
        println("开始apk签名")
        def sign=false
        if(!Constans.sign_storeFile_path.isEmpty()){
//            apksigner sign --ks wifi_dzg.jks --ks-key-alias wifidzg --ks-pass pass:mckj2020 --key-pass pass:mckj2020 38023999_com.mc.cpyr.wifidzg_1.0.0_hwcsj_20211130.apk
            rootProj.exec {
                args("-c")
                List<String> args = new ArrayList<>()
                args.add("java")
                args.add("-jar")
                args.add(apksignerPath)
                args.add("sign")
                args.add("--ks")
                args.add("${Constans.sign_storeFile_path}")
                args.add("--ks-key-alias")
                args.add("${Constans.sign_keyAlias}")
                args.add("--ks-pass")
                args.add("pass:${Constans.sign_storePassword}")
                args.add("--key-pass")
                args.add("pass:${Constans.sign_keyPassword}")
                args.add("${apk.path}")
                println("dump 命令-->"+args.toArray().join(" "))
                commandLine(args.toArray())
            }
        }
        def name=apk.name.replace(".apk","")
        def newName=name
        if(sign){
            newName= "${name}-unsign.apk"
        }else{
            newName= "${name}-sign.apk"
        }
        apk.renameTo(new File(apk.parentFile,"$newName"))
    }
    /**
     * 初始化各种路径
     */
    private void initDirPath(){
        MAIN_PATH                = "${project.rootProject.projectDir}/app/build/hdl"
        MAIN_PLUGIN_APK_PATH     = "$MAIN_PATH/plugin"  //加密后的插件路径
        MAIN_APP_APK_PATH        = "$MAIN_PATH/apk"  //最终的宿主apk路径
        MAIN_APP_APK_DUMP_PATH   = "$MAIN_PATH/dump"  //dump 路径

        def file1=new File(MAIN_APP_APK_PATH)
        if(!file1.exists()){
            file1.mkdirs()
        }

        def file3=new File(MAIN_PLUGIN_APK_PATH)
        if(!file3.exists()){
            file3.mkdirs()
        }
    }
/**
 * 加密apk
 */
    private File encodeApk() {
        def appApk = getApk("${project.buildDir}/outputs/apk/${buildType.toLowerCase()}/")
        def byteArr= AESUtils.encrypt(appApk.readBytes())
        if(byteArr==null){
            throw new Exception("${appApk.absolutePath} 加密失败")
        }
        println("插件apk加密成功---")
        def newFileDir=new File(MAIN_PLUGIN_APK_PATH)
        if(!newFileDir.exists()){
            newFileDir.mkdirs()
        }
        //获取插件版本,包名
        def applicationId=project.rootProject.modules.aos.applicationid
        def versioncode=project.rootProject.modules.aos.versionCode
        def old="hdl_${applicationId}-${versioncode}.apk"
        def encName= AESUtils.parseByte2HexStr(AESUtils.encrypt(old))
        println("插件apk名称加密成功---old-->$old---加密后-->$encName")
        def newFile=new File(newFileDir,encName)
        newFile.withDataOutputStream {
            it.write(byteArr)
        }
        return newFile
    }

    private void dumpApk(File file) {
        println("开始dump宿主apk")
        def dumpDir=new File(MAIN_APP_APK_DUMP_PATH)
        if(dumpDir.exists()){
            dumpDir.deleteDir()
        }
        rootProj.exec {
            args("-c")
            List<String> args = new ArrayList<>()
            args.add("java")
            args.add("-jar")
            args.add(apkToolPath)
            args.add("d")
            args.add(file.absolutePath)
            args.add("-o")
            args.add(MAIN_APP_APK_DUMP_PATH)
            args.add("--only-main-classes")
            println("dump 命令-->"+args.toArray().join(" "))
            commandLine(args.toArray())
        }
    }
    private File createApk(String name) {
        println("开始将插件apk加密并复制到assets")
        //取出插件apk
        def encPluginApk=encodeApk()
        def assetsDir=new File(MAIN_APP_APK_DUMP_PATH,"assets/hdl/")
        if(!assetsDir.exists()){
            assetsDir.mkdirs()
        }
        def assetsFile=new File(assetsDir,encPluginApk.name)
        println("准备复制加密apk--->${assetsFile.absolutePath}")

        assetsFile.withDataOutputStream {
            it.write(encPluginApk.readBytes())
        }
        def file=new File(MAIN_APP_APK_PATH,name)


        rootProj.exec {
            args("-c")
            List<String> args = new ArrayList<>()
            args.add("java")
            args.add("-jar")
            args.add(apkToolPath)
            args.add("b")
            args.add(MAIN_APP_APK_DUMP_PATH)
            args.add("-o")
            args.add(file.absolutePath)
            println("create 命令-->"+args.toArray().join(" "))
            commandLine(args.toArray())
        }

        println("宿主apk重打包成功")

        return file
    }

    private File getApk(String path) {
        def typeFolder = new File(path)
        if (!typeFolder.exists() || !typeFolder.isDirectory()) {
            throw new Exception("未找到->${typeFolder.path}目录")
        }
        def listFiles = typeFolder.listFiles(new FilenameFilter() {
            @Override
            boolean accept(File dir, String name) {
                return  name.endsWith(".apk")
            }
        })

        if (listFiles.size()==0) {
            throw new Exception("未找到->${typeFolder.path}中的apk")
        }
        return listFiles[0]
    }
}