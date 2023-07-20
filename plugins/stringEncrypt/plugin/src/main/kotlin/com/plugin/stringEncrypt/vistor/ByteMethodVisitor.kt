package com.plugin.stringEncrypt.vistor

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.FieldNode


class ByteMethodVisitor(val mv:MethodVisitor,val list:MutableList<FieldNode> ) : MethodVisitor(Opcodes.ASM7,mv) {

    override fun visitLdcInsn(value: Any?) {
        super.visitLdcInsn(value)
    }
}

