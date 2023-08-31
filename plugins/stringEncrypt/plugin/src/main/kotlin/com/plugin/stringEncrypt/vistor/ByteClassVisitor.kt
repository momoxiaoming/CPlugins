package com.plugin.stringEncrypt.vistor


import org.objectweb.asm.*
import org.objectweb.asm.tree.FieldNode


class ByteClassVisitor(cw: ClassWriter) :
    ClassVisitor(Opcodes.ASM7, cw) {
    var hasClinit = false

    /**
     * 存放所有的类变量, 包括静态变量
     */
    private val stringFieldList = mutableListOf<FieldNode>()
    private var owner: String? = null

    /**
     * 访问的每个类的回调接口
     * @param version Int
     * @param access Int
     * @param name String
     * @param signature String
     * @param superName String
     * @param interfaces Array<out String>
     */
    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        owner = name
        super.visit(version, access, name, signature, superName, interfaces)
    }

    /**
     * 返回类的注解,我们可以在此方法识别注解接口类型,通过此类型判断是否需要过滤掉此类
     * @param desc String
     * @param visible Boolean
     * @return AnnotationVisitor
     */
    override fun visitAnnotation(desc: String?, visible: Boolean): AnnotationVisitor? {
        return super.visitAnnotation(desc, visible)
    }

    /**
     * 访问类的变量field的回调接口
     * @param access Int 权限
     * @param name String 变量名
     * @param desc String
     * @param signature String
     * @param value Any
     * @return FieldVisitor
     */
    override fun visitField(
        access: Int,
        name: String?,
        desc: String?,
        signature: String?,
        value: Any?
    ): FieldVisitor {
        if (value == null || value !is String || desc != "Ljava/lang/String;" || (access and Opcodes.ACC_STATIC == 0) || (access and Opcodes.ACC_FINAL == 0)) {
            return super.visitField(access, name, desc, signature, value)
        } else {
            stringFieldList.add(FieldNode(access, name, desc, signature, value))
            return super.visitField(access, name, desc, signature, value)
        }

//        if (value != null && value is String
//            && desc == Type.getDescriptor(String::class.java)
//            && 0 != (Opcodes.ACC_STATIC and access)
//            && 0 != (Opcodes.ACC_FINAL and access)
//        ) {
//            //添加一个类下的 所有  static final 的字段
//            stringFieldList.add(FieldNode(access, name, desc, signature, value))
//            return super.visitField(access, name, desc, signature, null)
//        }
//        return  super.visitField(access, name, desc, signature, null)
    }

    /**
     * 访问方法时的回调
     * @param access Int
     * @param name String
     * @param desc String
     * @param signature String
     * @param exceptions Array<out String>
     * @return MethodVisitor
     */
    override fun visitMethod(
        access: Int,
        name: String?,
        desc: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
//        if (name == "<clinit>") {
//            hasClinit = true
//        }
        val mv = super.visitMethod(access, name, desc, signature, exceptions)
        return ByteMethodVisitor(mv, name, owner, stringFieldList)
    }

    override fun visitModule(name: String?, access: Int, version: String?): ModuleVisitor {
        return super.visitModule(name, access, version)
    }

//    override fun visitEnd() {
//        if (!hasClinit) {
//            val mv = super.visitMethod(Opcodes.ACC_STATIC, "<clinit>", "()V", null, null)
//            mv.visitCode()
//            mv.visitInsn(Opcodes.RETURN)
//            mv.visitMaxs(0, 0)
//            mv.visitEnd()
//        }
//        super.visitEnd()
//    }
}