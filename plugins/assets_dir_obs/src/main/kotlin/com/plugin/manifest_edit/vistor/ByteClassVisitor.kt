package com.plugin.manifest_edit.vistor


import org.objectweb.asm.*
import org.objectweb.asm.tree.FieldNode

/**
 * 字符串加密核心类
 *
 * @author mmxm
 * @date 2022/1/21 16:53
 */
class ByteClassVisitor(cw: ClassWriter) :
    ClassVisitor(Opcodes.ASM9, cw) {
    companion object{
        const val STRING_DESC = "Ljava/lang/String;"
    }
    private var hasClinit = false
    private var owner: String? = null
    private val staticFinalStringFieldNodeList: ArrayList<FieldNode> = ArrayList()

    override fun visit(
        version: Int,
        access: Int,
        name: String,
        signature: String?,
        superName: String?,
        interfaces: Array<String?>?
    ) {
        super.visit(version, access, name, signature, superName, interfaces)
        owner = name
    }

    override fun visitField(
        access: Int,
        name: String?,
        descriptor: String,
        signature: String?,
        value: Any?
    ): FieldVisitor? {
//        if (value != null && value is String
//            && descriptor === Type.getDescriptor(String::class.java) && 0 != Opcodes.ACC_STATIC and access && 0 != Opcodes.ACC_FINAL and access
//        ) {
//            staticFinalStringFieldNodeList.add(
//                FieldNode(
//                    access,
//                    name,
//                    descriptor,
//                    signature,
//                    value
//                )
//            )
//            return super.visitField(access, name, descriptor, signature, null)
//        }
//        return super.visitField(access, name, descriptor, signature, value)

        return if ( value == null || value !is String || descriptor != STRING_DESC || (access and Opcodes.ACC_STATIC == 0) || (access and Opcodes.ACC_FINAL == 0)) {
            super.visitField(access, name, descriptor, signature, null)
        } else {
            staticFinalStringFieldNodeList.add( FieldNode(access,name,descriptor,signature,value))
            super.visitField(access, name, descriptor, signature, null)
        }

    }

    override fun visitMethod(
        access: Int,
        name: String,
        descriptor: String?,
        signature: String?,
        exceptions: Array<String?>?
    ): MethodVisitor? {
        if (name === "<clinit>") {
            hasClinit = true
        }
        var mv = super.visitMethod(access, name, descriptor, signature, exceptions)
        mv = ByteMethodVisitor(
            mv, name, owner, staticFinalStringFieldNodeList
        )
        return mv
    }

}