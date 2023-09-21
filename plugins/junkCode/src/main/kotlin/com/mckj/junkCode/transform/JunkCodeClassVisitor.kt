package com.mckj.junkCode.transform

import com.mckj.junkCode.ext.ExtensionManager
import com.mckj.junkCode.templates.add.*
import com.mckj.junkCode.util.Helper
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.MethodNode
import kotlin.random.Random

/**
 * JunkCodeClassVisitor
 *
 * @author mmxm
 * @date 2023/7/11 12:04
 */
class JunkCodeClassVisitor(cw: ClassWriter,val methodNodeList: List<MethodNode>) : org.objectweb.asm.ClassVisitor(Opcodes.ASM9, cw) {


    var isInterface = false
    var isAbstractClazz = false
    var addCount = 0
    var mClassName: String? = ""
    var mAccess: Int = 0


    val maxfunsToModify by lazy {
        ExtensionManager.extension?.maxJunkCodeFunToModify?:0
    }
    val maxFields by lazy {
        ExtensionManager.extension?.maxJunkCodeFields?:0
    }
    val maxfuns:Int by lazy {
        ExtensionManager.extension?.maxJunkCodeFunOfPerClass?:0
    }

    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        super.visit(version, access, name, signature, superName, interfaces)
        mClassName = name
        mAccess = access
        this.isInterface = (access and Opcodes.ACC_INTERFACE) != 0
        this.isAbstractClazz = (access and Opcodes.ACC_ABSTRACT) != 0
    }

    override fun visitMethod(
        access: Int,
        name: String,
        descriptor: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        var mv = super.visitMethod(access, name, descriptor, signature, exceptions)
        var needAddJunkCode = false

        if (Random.nextBoolean() && addCount < maxfunsToModify) {
            addCount++
            needAddJunkCode = true
        }
        if (!isInterface && !isAbstractClazz && !name.contains("init>") && name != "onCreate" && needAddJunkCode) {
            var index = 100
            methodNodeList.forEach {
                if (it.name == name && it.desc == descriptor) {
                    if (it.localVariables != null) {
                        index += it.localVariables.size
                    }
                }
            }
            mv = JunkCodeMethodAdapterVisitor(mv, access, name, descriptor, index)
        }
        return mv
    }

    override fun visitEnd() {
        val fields = ArrayList<String>()
        val methods = ArrayList<String>()

        if (!isInterface) {
            //插入字段
            val ranFieldCount = Random.nextInt(maxFields)
            for (i in 0..ranFieldCount) {
                val str = Helper.randomName()
                fields.add(str)
                val fv = cv.visitField(Helper.getOpcode(), str, Helper.getDescriptor(), null, null)
                if (fv != null) {
                    fv.visitEnd()
                } else {
                    super.visitEnd()
                }
            }

            //如果不是接口，同时不是抽象类则进行插桩
            if (!isInterface && !isAbstractClazz) {
                //插入方法
                val maxfunsSeed = Random.nextInt(maxfuns)
                for (i in 0..maxfunsSeed) {
                    val methodName = Helper.randomName()
                    methods.add(methodName)
                    val mv = cv.visitMethod(Helper.getOpcode(), methodName, "()V", null, null)
                    if (mv != null) {
                        val seed = 20 / maxfuns
                        val ran = Random.nextInt(seed)
                        when (ran) {
                            0 -> {
                                generateMethod(mv, i + 1, methodName)
                            }

                            1 -> {
                                generateMethod(mv, i + 6, methodName)
                            }

                            2 -> {
                                generateMethod(mv, i + 11, methodName)
                            }
                            3 -> {
                                generateMethod(mv, i + 16, methodName)
                            }

                        }
                    }
                }
            }

            //如果字段不为空，这自动生成对应的keep 规则
            if (fields.isNotEmpty() || methods.isNotEmpty()) {
                val clazz = mClassName?.replace("/", ".")?:""
                val builder =StringBuilder ("-keep , allowobfuscation class " + "${clazz}" + " { ")
                builder.append("\n")
                // keep 字段
                fields.forEach {
                    builder.append("***  ${it};")
                    builder.append("\n")
                }
                //keep 方法
                methods.forEach {
                    builder.append("void ${it}();")
                    builder.append("\n")
                }
                builder.append("}")
                builder.append("\n")
                //生成插入字段以及插入方法对应的keep 规则
                ExtensionManager.mappingMap.add(builder.toString())
            }
        }
        super.visitEnd()
    }

    private fun generateMethod(mv: MethodVisitor, num: Int, methodName: String) {
//        println("junkCode, 插入方法模板:$num")
        when (num) {
            1 -> {
                Template1.fillfromCode(mv)
            }
            2 -> {
                Template2.fillfromCode(mv)
            }
            3 -> {
                Template3.fillfromCode(mv)
            }
            4 -> {
                Template4.fillfromCode(mv)
            }
            5 -> {
                Template5.fillfromCode(mv)
            }
            6 -> {
                Template6.fillfromCode(mv)
            }
            7 -> {
                Template7.fillfromCode(mv)
            }
            8 -> {
                Template8.fillfromCode(mv)
            }
            9 -> {
                Template9.fillfromCode(mv)
            }
            10 -> {
                Template10.fillfromCode(mv)
            }
            11 -> {
                Template11.fillfromCode(mv)
            }
            12 -> {
                Template12.fillfromCode(mv)
            }
            13 -> {
                Template13.fillfromCode(mv)
            }
            14 -> {
                Template14.fillfromCode(mv)
            }
            15 -> {
                Template15.fillfromCode(mv)
            }
            16 -> {
                Template16.fillfromCode(mv)
            }
            17 -> {
                Template17.fillfromCode(mv)
            }
            18 -> {
                Template18.fillfromCode(mv)
            }
            19 -> {
                Template19.fillfromCode(mv)
            }
            20 -> {
                Template20.fillfromCode(mv)
            }
            else -> {
                Template20.fillfromCode(mv)
            }

        }

    }

}