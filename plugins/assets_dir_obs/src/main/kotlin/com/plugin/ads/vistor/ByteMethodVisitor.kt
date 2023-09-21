package com.plugin.ads.vistor

import com.plugin.ads.extension.ExtensionManager
import com.plugin.ads.log.GLog
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.FieldNode

/**
 * 自定义方法访问模式
 *
 * @author mmxm
 * @date 2022/2/14 10:12
 */
class ByteMethodVisitor(
    mv: MethodVisitor,
    val methodName: String,
    val owner: String?,
    val staticFinalStringFieldNodeList: List<FieldNode>
) : MethodVisitor(Opcodes.ASM9, mv) {

    override fun visitLdcInsn(value: Any?) {
        if (value is String) {
            if (value.isEmpty()) {
                super.visitLdcInsn(value)
                return
            }
            val entryString = ExtensionManager.getUseName(value)
            if (entryString != null && entryString != value) {
                GLog.i("assets 字符替换: $value --> $entryString")
                super.visitLdcInsn(entryString)
                return
            }
        }
        super.visitLdcInsn(value)
    }

    override fun visitInsn(opcode: Int) {
        if (opcode == Opcodes.RETURN && methodName === "<clinit>") {
            staticFinalStringFieldNodeList.forEach { fieldNode ->
                val value = fieldNode.value as String
                if (value.isEmpty()) {
                    super@ByteMethodVisitor.visitInsn(opcode)
                    return
                }
                val entryString = ExtensionManager.getUseName(value)
                if (entryString != null && entryString != value) {
                    GLog.i("assets 字符替换: $value --> $entryString")
                    mv.visitFieldInsn(
                        Opcodes.PUTSTATIC,
                        owner,
                        entryString,
                        "Ljava/lang/String;"
                    )
                }
            }
        }
        super.visitInsn(opcode)
    }

}

