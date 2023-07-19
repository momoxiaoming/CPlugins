package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template18
 *
 * @author mmxm
 * @date 2023/7/11 16:02
 */
object Template18 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(88, label0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/nio/charset/Charset",
            "defaultCharset",
            "()Ljava/nio/charset/Charset;",
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
        val label1 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label1)
        val label2 = Label()
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(89, label2)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Random")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/Random",
            "<init>",
            "()V",
            false
        )
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(90, label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Random",
            "nextInt",
            "(I)I",
            false
        )
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitInsn(Opcodes.IADD)
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v2)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(91, label4)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Random")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/Random",
            "<init>",
            "()V",
            false
        )
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(92, label5)
        methodVisitor.visitLdcInsn("abcdefghijklmnopqrstuvwxyz")
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(93, label6)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(94, label7)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v6)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v2)
        val label9 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label9)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(95, label10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 26)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Random",
            "nextInt",
            "(I)I",
            false
        )
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v7)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(96, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(94, label12)
        methodVisitor.visitIincInsn(v6, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label8)
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(99, label9)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuffer")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuffer",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v6)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(100, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(101, label14)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v8 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v8)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(102, label15)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v9 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v9)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(103, label16)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v10 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(104, label17)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        val v11 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v11)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(106, label18)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v12 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v12)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label20 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label20)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(107, label21)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v12)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        val v13 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v13)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(108, label22)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 92)
        val label23 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label23)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label23)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(109, label24)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v8)
        val label25 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label25)
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(110, label23)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 36)
        val label26 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label26)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label26)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(111, label27)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v9)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label25)
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(112, label26)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 48)
        val label28 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label28)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 57)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGT, label28)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v9)
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label28)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label28)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(113, label29)
        methodVisitor.visitLdcInsn("a")
        val v14 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v14)
        val label30 = Label()
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(114, label30)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v14)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuffer;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label31 = Label()
        methodVisitor.visitLabel(label31)
        methodVisitor.visitLineNumber(115, label31)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v9)
        val label32 = Label()
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(116, label32)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label25)
        methodVisitor.visitLabel(label28)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 123)
        val label33 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label33)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v9)
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label33)
        val label34 = Label()
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(117, label34)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        val label35 = Label()
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(118, label35)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v12)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v11)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label25)
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(119, label33)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 125)
        val label36 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label36)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v9)
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label36)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label36)
        val label37 = Label()
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLineNumber(120, label37)
        methodVisitor.visitLdcInsn("b")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v14)
        val label38 = Label()
        methodVisitor.visitLabel(label38)
        methodVisitor.visitLineNumber(121, label38)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v14)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuffer;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label39 = Label()
        methodVisitor.visitLabel(label39)
        methodVisitor.visitLineNumber(122, label39)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v9)
        val label40 = Label()
        methodVisitor.visitLabel(label40)
        methodVisitor.visitLineNumber(123, label40)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        val label41 = Label()
        methodVisitor.visitLabel(label41)
        methodVisitor.visitLineNumber(124, label41)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label25)
        methodVisitor.visitLabel(label36)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 125)
        val label42 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label42)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v9)
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label42)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label42)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label25)
        methodVisitor.visitLabel(label42)
        methodVisitor.visitLineNumber(126, label42)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v13)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "append",
            "(C)Ljava/lang/StringBuffer;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label43 = Label()
        methodVisitor.visitLabel(label43)
        methodVisitor.visitLineNumber(127, label43)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v9)
        val label44 = Label()
        methodVisitor.visitLabel(label44)
        methodVisitor.visitLineNumber(128, label44)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v8)
        val label45 = Label()
        methodVisitor.visitLabel(label45)
        methodVisitor.visitLineNumber(129, label45)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(106, label25)
        methodVisitor.visitIincInsn(v12, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label19)
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(133, label20)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        val label46 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label46)
        val label47 = Label()
        methodVisitor.visitLabel(label47)
        methodVisitor.visitLineNumber(134, label47)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("character to be escaped is missing")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/IllegalArgumentException",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label46)
        methodVisitor.visitLineNumber(137, label46)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v9)
        val label48 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label48)
        val label49 = Label()
        methodVisitor.visitLabel(label49)
        methodVisitor.visitLineNumber(138, label49)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("Illegal group reference: group index is missing")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/IllegalArgumentException",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label48)
        methodVisitor.visitLineNumber(141, label48)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label1)
        val label50 = Label()
        methodVisitor.visitLabel(label50)
        methodVisitor.visitLineNumber(142, label50)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("Missing ending brace '}' from replacement string")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/IllegalArgumentException",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(145, label1)
    }

}