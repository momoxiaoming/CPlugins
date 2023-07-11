package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template4
 *
 * @author mmxm
 * @date 2023/7/11 15:42
 */
object Template4 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(214, label0)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/ArrayList",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label1 = Label()
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(215, label1)
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
        val label2 = Label()
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(216, label2)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/ArrayList",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(217, label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/ArrayList",
            "isEmpty",
            "()Z",
            false
        )
        val label4 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label4)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        val label5 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label5)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 4)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(218, label6)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(219, label7)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(220, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/ArrayList",
            "isEmpty",
            "()Z",
            false
        )
        val label9 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label9)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        val label10 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label10)
        methodVisitor.visitLabel(label9)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLabel(label10)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 7)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(221, label11)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        val label12 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label12)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(223, label13)
        methodVisitor.visitInsn(Opcodes.RETURN)
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(226, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/ArrayList",
            "iterator",
            "()Ljava/util/Iterator;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 8)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Iterator",
            "hasNext",
            "()Z",
            true
        )
        val label15 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Iterator",
            "next",
            "()Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(
            Opcodes.CHECKCAST,
            "androidx/recyclerview/widget/RecyclerView\$ViewHolder"
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 9)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(227, label16)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        val label17 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label17)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        val label18 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label18)
        methodVisitor.visitLabel(label17)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLabel(label18)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(228, label19)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label14)
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(229, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/ArrayList",
            "clear",
            "()V",
            false
        )
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(231, label20)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label21)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(234, label22)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        val label23 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label23)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(235, label24)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 8)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(236, label25)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label21)
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(237, label23)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 8)
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(241, label21)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        val label26 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label26)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(243, label27)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label26)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(244, label28)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 8)
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(249, label26)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        val label29 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label29)
        val label30 = Label()
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(250, label30)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/ArrayList",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 8)
        val label31 = Label()
        methodVisitor.visitLabel(label31)
        methodVisitor.visitLineNumber(251, label31)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/ArrayList",
            "addAll",
            "(Ljava/util/Collection;)Z",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label32 = Label()
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(252, label32)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/ArrayList",
            "add",
            "(Ljava/lang/Object;)Z",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(253, label33)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/ArrayList",
            "clear",
            "()V",
            false
        )
        val label34 = Label()
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(254, label34)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 9)
        val label35 = Label()
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(255, label35)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/ArrayList",
            "clear",
            "()V",
            false
        )
        val label36 = Label()
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLineNumber(256, label36)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/ArrayList",
            "remove",
            "(Ljava/lang/Object;)Z",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label37 = Label()
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLineNumber(258, label37)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        val label38 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label38)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label38)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        val label39 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label39)
        methodVisitor.visitLabel(label38)
        methodVisitor.visitLineNumber(259, label38)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitVarInsn(Opcodes.LSTORE, 10)
        val label40 = Label()
        methodVisitor.visitLabel(label40)
        methodVisitor.visitLineNumber(260, label40)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitVarInsn(Opcodes.LSTORE, 12)
        val label41 = Label()
        methodVisitor.visitLabel(label41)
        methodVisitor.visitLineNumber(261, label41)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitVarInsn(Opcodes.LSTORE, 14)
        val label42 = Label()
        methodVisitor.visitLabel(label42)
        methodVisitor.visitLineNumber(262, label42)
        methodVisitor.visitVarInsn(Opcodes.LLOAD, 10)
        methodVisitor.visitVarInsn(Opcodes.LLOAD, 12)
        methodVisitor.visitVarInsn(Opcodes.LLOAD, 14)
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Math", "max", "(JJ)J", false)
        methodVisitor.visitInsn(Opcodes.LADD)
        methodVisitor.visitVarInsn(Opcodes.LSTORE, 16)
        val label43 = Label()
        methodVisitor.visitLabel(label43)
        methodVisitor.visitLineNumber(263, label43)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/ArrayList",
            "get",
            "(I)Ljava/lang/Object;",
            false
        )
        methodVisitor.visitTypeInsn(
            Opcodes.CHECKCAST,
            "androidx/recyclerview/widget/RecyclerView\$ViewHolder"
        )
        methodVisitor.visitFieldInsn(
            Opcodes.GETFIELD,
            "androidx/recyclerview/widget/RecyclerView\$ViewHolder",
            "itemView",
            "Landroid/view/View;"
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 18)
        val label44 = Label()
        methodVisitor.visitLabel(label44)
        methodVisitor.visitLineNumber(264, label44)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 18)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 9)
        methodVisitor.visitVarInsn(Opcodes.LLOAD, 16)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "androidx/core/view/ViewCompat",
            "postOnAnimationDelayed",
            "(Landroid/view/View;Ljava/lang/Runnable;J)V",
            false
        )
        val label45 = Label()
        methodVisitor.visitLabel(label45)
        methodVisitor.visitLineNumber(265, label45)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label29)
        methodVisitor.visitLabel(label39)
        methodVisitor.visitLineNumber(266, label39)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 9)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/lang/Runnable",
            "run",
            "()V",
            true
        )
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(269, label29)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label46 = Label()
        methodVisitor.visitLabel(label46)
        methodVisitor.visitLocalVariable(
            "holder",
            "Landroidx/recyclerview/widget/RecyclerView\$ViewHolder;",
            null,
            label16,
            label19,
            9
        )
        methodVisitor.visitLocalVariable("removeDuration", "J", null, label40, label45, 10)
        methodVisitor.visitLocalVariable("moveDuration", "J", null, label41, label45, 12)
        methodVisitor.visitLocalVariable("changeDuration", "J", null, label42, label45, 14)
        methodVisitor.visitLocalVariable("totalDelay", "J", null, label43, label45, 16)
        methodVisitor.visitLocalVariable("view", "Landroid/view/View;", null, label44, label45, 18)
        methodVisitor.visitLocalVariable(
            "additions",
            "Ljava/util/ArrayList;",
            "Ljava/util/ArrayList<Landroidx/recyclerview/widget/RecyclerView\$ViewHolder;>;",
            label31,
            label29,
            8
        )
        methodVisitor.visitLocalVariable("adder", "Ljava/lang/Runnable;", null, label35, label29, 9)
        methodVisitor.visitLocalVariable(
            "mPendingRemovals",
            "Ljava/util/ArrayList;",
            "Ljava/util/ArrayList<Landroidx/recyclerview/widget/RecyclerView\$ViewHolder;>;",
            label1,
            label46,
            1
        )
        methodVisitor.visitLocalVariable(
            "mPendingAdditions",
            "Ljava/util/ArrayList;",
            "Ljava/util/ArrayList<Landroidx/recyclerview/widget/RecyclerView\$ViewHolder;>;",
            label2,
            label46,
            2
        )
        methodVisitor.visitLocalVariable(
            "mAdditionsList",
            "Ljava/util/ArrayList;",
            "Ljava/util/ArrayList<Ljava/util/ArrayList<Landroidx/recyclerview/widget/RecyclerView\$ViewHolder;>;>;",
            label3,
            label46,
            3
        )
        methodVisitor.visitLocalVariable("removalsPending", "Z", null, label6, label46, 4)
        methodVisitor.visitLocalVariable("movesPending", "Z", null, label7, label46, 5)
        methodVisitor.visitLocalVariable("changesPending", "Z", null, label8, label46, 6)
        methodVisitor.visitLocalVariable("additionsPending", "Z", null, label11, label46, 7)
        methodVisitor.visitMaxs(6, 19)
        methodVisitor.visitEnd()
    }

}