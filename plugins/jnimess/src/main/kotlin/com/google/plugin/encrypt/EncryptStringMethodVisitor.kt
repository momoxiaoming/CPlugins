package com.google.plugin.encrypt

import com.google.plugin.JniMessPlugin
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.FieldNode

class EncryptStringMethodVisitor(
    mv: MethodVisitor?, val methodName: String?,
    val owner: String?,
    val staticFinalStringFieldNodeList: List<FieldNode>
) : MethodVisitor(Opcodes.ASM5, mv) {

    override fun visitLdcInsn(value: Any?) {
        if (value is String) {
            if(value.isEmpty()){
                super.visitLdcInsn(value)
                return
            }
            try {
                AsmEncryptUtils.encryptDecrypt(mv, value)
                return
            } catch (e: Throwable) {
                e.printStackTrace()
                JniMessPlugin.log("visitLdcInsn error,e=$e")
            }
        }
        super.visitLdcInsn(value)
    }

    override fun visitInsn(opcode: Int) {
        if (opcode == Opcodes.RETURN && methodName == "<clinit>") {
            staticFinalStringFieldNodeList.forEach { fieldNode ->
                val value = fieldNode.value as String
                if(value.isEmpty()){
                    super.visitInsn(opcode)
                    return
                }
                try {
                    AsmEncryptUtils.encryptDecrypt(mv, fieldNode.value as String)
                    mv?.visitFieldInsn(
                        Opcodes.PUTSTATIC,
                        owner,
                        fieldNode.name,
                        "Ljava/lang/String;"
                    )
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }
        }
        super.visitInsn(opcode)
    }


}