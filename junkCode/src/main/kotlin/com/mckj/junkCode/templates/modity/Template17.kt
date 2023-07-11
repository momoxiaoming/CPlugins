package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template17
 *
 * @author mmxm
 * @date 2023/7/11 16:01
 */
object Template17 {
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
        methodVisitor.visitLineNumber(87, label4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/Calendar",
            "getInstance",
            "()Ljava/util/Calendar;",
            false
        )
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(88, label5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
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
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "nanoTime",
            "()J",
            false
        )
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label6 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label6)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(89, label7)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Random")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/Random",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Random",
            "nextInt",
            "()I",
            false
        )
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v2)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(90, label8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v2)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Object")
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(91, label9)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Random")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/Random",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Random",
            "nextInt",
            "()I",
            false
        )
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(92, label10)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/Object")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/Object",
            "<init>",
            "()V",
            false
        )
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(93, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitInsn(Opcodes.DUP)
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v6)
        methodVisitor.visitInsn(Opcodes.MONITORENTER)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(94, label0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v2)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Object")
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(95, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val v8 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v8)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(96, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/Arrays",
            "equals",
            "([Ljava/lang/Object;[Ljava/lang/Object;)Z",
            false
        )
        val label14 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label14)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(97, label15)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Math", "max", "(II)I", false)
        val v9 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v9)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(98, label16)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v10 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v9)
        val label18 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label18)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(99, label19)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        val label20 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ACMPEQ, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(100, label21)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/Objects",
            "equals",
            "(Ljava/lang/Object;Ljava/lang/Object;)Z",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label20)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(101, label22)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(102, label23)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label14)
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(98, label20)
        methodVisitor.visitIincInsn(v10, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label17)
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(106, label18)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        val label24 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label24)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(107, label25)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label14)
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(108, label24)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Random")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/Random",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Random",
            "nextInt",
            "()I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(110, label14)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Object")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v9)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(111, label26)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "arraycopy",
            "(Ljava/lang/Object;ILjava/lang/Object;II)V",
            false
        )
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(112, label27)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "arraycopy",
            "(Ljava/lang/Object;ILjava/lang/Object;II)V",
            false
        )
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(116, label28)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitInsn(Opcodes.MONITOREXIT)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label6)
        methodVisitor.visitLabel(label2)
        val v11 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitInsn(Opcodes.MONITOREXIT)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v11)
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(118, label6)
    }

}