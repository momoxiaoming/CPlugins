package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template8
 *
 * @author mmxm
 * @date 2023/7/11 15:56
 */
object Template8 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, null)
        val label3 = Label()
        methodVisitor.visitTryCatchBlock(label2, label3, label2, null)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(44, label4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/ClassLoader",
            "getSystemClassLoader",
            "()Ljava/lang/ClassLoader;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "identityHashCode",
            "(Ljava/lang/Object;)I",
            false
        )
        methodVisitor.visitInsn(Opcodes.I2L)
        methodVisitor.visitLdcInsn(31449600000L)
        methodVisitor.visitInsn(Opcodes.LOR)
        methodVisitor.visitLdcInsn(31449600000L)
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label5 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label5)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(45, label6)
        methodVisitor.visitLdcInsn("abc")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "getBytes",
            "()[B",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/nio/ByteBuffer",
            "wrap",
            "([B)Ljava/nio/ByteBuffer;",
            false
        )
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(46, label7)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE)
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(47, label8)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/Object")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/Object",
            "<init>",
            "()V",
            false
        )
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(48, label9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/nio/ByteBuffer",
            "remaining",
            "()I",
            false
        )
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(49, label10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitInsn(Opcodes.DUP)
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        methodVisitor.visitInsn(Opcodes.MONITORENTER)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(50, label0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        val label11 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFLE, label11)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(51, label12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 8192)
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Math", "min", "(II)I", false)
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v6)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(52, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        val label14 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label14)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(53, label15)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(55, label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/nio/ByteBuffer",
            "put",
            "([BII)Ljava/nio/ByteBuffer;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(56, label16)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label0)
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(57, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitInsn(Opcodes.MONITOREXIT)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label5)
        methodVisitor.visitLabel(label2)
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitInsn(Opcodes.MONITOREXIT)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(60, label5)
    }

}