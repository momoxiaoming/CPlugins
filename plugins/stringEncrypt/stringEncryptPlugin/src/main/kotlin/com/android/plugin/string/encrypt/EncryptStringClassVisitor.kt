package com.android.plugin.string.encrypt

import org.objectweb.asm.*
import org.objectweb.asm.tree.FieldNode

class EncryptStringClassVisitor(cv:ClassVisitor) : ClassVisitor(Opcodes.ASM9,cv) {

    var hasClinit = false
    var owner: String? = null
    val staticFinalStringFieldNodeList = mutableListOf<FieldNode>()

    override fun visit(version: Int, access: Int, name: String?, signature: String?, superName: String?, interfaces: Array<out String>?) {
        super.visit(version, access, name, signature, superName, interfaces)
        owner = name
    }

    override fun visitField(access: Int, name: String, descriptor: String, signature: String?, value: Any?): FieldVisitor {
        if (value != null && value is String
            && descriptor == Type.getDescriptor(String::class.java)
            && 0 != (Opcodes.ACC_STATIC and access)
            && 0 != (Opcodes.ACC_FINAL and access)
        ) {
            //添加一个类下的 所有  static final 的字段
            staticFinalStringFieldNodeList.add(FieldNode(access, name, descriptor, signature, value))
            return super.visitField(access, name, descriptor, signature, null)
        }
        return super.visitField(access, name, descriptor, signature, value)
    }

    override fun visitMethod(access: Int, name: String, desc: String, signature: String?, exceptions: Array<String?>?): MethodVisitor? {
        if (name == "<clinit>") {
            hasClinit = true
        }
        var mv = super.visitMethod(access, name, desc, signature, exceptions)
        mv = EncryptStringMethodVisitor(mv, name, owner, staticFinalStringFieldNodeList)
        return mv
    }

    override fun visitEnd() {
        if (!hasClinit) {
            val mv = super.visitMethod(Opcodes.ACC_STATIC, "<clinit>", "()V", null, null)
            mv.visitCode()
            mv.visitInsn(Opcodes.RETURN)
            mv.visitMaxs(0, 0)
            mv.visitEnd()
        }
        super.visitEnd()
    }
}