package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template15
 *
 * @author mmxm
 * @date 2023/7/11 16:00
 */
object Template15 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, null)
        val label3 = Label()
        methodVisitor.visitTryCatchBlock(label2, label3, label2, null)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(86, label4)
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
        val label5 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label5)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(87, label6)
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
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v1)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(89, label7)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/concurrent/locks/ReentrantLock")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/concurrent/locks/ReentrantLock",
            "<init>",
            "(Z)V",
            false
        )
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(90, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/concurrent/locks/ReentrantLock",
            "newCondition",
            "()Ljava/util/concurrent/locks/Condition;",
            false
        )
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(91, label9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/concurrent/locks/ReentrantLock",
            "lock",
            "()V",
            false
        )
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(93, label0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v5)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(94, label10)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitJumpInsn(Opcodes.IFLE, label1)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(95, label11)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Object")
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v6)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(97, label12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Math", "abs", "(I)I", false)
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v7)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(98, label13)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitInsn(Opcodes.ICONST_5)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Math", "abs", "(I)I", false)
        val v8 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v8)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(100, label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitInsn(Opcodes.AASTORE)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(101, label15)
        methodVisitor.visitIincInsn(v8, 1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val label16 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label16)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v8)
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(102, label16)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label14)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(103, label17)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v7)
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v2)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(104, label18)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v1)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(106, label19)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        val label20 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFLE, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/concurrent/locks/ReentrantLock",
            "hasWaiters",
            "(Ljava/util/concurrent/locks/Condition;)Z",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label20)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(107, label21)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/concurrent/locks/Condition",
            "signal",
            "()V",
            true
        )
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(106, label22)
        methodVisitor.visitIincInsn(v5, -1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label19)
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(109, label20)
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
        methodVisitor.visitLdcInsn("takeIndex")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
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
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(112, label1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/concurrent/locks/ReentrantLock",
            "unlock",
            "()V",
            false
        )
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(113, label23)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label5)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(112, label2)
        val v9 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v9)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/concurrent/locks/ReentrantLock",
            "unlock",
            "()V",
            false
        )
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(113, label24)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(115, label5)
    }

}