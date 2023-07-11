package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template15
 *
 * @author mmxm
 * @date 2023/7/11 15:48
 */
object Template15 {
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
        methodVisitor.visitLineNumber(856, label6)
        methodVisitor.visitInsn(Opcodes.ICONST_5)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitInsn(Opcodes.BASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitInsn(Opcodes.BASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitInsn(Opcodes.BASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitInsn(Opcodes.BASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitInsn(Opcodes.BASTORE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(857, label7)
        methodVisitor.visitInsn(Opcodes.ICONST_5)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 2)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(858, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 3)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(859, label9)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 4)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(860, label10)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(861, label11)
        methodVisitor.visitInsn(Opcodes.ICONST_5)
        methodVisitor.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitInsn(Opcodes.BASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitInsn(Opcodes.BASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitInsn(Opcodes.BASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitInsn(Opcodes.BASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitInsn(Opcodes.BASTORE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(862, label12)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 7)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(864, label0)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/FileInputStream")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("temp/temp.apk")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/io/FileInputStream",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 7)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(867, label1)
        val label13 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label13)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(865, label2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 8)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(866, label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/FileNotFoundException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(869, label13)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 8)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(871, label15)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 9)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(872, label16)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 9)
        val label17 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFGT, label17)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(874, label18)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 9)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(875, label19)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 9)
        methodVisitor.visitJumpInsn(Opcodes.IFGT, label17)
        methodVisitor.visitInsn(Opcodes.RETURN)
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(877, label17)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 9)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Math", "min", "(II)I", false)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 10)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(878, label20)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 10)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(879, label21)
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
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 6)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val label22 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label22)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(880, label23)
        methodVisitor.visitInsn(Opcodes.RETURN)
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(883, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 11)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(885, label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 11)
        val label24 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label24)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 11)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/InputStream",
            "available",
            "()I",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFGT, label24)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(886, label4)
        methodVisitor.visitInsn(Opcodes.RETURN)
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(889, label24)
        val label25 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label25)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(887, label5)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 12)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(888, label26)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 12)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/IOException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(890, label25)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label15)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/io/FileNotFoundException;",
            null,
            label14,
            label13,
            8
        )
        methodVisitor.visitLocalVariable("e", "Ljava/io/IOException;", null, label26, label25, 12)
        methodVisitor.visitLocalVariable("avail", "I", null, label16, label25, 9)
        methodVisitor.visitLocalVariable("cnt", "I", null, label20, label25, 10)
        methodVisitor.visitLocalVariable(
            "input",
            "Ljava/io/InputStream;",
            null,
            label3,
            label25,
            11
        )
        methodVisitor.visitLocalVariable("b", "[B", null, label7, label27, 1)
        methodVisitor.visitLocalVariable("off", "I", null, label8, label27, 2)
        methodVisitor.visitLocalVariable("len", "I", null, label9, label27, 3)
        methodVisitor.visitLocalVariable("count", "I", null, label10, label27, 4)
        methodVisitor.visitLocalVariable("pos", "I", null, label11, label27, 5)
        methodVisitor.visitLocalVariable("buf", "[B", null, label12, label27, 6)
        methodVisitor.visitLocalVariable("in", "Ljava/io/InputStream;", null, label0, label27, 7)
        methodVisitor.visitLocalVariable("n", "I", null, label15, label27, 8)
        methodVisitor.visitMaxs(4, 13)
        methodVisitor.visitEnd()
    }

}