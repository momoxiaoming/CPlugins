package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template9
 *
 * @author mmxm
 * @date 2023/7/11 15:57
 */
object Template9 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(
            label0,
            label1,
            label2,
            "java/security/NoSuchAlgorithmException"
        )
        methodVisitor.visitTryCatchBlock(
            label0,
            label1,
            label2,
            "java/security/NoSuchProviderException"
        )
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(66, label3)
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
        val label4 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label4)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(67, label5)
        methodVisitor.visitLdcInsn("\\s*([\\S&&[^:,]]*)(\\:([\\S&&[^,]]*))?\\s*(\\,(.*))?")
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(68, label6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/regex/Pattern",
            "compile",
            "(Ljava/lang/String;)Ljava/util/regex/Pattern;",
            false
        )
        val v0 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v0)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(71, label7)
        methodVisitor.visitLdcInsn("sinecures.strongAlgorithms")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/security/Security",
            "getProperty",
            "(Ljava/lang/String;)Ljava/lang/String;",
            false
        )
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(72, label8)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            2,
            arrayOf<Any>("java/util/regex/Pattern", "java/lang/String"),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label4)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(74, label9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/regex/Pattern",
            "matcher",
            "(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;",
            false
        )
        methodVisitor.visitInsn(Opcodes.DUP)
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(75, label10)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/regex/Matcher",
            "matches",
            "()Z",
            false
        )
        val label11 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label11)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(77, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/regex/Matcher",
            "group",
            "(I)Ljava/lang/String;",
            false
        )
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(78, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/regex/Matcher",
            "group",
            "(I)Ljava/lang/String;",
            false
        )
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(81, label0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        val label14 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label14)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(82, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/security/SecureRandom",
            "getInstance",
            "(Ljava/lang/String;)Ljava/security/SecureRandom;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label1)
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(84, label14)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            5,
            arrayOf<Any>(
                "java/util/regex/Pattern",
                "java/lang/String",
                "java/util/regex/Matcher",
                "java/lang/String",
                "java/lang/String"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/security/SecureRandom",
            "getInstance",
            "(Ljava/lang/String;Ljava/lang/String;)Ljava/security/SecureRandom;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(88, label1)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            5,
            arrayOf<Any>(
                "java/util/regex/Pattern",
                "java/lang/String",
                "java/util/regex/Matcher",
                "java/lang/String",
                "java/lang/String"
            ),
            0,
            arrayOf()
        )
        val label16 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label16)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(86, label2)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            5,
            arrayOf<Any>(
                "java/util/regex/Pattern",
                "java/lang/String",
                "java/util/regex/Matcher",
                "java/lang/String",
                "java/lang/String"
            ),
            1,
            arrayOf<Any>("java/security/GeneralSecurityException")
        )
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(89, label16)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            5,
            arrayOf<Any>(
                "java/util/regex/Pattern",
                "java/lang/String",
                "java/util/regex/Matcher",
                "java/lang/String",
                "java/lang/String"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitInsn(Opcodes.ICONST_5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/regex/Matcher",
            "group",
            "(I)Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(90, label17)
        val label18 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label18)
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(91, label11)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            3,
            arrayOf<Any>("java/util/regex/Pattern", "java/lang/String", "java/util/regex/Matcher"),
            0,
            arrayOf()
        )
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(93, label18)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            2,
            arrayOf<Any>("java/util/regex/Pattern", "java/lang/String"),
            0,
            arrayOf()
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label8)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(96, label4)
        methodVisitor.visitFrame(Opcodes.F_NEW, 0, arrayOf(), 0, arrayOf())
    }

}