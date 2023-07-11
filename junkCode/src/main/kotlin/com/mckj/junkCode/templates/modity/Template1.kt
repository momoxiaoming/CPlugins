package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type

/**
 * Template1
 *
 * @author mmxm
 * @date 2023/7/11 15:26
 */
object Template1 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        //     Label label1 = new Label();
//     Label label2 = new Label();
//     methodVisitor.visitTryCatchBlock(label0, label1, label2, null);
//     Label label3 = new Label();
//     methodVisitor.visitTryCatchBlock(label2, label3, label2, null);
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(102, label4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "currentTimeMillis",
            "()J",
            false
        )
        methodVisitor.visitLdcInsn(86400000L)
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label5 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label5)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(104, label6)
        methodVisitor.visitLdcInsn(Type.getType("Ljava/awt/font/NumericShaper;"))
        methodVisitor.visitInsn(Opcodes.DUP)
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        methodVisitor.visitInsn(Opcodes.MONITORENTER)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(105, label0)
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
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v5)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(106, label7)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 18)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_CHAR)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 1584)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 1728)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 2358)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 2486)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_4)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 2614)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_5)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 2742)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 6)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 2870)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 7)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 2998)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 8)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 3126)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 9)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 3254)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 10)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 3382)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 11)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 3616)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 12)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 3744)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 13)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 3824)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 14)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 4112)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 15)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 4920)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 16)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 6064)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 6112)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v6)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(126, label8)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Random")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/Random",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 30)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Random",
            "nextInt",
            "(I)I",
            false
        )
        methodVisitor.visitInsn(Opcodes.ISHL)
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v7)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(128, label9)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitInsn(Opcodes.ISHL)
        methodVisitor.visitInsn(Opcodes.IAND)
        val label10 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label10)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(129, label11)
        methodVisitor.visitLdcInsn(-2147483648)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v5)
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(131, label10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitInsn(Opcodes.CALOAD)
        val v8 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v8)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(132, label12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 16)
        val label13 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 49)
        val label14 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label14)
        methodVisitor.visitLabel(label13)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 48)
        methodVisitor.visitLabel(label14)
        val v9 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v9)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(133, label15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/Calendar",
            "getInstance",
            "()Ljava/util/Calendar;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Calendar",
            "getTime",
            "()Ljava/util/Date;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Date",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "toCharArray",
            "()[C",
            false
        )
        val v10 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v10)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(134, label16)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v11 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v11)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v11)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        val label18 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label18)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(135, label19)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v10)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v11)
        methodVisitor.visitInsn(Opcodes.CALOAD)
        val v12 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v12)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(136, label20)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v9)
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label21)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v12)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 57)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGT, label21)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(137, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v10)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v11)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitInsn(Opcodes.I2C)
        methodVisitor.visitInsn(Opcodes.CASTORE)
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(134, label21)
        methodVisitor.visitIincInsn(v11, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label17)
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(141, label18)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitInsn(Opcodes.MONITOREXIT)

//     methodVisitor.visitLabel(label1);
//     methodVisitor.visitJumpInsn(GOTO, label5);
//
//     methodVisitor.visitLabel(label2);
//     methodVisitor.visitVarInsn(ASTORE, 13);
//     methodVisitor.visitVarInsn(ALOAD, 4);
//     methodVisitor.visitInsn(MONITOREXIT);
//
//     methodVisitor.visitLabel(label3);
//     methodVisitor.visitVarInsn(ALOAD, 13);
//     methodVisitor.visitInsn(ATHROW);
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(149, label5)
//     methodVisitor.visitInsn(RETURN);
//     Label label23 = new Label();
//     methodVisitor.visitLabel(label23);
//     methodVisitor.visitLocalVariable("c", "C", null, label20, label21, v12);
//     methodVisitor.visitLocalVariable("i", "I", null, label17, label18, v11);
//     methodVisitor.visitLocalVariable("ctxKey", "I", null, label7, label18, v5);
//     methodVisitor.visitLocalVariable("bases", "[C", null, label8, label18, v6);
//     methodVisitor.visitLocalVariable("mask", "I", null, label9, label18, v7);
//     methodVisitor.visitLocalVariable("base", "I", null, label12, label18, v8);
//     methodVisitor.visitLocalVariable("minDigit", "C", null, label15, label18, v9);
//     methodVisitor.visitLocalVariable("text", "[C", null, label16, label18, v10);
//     methodVisitor.visitLocalVariable("this", "Lcom/dn/junkcode/MainActivity;", null, label4, label23, 0);
//     methodVisitor.visitLocalVariable("context", "Landroid/content/Context;", null, label4, label23, 1);
//     methodVisitor.visitLocalVariable("str", "Ljava/lang/String;", null, label4, label23, 2);
//     methodVisitor.visitLocalVariable("str2", "Ljava/lang/String;", null, label4, label23, 3);
    }
}