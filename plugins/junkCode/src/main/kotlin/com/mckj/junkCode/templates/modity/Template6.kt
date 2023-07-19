package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template6
 *
 * @author mmxm
 * @date 2023/7/11 15:55
 */
object Template6 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(
            label0,
            label1,
            label2,
            "java/io/UnsupportedEncodingException"
        )
        val label3 = Label()
        val label4 = Label()
        val label5 = Label()
        methodVisitor.visitTryCatchBlock(label3, label4, label5, "java/lang/NumberFormatException")
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(36, label6)
        methodVisitor.visitLdcInsn(2147483647L)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "android/os/SystemClock",
            "elapsedRealtime",
            "()J",
            false
        )
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label7 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label7)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(37, label8)
        methodVisitor.visitLdcInsn("https://www.baidu.com")
        val v0 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v0)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(38, label9)
        methodVisitor.visitLdcInsn("utf-8")
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(39, label10)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v2)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(40, label11)
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
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(41, label12)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "(I)V",
            false
        )
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(42, label13)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v5)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(45, label14)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(46, label15)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.TOP,
                "[B"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v3)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label7)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(47, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v6)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(48, label17)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        val label18 = Label()
        val label19 = Label()
        methodVisitor.visitLookupSwitchInsn(label19, intArrayOf(37, 43), arrayOf(label3, label18))
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(50, label18)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 32)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(51, label20)
        methodVisitor.visitIincInsn(v5, 1)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(52, label21)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v2)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(53, label22)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label15)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(57, label3)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        val label23 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label23)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(58, label24)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitInsn(Opcodes.IDIV)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(59, label23)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v8 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v8)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(61, label25)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            9,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B",
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v3)
        val label26 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label26)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 37)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label26)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(63, label27)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(II)Ljava/lang/String;",
            false
        )
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 16)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Integer",
            "parseInt",
            "(Ljava/lang/String;I)I",
            false
        )
        val v9 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v9)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(64, label28)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v9)
        val label29 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFGE, label29)
        val label30 = Label()
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(65, label30)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitLdcInsn("URLDecoder: Illegal hex characters in escape (%) pattern - negative value : ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitInsn(Opcodes.IADD)
        val label31 = Label()
        methodVisitor.visitLabel(label31)
        methodVisitor.visitLineNumber(66, label31)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(II)Ljava/lang/String;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/IllegalArgumentException",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(67, label29)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            10,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B",
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitIincInsn(v8, 1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v9)
        methodVisitor.visitInsn(Opcodes.I2B)
        methodVisitor.visitInsn(Opcodes.BASTORE)
        val label32 = Label()
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(68, label32)
        methodVisitor.visitIincInsn(v5, 3)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(69, label33)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v3)
        val label34 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label34)
        val label35 = Label()
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(70, label35)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v6)
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(71, label34)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            9,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B",
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label25)
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(73, label26)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            9,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B",
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v3)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 37)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label0)
        val label36 = Label()
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLineNumber(74, label36)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("URLDecoder: Incomplete trailing escape (%) pattern")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/IllegalArgumentException",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(78, label0)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            9,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B",
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/String")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/String",
            "<init>",
            "([BIILjava/lang/String;)V",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(81, label1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(79, label2)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            9,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B",
                Opcodes.INTEGER
            ),
            1,
            arrayOf<Any>("java/io/UnsupportedEncodingException")
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v9)
        val label37 = Label()
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLineNumber(80, label37)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/UnsupportedEncodingException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(86, label4)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B"
            ),
            0,
            arrayOf()
        )
        val label38 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label38)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(82, label5)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B"
            ),
            1,
            arrayOf<Any>("java/lang/NumberFormatException")
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v8)
        val label39 = Label()
        methodVisitor.visitLabel(label39)
        methodVisitor.visitLineNumber(83, label39)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitLdcInsn("URLDecoder: Illegal hex characters in escape (%) pattern - ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        val label40 = Label()
        methodVisitor.visitLabel(label40)
        methodVisitor.visitLineNumber(85, label40)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/NumberFormatException",
            "getMessage",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/IllegalArgumentException",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label38)
        methodVisitor.visitLineNumber(87, label38)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v2)
        val label41 = Label()
        methodVisitor.visitLabel(label41)
        methodVisitor.visitLineNumber(88, label41)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label15)
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(90, label19)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            8,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "[B"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label42 = Label()
        methodVisitor.visitLabel(label42)
        methodVisitor.visitLineNumber(91, label42)
        methodVisitor.visitIincInsn(v5, 1)
        val label43 = Label()
        methodVisitor.visitLabel(label43)
        methodVisitor.visitLineNumber(92, label43)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label15)
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(97, label7)
        methodVisitor.visitFrame(Opcodes.F_NEW, 0, arrayOf(), 0, arrayOf())
    }

}