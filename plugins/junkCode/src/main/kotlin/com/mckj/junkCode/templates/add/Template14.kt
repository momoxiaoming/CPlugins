package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template14
 *
 * @author mmxm
 * @date 2023/7/11 15:48
 */
object Template14 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(820, label0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/security/KeyStore",
            "getDefaultType",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label1 = Label()
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(822, label1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/security/KeyStore",
            "getDefaultType",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label2 = Label()
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(823, label2)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        val label3 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label3)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(824, label4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/security/KeyStore",
            "getInstance",
            "(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyStore;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        val label6 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label6)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(827, label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/security/KeyStore",
            "getInstance",
            "(Ljava/lang/String;)Ljava/security/KeyStore;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(829, label6)
        methodVisitor.visitLdcInsn("stdin")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(831, label7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/nio/charset/Charset",
            "defaultCharset",
            "()Ljava/nio/charset/Charset;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(832, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        val label9 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label9)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/nio/charset/Charset")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitInsn(Opcodes.AASTORE)
        val label10 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label10)
        methodVisitor.visitLabel(label9)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/nio/charset/Charset")
        methodVisitor.visitLabel(label10)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(833, label11)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/ArrayList",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 7)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(834, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        methodVisitor.visitLdcInsn("  for ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "toCharArray",
            "()[C",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/List",
            "add",
            "(Ljava/lang/Object;)Z",
            true
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(835, label13)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 8)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(837, label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/security/KeyStore",
            "aliases",
            "()Ljava/util/Enumeration;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 9)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(838, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 9)
        val label16 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label16)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(839, label17)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 9)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Enumeration",
            "hasMoreElements",
            "()Z",
            true
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label16)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(840, label18)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 9)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Enumeration",
            "nextElement",
            "()Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/String")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 10)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(841, label19)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/security/KeyStore",
            "isKeyEntry",
            "(Ljava/lang/String;)Z",
            false
        )
        val label20 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label20)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(843, label21)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(844, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/security/KeyStore",
            "isKeyEntry",
            "(Ljava/lang/String;)Z",
            false
        )
        val label23 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label23)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(845, label24)
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
        methodVisitor.visitLdcInsn(" entry \"")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn("\" does not contain a ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 6)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
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
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(847, label23)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/security/KeyStore",
            "getCertificateChain",
            "(Ljava/lang/String;)[Ljava/security/cert/Certificate;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 11)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(848, label25)
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
        methodVisitor.visitLdcInsn(" entry \"")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn("\" does not contain a ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 11)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
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
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(850, label20)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label17)
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(852, label16)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLocalVariable(
            "keyStore",
            "Ljava/security/KeyStore;",
            null,
            label5,
            label3,
            1
        )
        methodVisitor.visitLocalVariable(
            "certificateChain",
            "[Ljava/security/cert/Certificate;",
            null,
            label25,
            label20,
            11
        )
        methodVisitor.visitLocalVariable(
            "nextElement",
            "Ljava/lang/String;",
            null,
            label19,
            label20,
            10
        )
        methodVisitor.visitLocalVariable(
            "keyStore",
            "Ljava/security/KeyStore;",
            null,
            label6,
            label26,
            1
        )
        methodVisitor.visitLocalVariable("str", "Ljava/lang/String;", null, label1, label26, 2)
        methodVisitor.visitLocalVariable("str2", "Ljava/lang/String;", null, label2, label26, 3)
        methodVisitor.visitLocalVariable("str4", "Ljava/lang/String;", null, label7, label26, 4)
        methodVisitor.visitLocalVariable(
            "charset",
            "Ljava/nio/charset/Charset;",
            null,
            label8,
            label26,
            5
        )
        methodVisitor.visitLocalVariable(
            "charsetArr",
            "[Ljava/nio/charset/Charset;",
            null,
            label11,
            label26,
            6
        )
        methodVisitor.visitLocalVariable(
            "m11145",
            "Ljava/util/List;",
            "Ljava/util/List<[C>;",
            label12,
            label26,
            7
        )
        methodVisitor.visitLocalVariable("str5", "Ljava/lang/String;", null, label14, label26, 8)
        methodVisitor.visitLocalVariable(
            "aliases",
            "Ljava/util/Enumeration;",
            "Ljava/util/Enumeration<Ljava/lang/String;>;",
            label15,
            label26,
            9
        )
        methodVisitor.visitMaxs(4, 12)
        methodVisitor.visitEnd()
    }

}