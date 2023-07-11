package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template13
 *
 * @author mmxm
 * @date 2023/7/11 15:46
 */
object Template13 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/Exception")
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(737, label3)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/String")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitLdcInsn("b")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 0)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(738, label4)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(739, label5)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 2)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(740, label6)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(741, label7)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 4)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(742, label8)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(743, label9)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(744, label10)
        methodVisitor.visitLdcInsn(2147483647)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 7)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(745, label11)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 8)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(746, label12)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 9)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(747, label13)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 10)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(748, label14)
        methodVisitor.visitLdcInsn("min-sdk-version")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 11)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(749, label15)
        methodVisitor.visitLdcInsn("Mininimum")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(750, label16)
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
            "nextBoolean",
            "()Z",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 8)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(751, label17)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 10)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(752, label18)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/File")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("/temp/apk")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/io/File",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(753, label19)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 15)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/String")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_4)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_5)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 6)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 7)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 8)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 9)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 10)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 11)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 12)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 13)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 14)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 0)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(756, label0)
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
            "nextBoolean",
            "()Z",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 12)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(757, label20)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 12)
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label21)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(758, label22)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/ArrayList",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 13)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(759, label23)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 8)
        val label24 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label24)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(760, label25)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("using")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(761, label26)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn(" using v1 scheme (JAR signing): ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(762, label27)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn(" using v2 scheme (APK Signature Scheme v2): ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(763, label28)
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
        methodVisitor.visitLdcInsn("Number of signers: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 13)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/List",
            "size",
            "()I",
            true
        )
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
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(764, label29)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 13)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/List",
            "iterator",
            "()Ljava/util/Iterator;",
            true
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 14)
        val label30 = Label()
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(766, label30)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 15)
        val label31 = Label()
        methodVisitor.visitLabel(label31)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            16,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                "java/util/List",
                "java/util/Iterator",
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 14)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Iterator",
            "hasNext",
            "()Z",
            true
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label24)
        val label32 = Label()
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(767, label32)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 14)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Iterator",
            "next",
            "()Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/security/cert/X509Certificate")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 16)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(768, label33)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 15)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 15)
        val label34 = Label()
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(769, label34)
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
        methodVisitor.visitLdcInsn("Signer #")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn(" certificate DN: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 16)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/security/cert/X509Certificate",
            "getSubjectDN",
            "()Ljava/security/Principal;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/Object;)Ljava/lang/StringBuilder;",
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
        val label35 = Label()
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(770, label35)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 16)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/security/cert/X509Certificate",
            "getEncoded",
            "()[B",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 17)
        val label36 = Label()
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLineNumber(771, label36)
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
        methodVisitor.visitLdcInsn("Signer #")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn(" certificate SHA-256 digest: ")
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
        val label37 = Label()
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLineNumber(772, label37)
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
        methodVisitor.visitLdcInsn("Signer #")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn(" certificate SHA-1 digest: ")
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
        val label38 = Label()
        methodVisitor.visitLabel(label38)
        methodVisitor.visitLineNumber(773, label38)
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
        methodVisitor.visitLdcInsn("Signer #")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn(" certificate MD5 digest: ")
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
        val label39 = Label()
        methodVisitor.visitLabel(label39)
        methodVisitor.visitLineNumber(774, label39)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 16)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/security/cert/X509Certificate",
            "getPublicKey",
            "()Ljava/security/PublicKey;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 18)
        val label40 = Label()
        methodVisitor.visitLabel(label40)
        methodVisitor.visitLineNumber(775, label40)
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
        methodVisitor.visitLdcInsn("Signer #")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn(" key algorithm: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 18)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/security/PublicKey",
            "getAlgorithm",
            "()Ljava/lang/String;",
            true
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
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        val label41 = Label()
        methodVisitor.visitLabel(label41)
        methodVisitor.visitLineNumber(777, label41)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 18)
        methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, "java/security/interfaces/RSAKey")
        val label42 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label42)
        val label43 = Label()
        methodVisitor.visitLabel(label43)
        methodVisitor.visitLineNumber(778, label43)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 18)
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/security/interfaces/RSAKey")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/security/interfaces/RSAKey",
            "getModulus",
            "()Ljava/math/BigInteger;",
            true
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/math/BigInteger",
            "bitLength",
            "()I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 19)
        val label44 = Label()
        methodVisitor.visitLabel(label44)
        val label45 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label45)
        methodVisitor.visitLabel(label42)
        methodVisitor.visitLineNumber(779, label42)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            19,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                "java/util/List",
                "java/util/Iterator",
                Opcodes.INTEGER,
                "java/security/cert/X509Certificate",
                "[B",
                "java/security/PublicKey"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 18)
        methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, "java/security/interfaces/ECKey")
        val label46 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label46)
        val label47 = Label()
        methodVisitor.visitLabel(label47)
        methodVisitor.visitLineNumber(780, label47)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 18)
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/security/interfaces/ECKey")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/security/interfaces/ECKey",
            "getParams",
            "()Ljava/security/spec/ECParameterSpec;",
            true
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/security/spec/ECParameterSpec",
            "getOrder",
            "()Ljava/math/BigInteger;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/math/BigInteger",
            "bitLength",
            "()I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 19)
        val label48 = Label()
        methodVisitor.visitLabel(label48)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label45)
        methodVisitor.visitLabel(label46)
        methodVisitor.visitLineNumber(783, label46)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            19,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                "java/util/List",
                "java/util/Iterator",
                Opcodes.INTEGER,
                "java/security/cert/X509Certificate",
                "[B",
                "java/security/PublicKey"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 18)
        methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, "java/security/interfaces/DSAKey")
        val label49 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label49)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 18)
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/security/interfaces/DSAKey")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/security/interfaces/DSAKey",
            "getParams",
            "()Ljava/security/interfaces/DSAParams;",
            true
        )
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 20)
        val label50 = Label()
        methodVisitor.visitLabel(label50)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label49)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 20)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/security/interfaces/DSAParams",
            "getP",
            "()Ljava/math/BigInteger;",
            true
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/math/BigInteger",
            "bitLength",
            "()I",
            false
        )
        val label51 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label51)
        methodVisitor.visitLabel(label49)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            19,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                "java/util/List",
                "java/util/Iterator",
                Opcodes.INTEGER,
                "java/security/cert/X509Certificate",
                "[B",
                "java/security/PublicKey"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        methodVisitor.visitLabel(label51)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            19,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                "java/util/List",
                "java/util/Iterator",
                Opcodes.INTEGER,
                "java/security/cert/X509Certificate",
                "[B",
                "java/security/PublicKey"
            ),
            1,
            arrayOf<Any>(
                Opcodes.INTEGER
            )
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 19)
        methodVisitor.visitLabel(label45)
        methodVisitor.visitLineNumber(786, label45)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            20,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                "java/util/List",
                "java/util/Iterator",
                Opcodes.INTEGER,
                "java/security/cert/X509Certificate",
                "[B",
                "java/security/PublicKey",
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 20)
        val label52 = Label()
        methodVisitor.visitLabel(label52)
        methodVisitor.visitLineNumber(787, label52)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 21)
        val label53 = Label()
        methodVisitor.visitLabel(label53)
        methodVisitor.visitLineNumber(788, label53)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 21)
        methodVisitor.visitLdcInsn("Signer #")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label54 = Label()
        methodVisitor.visitLabel(label54)
        methodVisitor.visitLineNumber(789, label54)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 21)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label55 = Label()
        methodVisitor.visitLabel(label55)
        methodVisitor.visitLineNumber(790, label55)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 21)
        methodVisitor.visitLdcInsn(" key size (bits): ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label56 = Label()
        methodVisitor.visitLabel(label56)
        methodVisitor.visitLineNumber(791, label56)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 21)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 19)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        val label57 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label57)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 19)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/String",
            "valueOf",
            "(I)Ljava/lang/String;",
            false
        )
        val label58 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label58)
        methodVisitor.visitLabel(label57)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            22,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                "java/util/List",
                "java/util/Iterator",
                Opcodes.INTEGER,
                "java/security/cert/X509Certificate",
                "[B",
                "java/security/PublicKey",
                Opcodes.INTEGER,
                "java/io/PrintStream",
                "java/lang/StringBuilder"
            ),
            1,
            arrayOf<Any>("java/lang/StringBuilder")
        )
        methodVisitor.visitLdcInsn("n/a")
        methodVisitor.visitLabel(label58)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            22,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                "java/util/List",
                "java/util/Iterator",
                Opcodes.INTEGER,
                "java/security/cert/X509Certificate",
                "[B",
                "java/security/PublicKey",
                Opcodes.INTEGER,
                "java/io/PrintStream",
                "java/lang/StringBuilder"
            ),
            2,
            arrayOf<Any>("java/lang/StringBuilder", "java/lang/String")
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label59 = Label()
        methodVisitor.visitLabel(label59)
        methodVisitor.visitLineNumber(792, label59)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 21)
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
        val label60 = Label()
        methodVisitor.visitLabel(label60)
        methodVisitor.visitLineNumber(793, label60)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 18)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/security/PublicKey",
            "getEncoded",
            "()[B",
            true
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 22)
        val label61 = Label()
        methodVisitor.visitLabel(label61)
        methodVisitor.visitLineNumber(794, label61)
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
        methodVisitor.visitLdcInsn("Signer #")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn(" public key SHA-256 digest: ")
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
        val label62 = Label()
        methodVisitor.visitLabel(label62)
        methodVisitor.visitLineNumber(795, label62)
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
        methodVisitor.visitLdcInsn("Signer #")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn(" public key SHA-1 digest: ")
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
        val label63 = Label()
        methodVisitor.visitLabel(label63)
        methodVisitor.visitLineNumber(796, label63)
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
        methodVisitor.visitLdcInsn("Signer #")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn(" public key MD5 digest: ")
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
        val label64 = Label()
        methodVisitor.visitLabel(label64)
        methodVisitor.visitLineNumber(797, label64)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 14)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 14)
        val label65 = Label()
        methodVisitor.visitLabel(label65)
        methodVisitor.visitLineNumber(766, label65)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 2)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label31)
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(800, label24)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            13,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        val label66 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label66)
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(801, label21)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            13,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "err",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("DOES NOT VERIFY")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitLabel(label66)
        methodVisitor.visitLineNumber(804, label66)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            13,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 13)
        val label67 = Label()
        methodVisitor.visitLabel(label67)
        methodVisitor.visitLineNumber(805, label67)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 12)
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label1)
        val label68 = Label()
        methodVisitor.visitLabel(label68)
        methodVisitor.visitLineNumber(806, label68)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "exit",
            "(I)V",
            false
        )
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(814, label1)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            12,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String"
            ),
            0,
            arrayOf()
        )
        val label69 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label69)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(808, label2)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            12,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String"
            ),
            1,
            arrayOf<Any>("java/lang/Exception")
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 12)
        val label70 = Label()
        methodVisitor.visitLabel(label70)
        methodVisitor.visitLineNumber(809, label70)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Exception",
            "getMessage",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 13)
        val label71 = Label()
        methodVisitor.visitLabel(label71)
        methodVisitor.visitLineNumber(810, label71)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 13)
        methodVisitor.visitLdcInsn(".")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "endsWith",
            "(Ljava/lang/String;)Z",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label69)
        val label72 = Label()
        methodVisitor.visitLabel(label72)
        methodVisitor.visitLineNumber(811, label72)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 13)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 46)
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
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 14)
        methodVisitor.visitLabel(label69)
        methodVisitor.visitLineNumber(815, label69)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            12,
            arrayOf<Any>(
                "[Ljava/lang/String;",
                "java/io/File",
                Opcodes.INTEGER,
                "java/lang/String",
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                Opcodes.INTEGER,
                "java/lang/String"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label73 = Label()
        methodVisitor.visitLabel(label73)
        methodVisitor.visitLocalVariable("i", "I", null, label44, label42, 19)
        methodVisitor.visitLocalVariable("i", "I", null, label48, label46, 19)
        methodVisitor.visitLocalVariable(
            "params",
            "Ljava/security/interfaces/DSAParams;",
            null,
            label50,
            label49,
            20
        )
        methodVisitor.visitLocalVariable(
            "next",
            "Ljava/security/cert/X509Certificate;",
            null,
            label33,
            label65,
            16
        )
        methodVisitor.visitLocalVariable("encoded", "[B", null, label36, label65, 17)
        methodVisitor.visitLocalVariable(
            "publicKey",
            "Ljava/security/PublicKey;",
            null,
            label40,
            label65,
            18
        )
        methodVisitor.visitLocalVariable("i", "I", null, label45, label65, 19)
        methodVisitor.visitLocalVariable(
            "printStream",
            "Ljava/io/PrintStream;",
            null,
            label52,
            label65,
            20
        )
        methodVisitor.visitLocalVariable(
            "sb",
            "Ljava/lang/StringBuilder;",
            null,
            label53,
            label65,
            21
        )
        methodVisitor.visitLocalVariable("encoded2", "[B", null, label61, label65, 22)
        methodVisitor.visitLocalVariable("i5", "I", null, label31, label24, 15)
        methodVisitor.visitLocalVariable(
            "it2",
            "Ljava/util/Iterator;",
            "Ljava/util/Iterator<Ljava/security/cert/X509Certificate;>;",
            label30,
            label24,
            14
        )
        methodVisitor.visitLocalVariable(
            "m10668",
            "Ljava/util/List;",
            "Ljava/util/List<Ljava/security/cert/X509Certificate;>;",
            label23,
            label24,
            13
        )
        methodVisitor.visitLocalVariable("m10673", "Z", null, label20, label1, 12)
        methodVisitor.visitLocalVariable("z6", "Z", null, label67, label1, 13)
        methodVisitor.visitLocalVariable(
            "message",
            "Ljava/lang/String;",
            null,
            label71,
            label69,
            13
        )
        methodVisitor.visitLocalVariable(
            "var26",
            "Ljava/lang/Exception;",
            null,
            label70,
            label69,
            12
        )
        methodVisitor.visitLocalVariable(
            "var10000",
            "[Ljava/lang/String;",
            null,
            label4,
            label73,
            0
        )
        methodVisitor.visitLocalVariable("file", "Ljava/io/File;", null, label5, label73, 1)
        methodVisitor.visitLocalVariable("i2", "I", null, label6, label73, 2)
        methodVisitor.visitLocalVariable("str", "Ljava/lang/String;", null, label7, label73, 3)
        methodVisitor.visitLocalVariable("z", "Z", null, label8, label73, 4)
        methodVisitor.visitLocalVariable("z2", "Z", null, label9, label73, 5)
        methodVisitor.visitLocalVariable("i3", "I", null, label10, label73, 6)
        methodVisitor.visitLocalVariable("i4", "I", null, label11, label73, 7)
        methodVisitor.visitLocalVariable("z3", "Z", null, label12, label73, 8)
        methodVisitor.visitLocalVariable("z4", "Z", null, label13, label73, 9)
        methodVisitor.visitLocalVariable("z5", "Z", null, label14, label73, 10)
        methodVisitor.visitLocalVariable("m11128", "Ljava/lang/String;", null, label15, label73, 11)
        methodVisitor.visitMaxs(4, 23)
        methodVisitor.visitEnd()
    }

}