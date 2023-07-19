package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template2
 *
 * @author mmxm
 * @date 2023/7/11 15:41
 */
object Template2 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/InterruptedException")
        val label3 = Label()
        val label4 = Label()
        val label5 = Label()
        methodVisitor.visitTryCatchBlock(label3, label4, label5, null)
        val label6 = Label()
        methodVisitor.visitTryCatchBlock(label5, label6, label5, null)
        val label7 = Label()
        val label8 = Label()
        methodVisitor.visitTryCatchBlock(label7, label8, label8, "java/lang/InterruptedException")
        val label9 = Label()
        val label10 = Label()
        methodVisitor.visitTryCatchBlock(label7, label9, label10, null)
        val label11 = Label()
        methodVisitor.visitTryCatchBlock(label10, label11, label10, null)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(108, label12)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/concurrent/locks/ReentrantLock")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/concurrent/locks/ReentrantLock",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(109, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/concurrent/locks/ReentrantLock",
            "newCondition",
            "()Ljava/util/concurrent/locks/Condition;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(110, label14)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/PriorityQueue")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/PriorityQueue",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(111, label15)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(113, label0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/concurrent/locks/ReentrantLock",
            "lockInterruptibly",
            "()V",
            false
        )
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(116, label1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(114, label2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(115, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/InterruptedException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(119, label7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/PriorityQueue",
            "peek",
            "()Ljava/lang/Object;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(120, label17)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        val label18 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label18)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(121, label19)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/concurrent/locks/Condition",
            "await",
            "()V",
            true
        )
        val label20 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label20)
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(123, label18)
        methodVisitor.visitInsn(Opcodes.LCONST_1)
        methodVisitor.visitVarInsn(Opcodes.LSTORE, 6)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(124, label21)
        methodVisitor.visitVarInsn(Opcodes.LLOAD, 6)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label22 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFGT, label22)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(125, label23)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/PriorityQueue",
            "poll",
            "()Ljava/lang/Object;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(126, label22)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(127, label24)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        val label25 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label25)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(128, label26)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/concurrent/locks/Condition",
            "await",
            "()V",
            true
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label20)
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(130, label25)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Thread",
            "currentThread",
            "()Ljava/lang/Thread;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 8)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(131, label27)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(133, label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.LLOAD, 6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/concurrent/locks/Condition",
            "awaitNanos",
            "(J)J",
            true
        )
        methodVisitor.visitInsn(Opcodes.POP2)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(135, label4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label20)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(136, label28)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label20)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(135, label5)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 9)
        methodVisitor.visitLabel(label6)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        val label29 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label29)
        val label30 = Label()
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(136, label30)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(137, label29)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 9)
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(140, label20)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7)
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(141, label8)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        val label31 = Label()
        methodVisitor.visitLabel(label31)
        methodVisitor.visitLineNumber(142, label31)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/InterruptedException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(144, label9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        val label32 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label32)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/PriorityQueue",
            "peek",
            "()Ljava/lang/Object;",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label32)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(145, label33)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/concurrent/locks/Condition",
            "signal",
            "()V",
            true
        )
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(146, label32)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/concurrent/locks/ReentrantLock",
            "unlock",
            "()V",
            false
        )
        val label34 = Label()
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(147, label34)
        val label35 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label35)
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(144, label10)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 10)
        methodVisitor.visitLabel(label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        val label36 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label36)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/PriorityQueue",
            "peek",
            "()Ljava/lang/Object;",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label36)
        val label37 = Label()
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLineNumber(145, label37)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/concurrent/locks/Condition",
            "signal",
            "()V",
            true
        )
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLineNumber(146, label36)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/concurrent/locks/ReentrantLock",
            "unlock",
            "()V",
            false
        )
        val label38 = Label()
        methodVisitor.visitLabel(label38)
        methodVisitor.visitLineNumber(147, label38)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 10)
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(148, label35)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label39 = Label()
        methodVisitor.visitLabel(label39)
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/lang/InterruptedException;",
            null,
            label16,
            label7,
            5
        )
        methodVisitor.visitLocalVariable(
            "thisThread",
            "Ljava/lang/Thread;",
            null,
            label27,
            label20,
            8
        )
        methodVisitor.visitLocalVariable("delay", "J", null, label21, label20, 6)
        methodVisitor.visitLocalVariable("first", "Ljava/lang/Object;", null, label17, label20, 5)
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/lang/InterruptedException;",
            null,
            label31,
            label9,
            5
        )
        methodVisitor.visitLocalVariable(
            "lock",
            "Ljava/util/concurrent/locks/ReentrantLock;",
            null,
            label13,
            label39,
            1
        )
        methodVisitor.visitLocalVariable(
            "available",
            "Ljava/util/concurrent/locks/Condition;",
            null,
            label14,
            label39,
            2
        )
        methodVisitor.visitLocalVariable(
            "q",
            "Ljava/util/PriorityQueue;",
            "Ljava/util/PriorityQueue<Ljava/lang/Object;>;",
            label15,
            label39,
            3
        )
        methodVisitor.visitLocalVariable("leader", "Ljava/lang/Thread;", null, label0, label39, 4)
        methodVisitor.visitMaxs(4, 11)
        methodVisitor.visitEnd()
    }

}