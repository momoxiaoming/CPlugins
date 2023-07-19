package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template6
 *
 * @author mmxm
 * @date 2023/7/11 15:24
 */
object Template6 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(505, label0)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/HashMap")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/HashMap",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label1 = Label()
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(506, label1)
        methodVisitor.visitLdcInsn("abcdefg")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label2 = Label()
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(507, label2)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 3)
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label4 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label4)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(508, label5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 4)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(509, label6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 65)
        val label7 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 90)
        val label8 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLE, label8)
        methodVisitor.visitLabel(label7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 97)
        val label9 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label9)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 122)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGT, label9)
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(510, label8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitIincInsn(3, 1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(511, label10)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label11 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label11)
        methodVisitor.visitIincInsn(3, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label10)
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(512, label11)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(514, label12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 112)
        val label13 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label13)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(515, label14)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 7)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(516, label15)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label16 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label16)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(517, label17)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 4)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(518, label18)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 65)
        val label19 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label19)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 90)
        val label20 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLE, label20)
        methodVisitor.visitLabel(label19)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 97)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label16)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 122)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGT, label16)
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(519, label20)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 7)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(520, label21)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitIincInsn(3, 1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(521, label22)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label23 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label23)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label23)
        methodVisitor.visitIincInsn(3, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label22)
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(523, label23)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(526, label16)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label13)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(527, label24)
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
        methodVisitor.visitLdcInsn("Pad letter 'p' must be followed by valid pad pattern: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
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
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(533, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Character",
            "valueOf",
            "(C)Ljava/lang/Character;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Map",
            "get",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/time/temporal/TemporalField")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 7)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(534, label25)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 120)
        val label26 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label26)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(535, label27)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitInsn(Opcodes.ICONST_5)
        val label28 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLE, label28)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(536, label29)
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
        methodVisitor.visitLdcInsn("Too many pattern letters: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
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
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(538, label28)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        val label30 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label30)
        methodVisitor.visitLdcInsn("+00")
        val label31 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label31)
        methodVisitor.visitLabel(label30)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitInsn(Opcodes.IREM)
        val label32 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label32)
        methodVisitor.visitLdcInsn("+0000")
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label31)
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLdcInsn("+00:00")
        methodVisitor.visitLabel(label31)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 8)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(539, label33)
        val label34 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label34)
        methodVisitor.visitLabel(label26)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 87)
        val label35 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label35)
        val label36 = Label()
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLineNumber(541, label36)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLE, label34)
        val label37 = Label()
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLineNumber(542, label37)
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
        methodVisitor.visitLdcInsn("Too many pattern letters: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
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
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(544, label35)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 119)
        val label38 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label38)
        val label39 = Label()
        methodVisitor.visitLabel(label39)
        methodVisitor.visitLineNumber(546, label39)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLE, label34)
        val label40 = Label()
        methodVisitor.visitLabel(label40)
        methodVisitor.visitLineNumber(547, label40)
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
        methodVisitor.visitLdcInsn("Too many pattern letters: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
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
        methodVisitor.visitLineNumber(549, label38)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 89)
        val label41 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label41)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label34)
        methodVisitor.visitLabel(label41)
        methodVisitor.visitLineNumber(552, label41)
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
        methodVisitor.visitLdcInsn("Unknown pattern letter: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
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
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(554, label34)
        methodVisitor.visitIincInsn(3, -1)
        val label42 = Label()
        methodVisitor.visitLabel(label42)
        methodVisitor.visitLineNumber(556, label42)
        val label43 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label43)
        methodVisitor.visitLabel(label9)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 39)
        val label44 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label44)
        val label45 = Label()
        methodVisitor.visitLabel(label45)
        methodVisitor.visitLineNumber(558, label45)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitIincInsn(3, 1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label46 = Label()
        methodVisitor.visitLabel(label46)
        methodVisitor.visitLineNumber(559, label46)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label47 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label47)
        val label48 = Label()
        methodVisitor.visitLabel(label48)
        methodVisitor.visitLineNumber(560, label48)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 39)
        val label49 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label49)
        val label50 = Label()
        methodVisitor.visitLabel(label50)
        methodVisitor.visitLineNumber(561, label50)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label47)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 39)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label47)
        val label51 = Label()
        methodVisitor.visitLabel(label51)
        methodVisitor.visitLineNumber(562, label51)
        methodVisitor.visitIincInsn(3, 1)
        methodVisitor.visitLabel(label49)
        methodVisitor.visitLineNumber(559, label49)
        methodVisitor.visitIincInsn(3, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label46)
        methodVisitor.visitLabel(label47)
        methodVisitor.visitLineNumber(568, label47)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label52 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label52)
        val label53 = Label()
        methodVisitor.visitLabel(label53)
        methodVisitor.visitLineNumber(569, label53)
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
        methodVisitor.visitLdcInsn("Pattern ends with an incomplete string literal: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
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
        methodVisitor.visitLabel(label52)
        methodVisitor.visitLineNumber(571, label52)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(II)Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label54 = Label()
        methodVisitor.visitLabel(label54)
        methodVisitor.visitLineNumber(574, label54)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label43)
        methodVisitor.visitLabel(label44)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 123)
        val label55 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label55)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 125)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label55)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 35)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label43)
        methodVisitor.visitLabel(label55)
        methodVisitor.visitLineNumber(575, label55)
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
        methodVisitor.visitLdcInsn("Pattern includes reserved character: '")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn("'")
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
        methodVisitor.visitLabel(label43)
        methodVisitor.visitLineNumber(507, label43)
        methodVisitor.visitIincInsn(3, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label3)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(578, label4)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label56 = Label()
        methodVisitor.visitLabel(label56)
        methodVisitor.visitLocalVariable("pad", "I", null, label15, label13, 7)
        methodVisitor.visitLocalVariable("start", "I", null, label10, label42, 5)
        methodVisitor.visitLocalVariable("count", "I", null, label12, label42, 6)
        methodVisitor.visitLocalVariable(
            "field",
            "Ljava/time/temporal/TemporalField;",
            null,
            label25,
            label42,
            7
        )
        methodVisitor.visitLocalVariable("start", "I", null, label46, label54, 5)
        methodVisitor.visitLocalVariable("cur", "C", null, label6, label43, 4)
        methodVisitor.visitLocalVariable("pos", "I", null, label3, label4, 3)
        methodVisitor.visitLocalVariable(
            "FIELD_MAP",
            "Ljava/util/Map;",
            "Ljava/util/Map<Ljava/lang/Character;Ljava/time/temporal/TemporalField;>;",
            label1,
            label56,
            1
        )
        methodVisitor.visitLocalVariable("pattern", "Ljava/lang/String;", null, label2, label56, 2)
        methodVisitor.visitMaxs(4, 9)
        methodVisitor.visitEnd()
    }
}