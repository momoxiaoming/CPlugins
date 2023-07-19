package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template1
 *
 * @author mmxm
 * @date 2023/7/11 15:40
 */
object Template1 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/io/IOException")
        val label3 = Label()
        val label4 = Label()
        methodVisitor.visitTryCatchBlock(label3, label0, label4, "java/lang/Exception")
        val label5 = Label()
        val label6 = Label()
        val label7 = Label()
        methodVisitor.visitTryCatchBlock(label5, label6, label7, "java/io/IOException")
        val label8 = Label()
        methodVisitor.visitTryCatchBlock(label3, label0, label8, null)
        methodVisitor.visitTryCatchBlock(label4, label5, label8, null)
        val label9 = Label()
        val label10 = Label()
        val label11 = Label()
        methodVisitor.visitTryCatchBlock(label9, label10, label11, "java/io/IOException")
        methodVisitor.visitTryCatchBlock(label8, label9, label8, null)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(84, label12)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(86, label3)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/BufferedReader")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/FileReader")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("/proc/net/arp")
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
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(88, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/BufferedReader",
            "readLine",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label0)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(89, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitLdcInsn(" +")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "split",
            "(Ljava/lang/String;)[Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(90, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val label17 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFLT, label17)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(91, label18)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label0)
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(93, label17)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label13)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(98, label0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/BufferedReader",
            "close",
            "()V",
            false
        )
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(101, label1)
        val label19 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label19)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(99, label2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(100, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/IOException",
            "printStackTrace",
            "()V",
            false
        )
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(102, label21)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label19)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(94, label4)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(95, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Exception",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(98, label5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/BufferedReader",
            "close",
            "()V",
            false
        )
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(101, label6)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label19)
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(99, label7)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(100, label23)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/IOException",
            "printStackTrace",
            "()V",
            false
        )
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(102, label24)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label19)
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(97, label8)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(98, label9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/BufferedReader",
            "close",
            "()V",
            false
        )
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(101, label10)
        val label25 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label25)
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(99, label11)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(100, label26)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/IOException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(102, label25)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(104, label19)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLocalVariable(
            "splitted",
            "[Ljava/lang/String;",
            null,
            label16,
            label17,
            3
        )
        methodVisitor.visitLocalVariable("line", "Ljava/lang/String;", null, label14, label0, 2)
        methodVisitor.visitLocalVariable("e", "Ljava/io/IOException;", null, label20, label21, 2)
        methodVisitor.visitLocalVariable("e", "Ljava/lang/Exception;", null, label22, label5, 2)
        methodVisitor.visitLocalVariable("e", "Ljava/io/IOException;", null, label23, label24, 2)
        methodVisitor.visitLocalVariable("e", "Ljava/io/IOException;", null, label26, label25, 5)
        methodVisitor.visitLocalVariable("br", "Ljava/io/BufferedReader;", null, label3, label27, 1)
        methodVisitor.visitMaxs(5, 6)
        methodVisitor.visitEnd()
    }

}