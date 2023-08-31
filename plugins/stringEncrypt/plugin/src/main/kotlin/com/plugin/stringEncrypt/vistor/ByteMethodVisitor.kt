package com.plugin.stringEncrypt.vistor

import com.plugin.stringEncrypt.helpr.EncryptHelper
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.FieldNode


class ByteMethodVisitor(
    val mv: MethodVisitor,
    val methodName: String?,
    val owner: String?,
    val list: MutableList<FieldNode>
) : MethodVisitor(Opcodes.ASM7, mv) {

    /**
     * 访问ldc指令, 可以监听所有通过ldc指令将变量加载到操作数栈上
     * @param value Any
     */
    override fun visitLdcInsn(value: Any?) {
        if (value != null && value is String && value.length != 0) {
            println("visitLdcInsn--->"+value)
            EncryptHelper.encrypt(mv, value)
            return
        }
        super.visitLdcInsn(value)
    }

    /**
     * 访问方法体中的指令.
     * @param opcode Int
     */
    override fun visitInsn(opcode: Int) {
        if (opcode == Opcodes.RETURN && methodName == "<clinit>") {
            list.forEach {
                val value = it.value as? String
                val name = it.name
                if (value == null || value.isEmpty()) {
                    super.visitInsn(opcode)
                }else{
                    println("visitInsn--->"+value)
                    EncryptHelper.encrypt(mv, value)
                    super.visitFieldInsn(Opcodes.PUTSTATIC, this.owner, name, "Ljava/lang/String;")
                }
            }
        }
        super.visitInsn(opcode)
    }
}

