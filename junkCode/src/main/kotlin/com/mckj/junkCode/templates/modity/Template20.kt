package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template20
 *
 * @author mmxm
 * @date 2023/7/11 16:04
 */
object Template20 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/io/FileNotFoundException")
        val label3 = Label()
        val label4 = Label()
        val label5 = Label()
        methodVisitor.visitTryCatchBlock(label3, label4, label5, "java/io/IOException")
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(96, label6)
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
        val label7 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label7)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(97, label8)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(99, label0)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/BufferedReader")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/FileReader")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("foo.in")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/io/FileReader",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/io/BufferedReader",
            "<init>",
            "(Ljava/io/Reader;)V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(102, label1)
        val label9 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label9)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(100, label2)
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(101, label10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/FileNotFoundException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(103, label9)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/ArrayList",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(104, label11)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(106, label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/BufferedReader",
            "readLine",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(109, label4)
        val label12 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label12)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(107, label5)
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(108, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/IOException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(110, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 35)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "indexOf",
            "(I)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(111, label14)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        val label15 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFLT, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(II)Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(112, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "trim",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(113, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v5)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(114, label17)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label7)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(115, label18)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 32)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "indexOf",
            "(I)I",
            false
        )
        val label19 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFGE, label19)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 9)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "indexOf",
            "(I)I",
            false
        )
        val label20 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFLT, label20)
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(116, label19)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("Illegal configuration-file syntax")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(117, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "codePointAt",
            "(I)I",
            false
        )
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v6)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(118, label21)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Character",
            "isJavaIdentifierStart",
            "(I)Z",
            false
        )
        val label22 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label22)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(119, label23)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitLdcInsn("Illegal provider-class name: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
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
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(120, label22)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Character",
            "charCount",
            "(I)I",
            false
        )
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v7)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        val label25 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label25)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(121, label26)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "codePointAt",
            "(I)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v6)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(122, label27)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Character",
            "isJavaIdentifierPart",
            "(I)Z",
            false
        )
        val label28 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label28)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 46)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label28)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(123, label29)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitLdcInsn("Illegal provider-class name: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
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
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(120, label28)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Character",
            "charCount",
            "(I)I",
            false
        )
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v7)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label24)
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(125, label25)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/List",
            "add",
            "(Ljava/lang/Object;)Z",
            true
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(129, label7)
    }

}