package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template4
 *
 * @author mmxm
 * @date 2023/7/11 15:54
 */
object Template4 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(184, label0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "nanoTime",
            "()J",
            false
        )
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
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label1 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label1)
        val label2 = Label()
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(185, label2)
        methodVisitor.visitLdcInsn("abc@defg#h\$ijklm,nop^qr%stu!vwx*yz")
        val v0 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v0)
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(186, label3)
        methodVisitor.visitLdcInsn("ijklm,nop^qr%stu!vwx*yz")
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(187, label4)
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
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(188, label5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v3)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(189, label6)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(191, label7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v5)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(192, label8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitInsn(Opcodes.ISUB)
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v6)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(194, label9)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v2)
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v7)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGT, label1)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(195, label11)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label12 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label12)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(196, label13)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitIincInsn(v7, 1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGT, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label12)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label13)
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(198, label12)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        val label14 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGT, label14)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(199, label15)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        val v8 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v8)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(200, label16)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.ISUB)
        val v9 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v9)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(201, label17)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        val v10 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            11,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label14)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(202, label19)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label14)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(203, label20)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label21)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(204, label22)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "()V",
            false
        )
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(202, label21)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            11,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitIincInsn(v8, 1)
        methodVisitor.visitIincInsn(v10, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label18)
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(194, label14)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitIincInsn(v7, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label10)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(211, label1)
        methodVisitor.visitFrame(Opcodes.F_NEW, 0, arrayOf(), 0, arrayOf())
    }

}