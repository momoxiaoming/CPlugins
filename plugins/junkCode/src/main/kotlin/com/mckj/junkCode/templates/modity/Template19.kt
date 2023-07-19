package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template19
 *
 * @author mmxm
 * @date 2023/7/11 16:02
 */
object Template19 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(89, label0)
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
        methodVisitor.visitLineNumber(90, label2)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Random")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/Random",
            "<init>",
            "()V",
            false
        )
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
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v1)
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(91, label3)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Random")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/Random",
            "<init>",
            "()V",
            false
        )
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(92, label4)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(93, label5)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        val label7 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label7)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(94, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitLdcInsn("abcdefghijklmnopqrstuvwxyz")
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 26)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Random",
            "nextInt",
            "(I)I",
            false
        )
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
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(93, label9)
        methodVisitor.visitIincInsn(v4, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label6)
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(96, label7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(98, label10)
        methodVisitor.visitLdcInsn("\\,")
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(99, label11)
        methodVisitor.visitLdcInsn("\\.")
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v6)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(100, label12)
        methodVisitor.visitLdcInsn("\\-")
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(101, label13)
        methodVisitor.visitLdcInsn("")
        val v8 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v8)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(102, label14)
        methodVisitor.visitLdcInsn("NaN")
        val v9 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v9)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(103, label15)
        methodVisitor.visitLdcInsn("Infinity")
        val v10 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v10)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(104, label16)
        methodVisitor.visitLdcInsn("[\\p{javaDigit}&&[^0-9]]")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/regex/Pattern",
            "compile",
            "(Ljava/lang/String;)Ljava/util/regex/Pattern;",
            false
        )
        val v11 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v11)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(107, label17)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitLdcInsn("")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "replaceAll",
            "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            false
        )
        val v12 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v12)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(108, label18)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v13 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v13)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(109, label19)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val v14 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v14)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(110, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "startsWith",
            "(Ljava/lang/String;)Z",
            false
        )
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label21)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(111, label22)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v13)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(112, label23)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v14)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(I)Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v12)
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(114, label21)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label24 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label24)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(115, label25)
        methodVisitor.visitLdcInsn("NaN")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v12)
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(116, label24)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v10)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label26 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label26)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(117, label27)
        methodVisitor.visitLdcInsn("Infinity")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v12)
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(118, label26)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v12)
        methodVisitor.visitLdcInsn("\u221e")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label28 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label28)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(119, label29)
        methodVisitor.visitLdcInsn("Infinity")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v12)
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(120, label28)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v13)
        val label30 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label30)
        val label31 = Label()
        methodVisitor.visitLabel(label31)
        methodVisitor.visitLineNumber(121, label31)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitLdcInsn("-")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v12)
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
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v12)
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(123, label30)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v12)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/regex/Pattern",
            "matcher",
            "(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;",
            false
        )
        val v15 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v15)
        val label32 = Label()
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(124, label32)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/regex/Matcher",
            "find",
            "()Z",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label1)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(125, label33)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        val v16 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v16)
        val label34 = Label()
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(126, label34)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v17 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v17)
        val label35 = Label()
        methodVisitor.visitLabel(label35)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v17)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v12)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label36 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label36)
        val label37 = Label()
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLineNumber(127, label37)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v17)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        val v18 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v18)
        val label38 = Label()
        methodVisitor.visitLabel(label38)
        methodVisitor.visitLineNumber(128, label38)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v18)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Character",
            "isDigit",
            "(C)Z",
            false
        )
        val label39 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label39)
        val label40 = Label()
        methodVisitor.visitLabel(label40)
        methodVisitor.visitLineNumber(129, label40)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v18)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 10)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Character",
            "digit",
            "(CI)I",
            false
        )
        val v19 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v19)
        val label41 = Label()
        methodVisitor.visitLabel(label41)
        methodVisitor.visitLineNumber(130, label41)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v19)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        val label42 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label42)
        val label43 = Label()
        methodVisitor.visitLabel(label43)
        methodVisitor.visitLineNumber(131, label43)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v16)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v19)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label44 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label44)
        methodVisitor.visitLabel(label42)
        methodVisitor.visitLineNumber(133, label42)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v16)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v18)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label44)
        methodVisitor.visitLineNumber(134, label44)
        val label45 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label45)
        methodVisitor.visitLabel(label39)
        methodVisitor.visitLineNumber(135, label39)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v16)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v18)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(C)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label45)
        methodVisitor.visitLineNumber(126, label45)
        methodVisitor.visitIincInsn(v17, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label35)
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLineNumber(138, label36)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v16)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v12)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(143, label1)
    }

}