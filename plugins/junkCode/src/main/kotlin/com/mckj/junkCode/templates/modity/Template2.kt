package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template2
 *
 * @author mmxm
 * @date 2023/7/11 15:53
 */
object Template2 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/ClassNotFoundException")
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/io/IOException")
        val label3 = Label()
        val label4 = Label()
        val label5 = Label()
        methodVisitor.visitTryCatchBlock(label3, label4, label5, "java/lang/ClassNotFoundException")
        methodVisitor.visitTryCatchBlock(label3, label4, label5, "java/io/IOException")
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(117, label6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "nanoTime",
            "()J",
            false
        )
        methodVisitor.visitLdcInsn(87490272L)
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label7 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label7)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(120, label3)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(121, label8)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/ObjectInputStream")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/io/FileInputStream")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("temp/temp/fc.db")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/io/FileInputStream",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/io/ObjectInputStream",
            "<init>",
            "(Ljava/io/InputStream;)V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(124, label9)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/HashMap")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/HashMap",
            "<init>",
            "()V",
            false
        )
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(125, label10)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(127, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        val label12 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label12)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(128, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/ObjectInputStream",
            "readFields",
            "()Ljava/io/ObjectInputStream\$GetField;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(131, label12)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(133, label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitLdcInsn("children")
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/ObjectInputStream\$GetField",
            "get",
            "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;",
            false
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/util/Hashtable")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v5)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(136, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitLdcInsn("source")
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/ObjectInputStream\$GetField",
            "get",
            "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;",
            false
        )
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(138, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitLdcInsn("propertyChangeSupportSerializedDataVersion")
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/ObjectInputStream\$GetField",
            "get",
            "(Ljava/lang/String;I)I",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(140, label17)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v6)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(143, label0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        val label18 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label18)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/ObjectInputStream",
            "readObject",
            "()Ljava/lang/Object;",
            false
        )
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v6)
        methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label18)
        methodVisitor.visitLabel(label1)
        val label19 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label19)
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(146, label18)
        val label20 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label20)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(144, label2)
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(145, label21)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Exception",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(147, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/beans/PropertyChangeListener")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/HashMap",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label0)
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(149, label19)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label4)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(150, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Hashtable",
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
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Iterator",
            "hasNext",
            "()Z",
            true
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Iterator",
            "next",
            "()Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/util/Map\$Entry")
        val v8 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v8)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(151, label24)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Map\$Entry",
            "getValue",
            "()Ljava/lang/Object;",
            true
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/beans/PropertyChangeSupport")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/beans/PropertyChangeSupport",
            "getPropertyChangeListeners",
            "()[Ljava/beans/PropertyChangeListener;",
            false
        )
        val v9 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val v10 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v11 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v11)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v11)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        val label26 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label26)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v11)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        val v12 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v12)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(152, label27)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Map\$Entry",
            "getKey",
            "()Ljava/lang/Object;",
            true
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v12)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/HashMap",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(151, label28)
        methodVisitor.visitIincInsn(v11, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label25)
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(154, label26)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label23)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(159, label4)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(157, label5)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(158, label29)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Exception",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(161, label7)
    }

}