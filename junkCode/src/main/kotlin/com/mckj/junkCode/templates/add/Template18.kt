package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template18
 *
 * @author mmxm
 * @date 2023/7/11 15:51
 */
object Template18 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/Exception")
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(1073, label3)
        methodVisitor.visitLdcInsn("abcdefghijk")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(1074, label4)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/StringBuffer")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(1075, label5)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 3)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val label7 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label7)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(1076, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuffer")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuffer",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitInsn(Opcodes.AASTORE)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(1075, label9)
        methodVisitor.visitIincInsn(3, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label6)
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(1078, label7)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 30)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_DOUBLE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(1079, label10)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 30)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/String")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(1080, label11)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(1081, label12)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(1082, label13)
        methodVisitor.visitInsn(Opcodes.DCONST_0)
        methodVisitor.visitVarInsn(Opcodes.DSTORE, 7)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(1083, label14)
        methodVisitor.visitLdcInsn(Double.NaN)
        methodVisitor.visitVarInsn(Opcodes.DSTORE, 9)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(1084, label15)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 11)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(1085, label16)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 12)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label18 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label18)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(1086, label19)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 12)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 13)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(1087, label20)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 39)
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label21)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(1089, label22)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 12)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label23 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label23)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 12)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label23)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(1090, label24)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "append",
            "(C)Ljava/lang/StringBuffer;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(1091, label25)
        methodVisitor.visitIincInsn(12, 1)
        val label26 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label26)
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(1093, label23)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 11)
        val label27 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label27)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        val label28 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label28)
        methodVisitor.visitLabel(label27)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLabel(label28)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 11)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label26)
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(1095, label21)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 11)
        val label29 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label29)
        val label30 = Label()
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(1096, label30)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "append",
            "(C)Ljava/lang/StringBuffer;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label26)
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(1097, label29)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 60)
        val label31 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label31)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 35)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label31)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 8804)
        val label32 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label32)
        methodVisitor.visitLabel(label31)
        methodVisitor.visitLineNumber(1098, label31)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "length",
            "()I",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label0)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(1099, label33)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/IllegalArgumentException",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(1102, label0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 14)
        val label34 = Label()
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(1103, label34)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 14)
        methodVisitor.visitLdcInsn("\u221e")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label35 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label35)
        val label36 = Label()
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLineNumber(1104, label36)
        methodVisitor.visitLdcInsn(Double.POSITIVE_INFINITY)
        methodVisitor.visitVarInsn(Opcodes.DSTORE, 7)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label1)
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(1105, label35)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 14)
        methodVisitor.visitLdcInsn("-\u221e")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label37 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label37)
        val label38 = Label()
        methodVisitor.visitLabel(label38)
        methodVisitor.visitLineNumber(1106, label38)
        methodVisitor.visitLdcInsn(Double.NEGATIVE_INFINITY)
        methodVisitor.visitVarInsn(Opcodes.DSTORE, 7)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label1)
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLineNumber(1109, label37)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Double",
            "parseDouble",
            "(Ljava/lang/String;)D",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.DSTORE, 7)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(1113, label1)
        val label39 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label39)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(1111, label2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 14)
        val label40 = Label()
        methodVisitor.visitLabel(label40)
        methodVisitor.visitLineNumber(1112, label40)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/IllegalArgumentException",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label39)
        methodVisitor.visitLineNumber(1114, label39)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 60)
        val label41 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label41)
        methodVisitor.visitVarInsn(Opcodes.DLOAD, 7)
        methodVisitor.visitLdcInsn(Double.POSITIVE_INFINITY)
        methodVisitor.visitInsn(Opcodes.DCMPL)
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label41)
        methodVisitor.visitVarInsn(Opcodes.DLOAD, 7)
        methodVisitor.visitLdcInsn(Double.NEGATIVE_INFINITY)
        methodVisitor.visitInsn(Opcodes.DCMPL)
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label41)
        val label42 = Label()
        methodVisitor.visitLabel(label42)
        methodVisitor.visitLineNumber(1116, label42)
        methodVisitor.visitVarInsn(Opcodes.DLOAD, 7)
        methodVisitor.visitVarInsn(Opcodes.DSTORE, 7)
        methodVisitor.visitLabel(label41)
        methodVisitor.visitLineNumber(1118, label41)
        methodVisitor.visitVarInsn(Opcodes.DLOAD, 7)
        methodVisitor.visitVarInsn(Opcodes.DLOAD, 9)
        methodVisitor.visitInsn(Opcodes.DCMPG)
        val label43 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFGT, label43)
        val label44 = Label()
        methodVisitor.visitLabel(label44)
        methodVisitor.visitLineNumber(1119, label44)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/IllegalArgumentException",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label43)
        methodVisitor.visitLineNumber(1121, label43)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "setLength",
            "(I)V",
            false
        )
        val label45 = Label()
        methodVisitor.visitLabel(label45)
        methodVisitor.visitLineNumber(1122, label45)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label26)
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(1123, label32)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 124)
        val label46 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label46)
        val label47 = Label()
        methodVisitor.visitLabel(label47)
        methodVisitor.visitLineNumber(1124, label47)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val label48 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label48)
        methodVisitor.visitLabel(label48)
        methodVisitor.visitLineNumber(1127, label48)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.DLOAD, 7)
        methodVisitor.visitInsn(Opcodes.DASTORE)
        val label49 = Label()
        methodVisitor.visitLabel(label49)
        methodVisitor.visitLineNumber(1128, label49)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitInsn(Opcodes.AASTORE)
        val label50 = Label()
        methodVisitor.visitLabel(label50)
        methodVisitor.visitLineNumber(1129, label50)
        methodVisitor.visitIincInsn(5, 1)
        val label51 = Label()
        methodVisitor.visitLabel(label51)
        methodVisitor.visitLineNumber(1130, label51)
        methodVisitor.visitVarInsn(Opcodes.DLOAD, 7)
        methodVisitor.visitVarInsn(Opcodes.DSTORE, 9)
        val label52 = Label()
        methodVisitor.visitLabel(label52)
        methodVisitor.visitLineNumber(1131, label52)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "setLength",
            "(I)V",
            false
        )
        val label53 = Label()
        methodVisitor.visitLabel(label53)
        methodVisitor.visitLineNumber(1132, label53)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label26)
        methodVisitor.visitLabel(label46)
        methodVisitor.visitLineNumber(1134, label46)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "append",
            "(C)Ljava/lang/StringBuffer;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(1085, label26)
        methodVisitor.visitIincInsn(12, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label17)
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(1138, label18)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        val label54 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label54)
        val label55 = Label()
        methodVisitor.visitLabel(label55)
        methodVisitor.visitLineNumber(1139, label55)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val label56 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label56)
        methodVisitor.visitLabel(label56)
        methodVisitor.visitLineNumber(1142, label56)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.DLOAD, 7)
        methodVisitor.visitInsn(Opcodes.DASTORE)
        val label57 = Label()
        methodVisitor.visitLabel(label57)
        methodVisitor.visitLineNumber(1143, label57)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuffer",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitInsn(Opcodes.AASTORE)
        val label58 = Label()
        methodVisitor.visitLabel(label58)
        methodVisitor.visitLineNumber(1144, label58)
        methodVisitor.visitIincInsn(5, 1)
        methodVisitor.visitLabel(label54)
        methodVisitor.visitLineNumber(1147, label54)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label59 = Label()
        methodVisitor.visitLabel(label59)
        methodVisitor.visitLocalVariable("i", "I", null, label6, label7, 3)
        methodVisitor.visitLocalVariable(
            "tempBuffer",
            "Ljava/lang/String;",
            null,
            label34,
            label1,
            14
        )
        methodVisitor.visitLocalVariable("e", "Ljava/lang/Exception;", null, label40, label39, 14)
        methodVisitor.visitLocalVariable("ch", "C", null, label20, label26, 13)
        methodVisitor.visitLocalVariable("i", "I", null, label17, label18, 12)
        methodVisitor.visitLocalVariable(
            "newPattern",
            "Ljava/lang/String;",
            null,
            label4,
            label59,
            1
        )
        methodVisitor.visitLocalVariable(
            "segments",
            "[Ljava/lang/StringBuffer;",
            null,
            label5,
            label59,
            2
        )
        methodVisitor.visitLocalVariable("newChoiceLimits", "[D", null, label10, label59, 3)
        methodVisitor.visitLocalVariable(
            "newChoiceFormats",
            "[Ljava/lang/String;",
            null,
            label11,
            label59,
            4
        )
        methodVisitor.visitLocalVariable("count", "I", null, label12, label59, 5)
        methodVisitor.visitLocalVariable("part", "I", null, label13, label59, 6)
        methodVisitor.visitLocalVariable("startValue", "D", null, label14, label59, 7)
        methodVisitor.visitLocalVariable("oldStartValue", "D", null, label15, label59, 9)
        methodVisitor.visitLocalVariable("inQuote", "Z", null, label16, label59, 11)
        methodVisitor.visitMaxs(4, 15)
        methodVisitor.visitEnd()
    }

}