package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template17
 *
 * @author mmxm
 * @date 2023/7/11 15:50
 */
object Template17 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
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
        methodVisitor.visitLineNumber(1032, label6)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(1034, label0)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/BufferedReader")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/FileReader")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("temp")
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
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(1037, label1)
        val label7 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(1035, label2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(1036, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/FileNotFoundException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(1038, label7)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/ArrayList",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(1040, label9)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(1042, label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/BufferedReader",
            "readLine",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(1045, label4)
        val label10 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label10)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(1043, label5)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(1044, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/IOException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(1046, label10)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(1047, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        val label13 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label13)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(1048, label14)
        methodVisitor.visitInsn(Opcodes.RETURN)
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(1050, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 35)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "indexOf",
            "(I)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(1051, label15)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        val label16 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFLT, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(II)Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(1052, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "trim",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(1053, label17)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(1054, label18)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        val label19 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label19)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(1055, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 32)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "indexOf",
            "(I)I",
            false
        )
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFGE, label21)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 9)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "indexOf",
            "(I)I",
            false
        )
        val label22 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFLT, label22)
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(1056, label21)
        methodVisitor.visitLdcInsn("Illegal configuration-file syntax")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(1057, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "codePointAt",
            "(I)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 7)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(1058, label23)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Character",
            "isJavaIdentifierStart",
            "(I)Z",
            false
        )
        val label24 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label24)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(1059, label25)
        methodVisitor.visitLdcInsn("Illegal provider-class name: ")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(1060, label24)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Character",
            "charCount",
            "(I)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 8)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        val label27 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label27)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(1061, label28)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "codePointAt",
            "(I)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 7)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(1062, label29)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Character",
            "isJavaIdentifierPart",
            "(I)Z",
            false
        )
        val label30 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label30)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 46)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label30)
        val label31 = Label()
        methodVisitor.visitLabel(label31)
        methodVisitor.visitLineNumber(1063, label31)
        methodVisitor.visitLdcInsn("Illegal provider-class name: ")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(1060, label30)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Character",
            "charCount",
            "(I)I",
            false
        )
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 8)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label26)
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(1066, label27)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/List",
            "add",
            "(Ljava/lang/Object;)Z",
            true
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label32 = Label()
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(1067, label32)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(1070, label19)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/io/FileNotFoundException;",
            null,
            label8,
            label7,
            2
        )
        methodVisitor.visitLocalVariable("e", "Ljava/io/IOException;", null, label11, label10, 4)
        methodVisitor.visitLocalVariable("i", "I", null, label26, label27, 8)
        methodVisitor.visitLocalVariable("cp", "I", null, label23, label19, 7)
        methodVisitor.visitLocalVariable("r", "Ljava/io/BufferedReader;", null, label0, label33, 1)
        methodVisitor.visitLocalVariable(
            "names",
            "Ljava/util/List;",
            "Ljava/util/List<Ljava/lang/String;>;",
            label9,
            label33,
            2
        )
        methodVisitor.visitLocalVariable("ln", "Ljava/lang/String;", null, label3, label33, 3)
        methodVisitor.visitLocalVariable("a", "Ljava/lang/String;", null, label12, label33, 4)
        methodVisitor.visitLocalVariable("ci", "I", null, label15, label33, 5)
        methodVisitor.visitLocalVariable("n", "I", null, label18, label33, 6)
        methodVisitor.visitMaxs(5, 9)
        methodVisitor.visitEnd()
    }

}