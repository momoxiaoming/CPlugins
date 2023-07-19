package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template19
 *
 * @author mmxm
 * @date 2023/7/11 15:51
 */
object Template19 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(1151, label0)
        methodVisitor.visitInsn(Opcodes.ICONST_5)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/String")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLdcInsn("")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitLdcInsn("short")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitLdcInsn("medium")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitLdcInsn("long")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_4)
        methodVisitor.visitLdcInsn("full")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label1 = Label()
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(1158, label1)
        methodVisitor.visitInsn(Opcodes.ICONST_5)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_INT)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitInsn(Opcodes.IASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitInsn(Opcodes.IASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitInsn(Opcodes.IASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_4)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.IASTORE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label2 = Label()
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(1165, label2)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 3)
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(1166, label3)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(1167, label4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 10)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(1168, label5)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_INT)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(1169, label6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/text/Format")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 7)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(1170, label7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 8)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(1172, label8)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 9)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(1173, label9)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 10)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(1174, label10)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 11)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 11)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 8)
        val label12 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGT, label12)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(1177, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 11)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 12)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(1178, label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        val label15 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label15)
        val label16 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label16)
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(1180, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, "java/text/NumberFormat")
        val label17 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label17)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(1181, label18)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/text/NumberFormat",
            "getInstance",
            "(Ljava/util/Locale;)Ljava/text/NumberFormat;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Object",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label19 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label19)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(1182, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitLdcInsn(",number")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label16)
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(1183, label19)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/text/NumberFormat",
            "getCurrencyInstance",
            "(Ljava/util/Locale;)Ljava/text/NumberFormat;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Object",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label21)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(1184, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitLdcInsn(",number,currency")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label16)
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(1185, label21)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/text/NumberFormat",
            "getPercentInstance",
            "(Ljava/util/Locale;)Ljava/text/NumberFormat;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Object",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label23 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label23)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(1186, label24)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitLdcInsn(",number,percent")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label16)
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(1187, label23)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/text/NumberFormat",
            "getIntegerInstance",
            "(Ljava/util/Locale;)Ljava/text/NumberFormat;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Object",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label25 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label25)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(1188, label26)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitLdcInsn(",number,integer")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label16)
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(1190, label25)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, "java/text/DecimalFormat")
        val label27 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label27)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(1191, label28)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitLdcInsn(",number,")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/text/DecimalFormat")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/text/DecimalFormat",
            "toPattern",
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
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label16)
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(1192, label27)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, "java/text/ChoiceFormat")
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label16)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(1193, label29)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitLdcInsn(",choice,")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/text/ChoiceFormat")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/text/ChoiceFormat",
            "toPattern",
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
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label16)
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(1198, label17)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, "java/text/DateFormat")
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label16)
        val label30 = Label()
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(1200, label30)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 13)
        val label31 = Label()
        methodVisitor.visitLabel(label31)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val label32 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label32)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(1201, label33)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitInsn(Opcodes.IALOAD)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/text/DateFormat",
            "getDateInstance",
            "(ILjava/util/Locale;)Ljava/text/DateFormat;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 14)
        val label34 = Label()
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(1203, label34)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 14)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Object",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label35 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label35)
        val label36 = Label()
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLineNumber(1204, label36)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitLdcInsn(",date")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label37 = Label()
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLineNumber(1205, label37)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label32)
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(1207, label35)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitInsn(Opcodes.IALOAD)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/text/DateFormat",
            "getTimeInstance",
            "(ILjava/util/Locale;)Ljava/text/DateFormat;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 14)
        val label38 = Label()
        methodVisitor.visitLabel(label38)
        methodVisitor.visitLineNumber(1209, label38)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 14)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Object",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label39 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label39)
        val label40 = Label()
        methodVisitor.visitLabel(label40)
        methodVisitor.visitLineNumber(1210, label40)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitLdcInsn(",time")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label41 = Label()
        methodVisitor.visitLabel(label41)
        methodVisitor.visitLineNumber(1211, label41)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label32)
        methodVisitor.visitLabel(label39)
        methodVisitor.visitLineNumber(1200, label39)
        methodVisitor.visitIincInsn(13, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label31)
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(1214, label32)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val label42 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label42)
        val label43 = Label()
        methodVisitor.visitLabel(label43)
        methodVisitor.visitLineNumber(1215, label43)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, "java/text/SimpleDateFormat")
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label16)
        val label44 = Label()
        methodVisitor.visitLabel(label44)
        methodVisitor.visitLineNumber(1216, label44)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitLdcInsn(",date,")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/text/SimpleDateFormat")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/text/SimpleDateFormat",
            "toPattern",
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
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label16)
        methodVisitor.visitLabel(label42)
        methodVisitor.visitLineNumber(1219, label42)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label16)
        val label45 = Label()
        methodVisitor.visitLabel(label45)
        methodVisitor.visitLineNumber(1220, label45)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 44)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 13)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(1224, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 125)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label46 = Label()
        methodVisitor.visitLabel(label46)
        methodVisitor.visitLineNumber(1174, label46)
        methodVisitor.visitIincInsn(11, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label11)
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(1227, label12)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label47 = Label()
        methodVisitor.visitLabel(label47)
        methodVisitor.visitLocalVariable("df", "Ljava/text/DateFormat;", null, label34, label39, 14)
        methodVisitor.visitLocalVariable("index", "I", null, label31, label16, 13)
        methodVisitor.visitLocalVariable("fmt", "Ljava/text/Format;", null, label14, label46, 12)
        methodVisitor.visitLocalVariable("i", "I", null, label11, label12, 11)
        methodVisitor.visitLocalVariable(
            "DATE_TIME_MODIFIER_KEYWORDS",
            "[Ljava/lang/String;",
            null,
            label1,
            label47,
            1
        )
        methodVisitor.visitLocalVariable("DATE_TIME_MODIFIERS", "[I", null, label2, label47, 2)
        methodVisitor.visitLocalVariable("MODIFIER_DEFAULT", "I", null, label3, label47, 3)
        methodVisitor.visitLocalVariable("locale", "Ljava/util/Locale;", null, label4, label47, 4)
        methodVisitor.visitLocalVariable("INITIAL_FORMATS", "I", null, label5, label47, 5)
        methodVisitor.visitLocalVariable("offsets", "[I", null, label6, label47, 6)
        methodVisitor.visitLocalVariable("formats", "[Ljava/text/Format;", null, label7, label47, 7)
        methodVisitor.visitLocalVariable("maxOffset", "I", null, label8, label47, 8)
        methodVisitor.visitLocalVariable("lastOffset", "I", null, label9, label47, 9)
        methodVisitor.visitLocalVariable(
            "result",
            "Ljava/lang/StringBuilder;",
            null,
            label10,
            label47,
            10
        )
        methodVisitor.visitMaxs(4, 15)
        methodVisitor.visitEnd()
    }

}