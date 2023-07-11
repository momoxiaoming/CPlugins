package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template11
 *
 * @author mmxm
 * @date 2023/7/11 15:45
 */
object Template11 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/io/FileNotFoundException")
        val label3 = Label()
        val label4 = Label()
        val label5 = Label()
        methodVisitor.visitTryCatchBlock(
            label3,
            label4,
            label5,
            "java/security/NoSuchAlgorithmException"
        )
        methodVisitor.visitTryCatchBlock(
            label3,
            label4,
            label5,
            "javax/crypto/NoSuchPaddingException"
        )
        val label6 = Label()
        val label7 = Label()
        val label8 = Label()
        methodVisitor.visitTryCatchBlock(label6, label7, label8, "java/io/IOException")
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(659, label9)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(661, label0)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/FileInputStream")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("/temp/temp.apk")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/io/FileInputStream",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(664, label1)
        val label10 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label10)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(662, label2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(663, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/FileNotFoundException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(665, label10)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 2)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(666, label12)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(668, label13)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(670, label3)
        methodVisitor.visitLdcInsn("aab")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "javax/crypto/Cipher",
            "getInstance",
            "(Ljava/lang/String;)Ljavax/crypto/Cipher;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(673, label4)
        val label14 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label14)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(671, label5)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(672, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/security/GeneralSecurityException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(675, label14)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 512)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 7)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(676, label16)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2)
        val label17 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label17)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(677, label18)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        methodVisitor.visitInsn(Opcodes.IRETURN)
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(679, label17)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 4)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(680, label19)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(682, label20)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 8)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(683, label21)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 8)
        val label22 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label22)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(684, label23)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 8)
        methodVisitor.visitInsn(Opcodes.IRETURN)
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(686, label22)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 9)
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(688, label6)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/InputStream",
            "read",
            "([B)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 9)
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(691, label7)
        val label24 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label24)
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(689, label8)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 10)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(690, label25)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/IOException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(692, label24)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 9)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        val label26 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label26)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(694, label27)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 10)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(695, label28)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        val label29 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label29)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val label30 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label30)
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(696, label29)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        methodVisitor.visitInsn(Opcodes.IRETURN)
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(698, label30)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        val label31 = Label()
        methodVisitor.visitLabel(label31)
        methodVisitor.visitLineNumber(699, label31)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitInsn(Opcodes.IRETURN)
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(701, label26)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 9)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "javax/crypto/Cipher",
            "update",
            "([BII)[B",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label32 = Label()
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(702, label32)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 10)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(703, label33)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        val label34 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label34)
        val label35 = Label()
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(704, label35)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(706, label34)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label20)
        val label36 = Label()
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/io/FileNotFoundException;",
            null,
            label11,
            label10,
            2
        )
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/security/GeneralSecurityException;",
            null,
            label15,
            label14,
            6
        )
        methodVisitor.visitLocalVariable("e", "Ljava/io/IOException;", null, label25, label24, 10)
        methodVisitor.visitLocalVariable("bArr", "[B", null, label28, label26, 10)
        methodVisitor.visitLocalVariable("i", "I", null, label21, label34, 8)
        methodVisitor.visitLocalVariable("read", "I", null, label6, label34, 9)
        methodVisitor.visitLocalVariable("bArr2", "[B", null, label33, label34, 10)
        methodVisitor.visitLocalVariable("in", "Ljava/io/InputStream;", null, label0, label36, 1)
        methodVisitor.visitLocalVariable("finalized", "Z", null, label12, label36, 2)
        methodVisitor.visitLocalVariable("buf", "[B", null, label13, label36, 3)
        methodVisitor.visitLocalVariable("bufOff", "I", null, label19, label36, 4)
        methodVisitor.visitLocalVariable(
            "cipher",
            "Ljavax/crypto/Cipher;",
            null,
            label3,
            label36,
            5
        )
        methodVisitor.visitLocalVariable("maxBuf", "I", null, label20, label36, 6)
        methodVisitor.visitLocalVariable("inputBuffer", "[B", null, label16, label36, 7)
        methodVisitor.visitMaxs(4, 11)
        methodVisitor.visitEnd()
    }

}