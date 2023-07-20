package com.plugin.stringEncrypt.vistor

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * 自定义方法访问模式
 *
 * @author mmxm
 * @date 2022/2/14 10:12
 */
class ByteMethodVisitor(val mv1:MethodVisitor ) : MethodVisitor(Opcodes.ASM7,mv1) {

    override fun visitCode() {
        // 删除方法中的所有指令
        mv1.visitInsn(Opcodes.RETURN)
    }

    override fun visitEnd() {
        // 删除方法中的所有变量
        super.visitEnd()
    }
}

