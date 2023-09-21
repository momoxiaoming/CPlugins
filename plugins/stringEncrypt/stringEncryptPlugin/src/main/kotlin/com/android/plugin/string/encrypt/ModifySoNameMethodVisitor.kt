package com.android.plugin.string.encrypt

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * @Author: hzh
 * @Date: 2022/10/13
 * @Desc: 修改so 名称
 */
class ModifySoNameMethodVisitor(mv: MethodVisitor?, val methodName: String?, val soName: String) :
    MethodVisitor(Opcodes.ASM9, mv) {

    override fun visitLdcInsn(value: Any?) {
        println("methodName >>>$methodName   visitLdcInsn >>> $value")
        StringEncryptPlugin.log("methodName >>>$methodName   visitLdcInsn >>> $value")
        if (methodName == "<clinit>") {
            super.visitLdcInsn(soName)
        } else {
            super.visitLdcInsn(value)
        }

    }

}