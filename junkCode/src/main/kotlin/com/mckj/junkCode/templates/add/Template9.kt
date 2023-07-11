package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template9
 *
 * @author mmxm
 * @date 2023/7/11 15:44
 */
object Template9 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(581, label0)
        methodVisitor.visitLdcInsn("[com.android.haha")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label1 = Label()
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(582, label1)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 36)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 2)
        val label2 = Label()
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(583, label2)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 46)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 3)
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(584, label3)
        methodVisitor.visitLdcInsn("")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(585, label4)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/HashMap")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/HashMap",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(586, label5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitLdcInsn("are u s")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Map",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            true
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(588, label6)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(591, label7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitLdcInsn("[")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "startsWith",
            "(Ljava/lang/String;)Z",
            false
        )
        val label8 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label8)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(592, label9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 91)
        val label10 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label10)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(593, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(I)Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(594, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 6)
        methodVisitor.visitLdcInsn("[]")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label9)
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(597, label10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 76)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "charAt",
            "(I)C",
            false
        )
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 59)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label8)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(598, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(II)Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(602, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Map",
            "containsKey",
            "(Ljava/lang/Object;)Z",
            true
        )
        val label14 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label14)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(603, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Map",
            "get",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/String")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(606, label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 46)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "lastIndexOf",
            "(I)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 7)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(607, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        val label17 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label17)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val label18 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label18)
        methodVisitor.visitLabel(label17)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitLabel(label18)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "indexOf",
            "(II)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 8)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(609, label19)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(I)Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 9)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(610, label20)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 8)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label21)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(611, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 9)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 46)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "replace",
            "(CC)Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 9)
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(614, label21)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLocalVariable(
            "className",
            "Ljava/lang/String;",
            null,
            label1,
            label23,
            1
        )
        methodVisitor.visitLocalVariable(
            "INNER_CLASS_SEPARATOR_CHAR",
            "C",
            null,
            label2,
            label23,
            2
        )
        methodVisitor.visitLocalVariable("PACKAGE_SEPARATOR_CHAR", "C", null, label3, label23, 3)
        methodVisitor.visitLocalVariable(
            "STRING_EMPTY",
            "Ljava/lang/String;",
            null,
            label4,
            label23,
            4
        )
        methodVisitor.visitLocalVariable(
            "reverseAbbreviationMap",
            "Ljava/util/Map;",
            "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;",
            label5,
            label23,
            5
        )
        methodVisitor.visitLocalVariable(
            "arrayPrefix",
            "Ljava/lang/StringBuilder;",
            null,
            label7,
            label23,
            6
        )
        methodVisitor.visitLocalVariable("lastDotIdx", "I", null, label16, label23, 7)
        methodVisitor.visitLocalVariable("innerIdx", "I", null, label19, label23, 8)
        methodVisitor.visitLocalVariable("out", "Ljava/lang/String;", null, label20, label23, 9)
        methodVisitor.visitMaxs(4, 10)
        methodVisitor.visitEnd()
    }

}