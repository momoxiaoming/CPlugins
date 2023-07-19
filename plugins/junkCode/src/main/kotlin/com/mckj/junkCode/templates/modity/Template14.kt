package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template14
 *
 * @author mmxm
 * @date 2023/7/11 16:00
 */
object Template14 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/Throwable")
        val label3 = Label()
        val label4 = Label()
        val label5 = Label()
        methodVisitor.visitTryCatchBlock(label3, label4, label5, "java/lang/Throwable")
        val label6 = Label()
        methodVisitor.visitTryCatchBlock(label3, label4, label6, null)
        val label7 = Label()
        val label8 = Label()
        val label9 = Label()
        methodVisitor.visitTryCatchBlock(label7, label8, label9, "java/lang/Throwable")
        val label10 = Label()
        methodVisitor.visitTryCatchBlock(label5, label10, label6, null)
        val label11 = Label()
        val label12 = Label()
        val label13 = Label()
        methodVisitor.visitTryCatchBlock(label11, label12, label13, "java/lang/Exception")
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(81, label14)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/ClassLoader",
            "getSystemClassLoader",
            "()Ljava/lang/ClassLoader;",
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
        methodVisitor.visitLdcInsn(31449600000L)
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label15 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label15)
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(83, label11)
        methodVisitor.visitLdcInsn("hijrah")
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(84, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitLdcInsn("Resource missing forhijrah")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/Objects",
            "requireNonNull",
            "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(85, label17)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Properties")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/Properties",
            "<init>",
            "()V",
            false
        )
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(86, label18)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/ClassLoader",
            "getSystemResourceAsStream",
            "(Ljava/lang/String;)Ljava/io/InputStream;",
            false
        )
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(87, label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Properties",
            "load",
            "(Ljava/io/InputStream;)V",
            false
        )
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(88, label4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        val label20 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label21)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/InputStream",
            "close",
            "()V",
            false
        )
        methodVisitor.visitLabel(label1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label20)
        methodVisitor.visitLabel(label2)
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Throwable",
            "addSuppressed",
            "(Ljava/lang/Throwable;)V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label20)
        methodVisitor.visitLabel(label21)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/InputStream",
            "close",
            "()V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label20)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(86, label5)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(88, label6)
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v6)
        methodVisitor.visitLabel(label10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        val label22 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        val label23 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label23)
        methodVisitor.visitLabel(label7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/InputStream",
            "close",
            "()V",
            false
        )
        methodVisitor.visitLabel(label8)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label22)
        methodVisitor.visitLabel(label9)
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Throwable",
            "addSuppressed",
            "(Ljava/lang/Throwable;)V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label22)
        methodVisitor.visitLabel(label23)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/InputStream",
            "close",
            "()V",
            false
        )
        methodVisitor.visitLabel(label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(90, label20)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(91, label24)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(92, label25)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(93, label26)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Properties",
            "entrySet",
            "()Ljava/util/Set;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Set",
            "iterator",
            "()Ljava/util/Iterator;",
            true
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v6)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Iterator",
            "hasNext",
            "()Z",
            true
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Iterator",
            "next",
            "()Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/util/Map\$Entry")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(94, label28)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Map\$Entry",
            "getKey",
            "()Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/String")
        val v8 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v8)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(95, label29)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        val v9 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v9)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        val v10 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "hashCode",
            "()I",
            false
        )
        val label30 = Label()
        val label31 = Label()
        val label32 = Label()
        val label33 = Label()
        val label34 = Label()
        methodVisitor.visitLookupSwitchInsn(
            label34,
            intArrayOf(3355, 104581, 3575610, 351608024),
            arrayOf(label30, label31, label32, label33)
        )
        methodVisitor.visitLabel(label30)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitLdcInsn("id")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label34)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label34)
        methodVisitor.visitLabel(label32)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitLdcInsn("type")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label34)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label34)
        methodVisitor.visitLabel(label33)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitLdcInsn("version")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label34)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label34)
        methodVisitor.visitLabel(label31)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitLdcInsn("iso")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label34)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        methodVisitor.visitLabel(label34)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        val label35 = Label()
        val label36 = Label()
        val label37 = Label()
        val label38 = Label()
        val label39 = Label()
        methodVisitor.visitTableSwitchInsn(
            0,
            3,
            label39,
            *arrayOf(label35, label36, label37, label38)
        )
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(97, label35)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Map\$Entry",
            "getValue",
            "()Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/String")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label40 = Label()
        methodVisitor.visitLabel(label40)
        methodVisitor.visitLineNumber(98, label40)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label39)
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLineNumber(100, label36)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Map\$Entry",
            "getValue",
            "()Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/String")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        val label41 = Label()
        methodVisitor.visitLabel(label41)
        methodVisitor.visitLineNumber(101, label41)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label39)
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLineNumber(103, label37)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Map\$Entry",
            "getValue",
            "()Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/String")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        val label42 = Label()
        methodVisitor.visitLabel(label42)
        methodVisitor.visitLineNumber(104, label42)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label39)
        methodVisitor.visitLabel(label38)
        methodVisitor.visitLineNumber(106, label38)
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
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
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
        val label43 = Label()
        methodVisitor.visitLabel(label43)
        methodVisitor.visitLineNumber(107, label43)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label39)
        methodVisitor.visitLabel(label39)
        methodVisitor.visitLineNumber(113, label39)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label27)
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(117, label12)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label15)
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(115, label13)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(119, label15)
    }

}