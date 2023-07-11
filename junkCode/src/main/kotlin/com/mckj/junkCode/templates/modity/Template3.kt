package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template3
 *
 * @author mmxm
 * @date 2023/7/11 15:53
 */
object Template3 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/io/IOException")
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(155, label3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/Calendar",
            "getInstance",
            "()Ljava/util/Calendar;",
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
        methodVisitor.visitLdcInsn(2147483647L)
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label4 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label4)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        val label5 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label5)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLabel(label5)
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v1)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(156, label6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        val label7 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label7)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(157, label8)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(159, label0)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/FileReader")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("temp/temp/rd.rc")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/io/FileReader",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(160, label9)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 1024)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_CHAR)
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(161, label10)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(163, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/Reader",
            "read",
            "([CII)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(165, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitInsn(Opcodes.CALOAD)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 13)
        val label13 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label13)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(166, label14)
        methodVisitor.visitIincInsn(v4, -1)
        val label15 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label15)
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(167, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitInsn(Opcodes.CALOAD)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 10)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label15)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(168, label16)
        methodVisitor.visitIincInsn(v4, -1)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(169, label17)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitJumpInsn(Opcodes.IFLE, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitInsn(Opcodes.CALOAD)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 13)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label15)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(170, label18)
        methodVisitor.visitIincInsn(v4, -1)
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(172, label15)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_CHAR)
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(173, label19)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitJumpInsn(Opcodes.IFLE, label1)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(174, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "arraycopy",
            "(Ljava/lang/Object;ILjava/lang/Object;II)V",
            false
        )
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(175, label21)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 32)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/Arrays",
            "fill",
            "([CIIC)V",
            false
        )
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(179, label1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(177, label2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(178, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/IOException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(181, label7)
    }

}