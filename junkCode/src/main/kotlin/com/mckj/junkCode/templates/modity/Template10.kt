package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type

/**
 * Template10
 *
 * @author mmxm
 * @date 2023/7/11 15:57
 */
object Template10 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/Exception")
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        //        methodVisitor.visitLineNumber(381, label3);
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/Double",
            "TYPE",
            "Ljava/lang/Class;"
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "identityHashCode",
            "(Ljava/lang/Object;)I",
            false
        )
        methodVisitor.visitInsn(Opcodes.I2L)
        methodVisitor.visitLdcInsn(60011L)
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label4 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label4)
        methodVisitor.visitLabel(label0)
        //        methodVisitor.visitLineNumber(383, label0);
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "currentTimeMillis",
            "()J",
            false
        )
        methodVisitor.visitInsn(Opcodes.L2D)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Double",
            "doubleToLongBits",
            "(D)J",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP2)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        //        methodVisitor.visitLineNumber(384, label5);
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Hashtable")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/Hashtable",
            "<init>",
            "()V",
            false
        )
        val v0 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v0)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        //        methodVisitor.visitLineNumber(385, label6);
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("Checking... (no more output means success)")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        //        methodVisitor.visitLineNumber(386, label7);
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 37)
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v1)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitFrame(
            Opcodes.F_APPEND,
            2,
            arrayOf<Any>("java/util/Hashtable", Opcodes.INTEGER),
            0,
            null
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        val label9 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label9)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        //        methodVisitor.visitLineNumber(387, label10);
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Integer",
            "valueOf",
            "(I)Ljava/lang/Integer;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Integer",
            "valueOf",
            "(I)Ljava/lang/Integer;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Hashtable",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        //        methodVisitor.visitLineNumber(386, label11);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 37)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 4000)
        methodVisitor.visitInsn(Opcodes.IREM)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label8)
        methodVisitor.visitLabel(label9)
        //        methodVisitor.visitLineNumber(389, label9);
        methodVisitor.visitFrame(Opcodes.F_CHOP, 1, null, 0, null)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v1)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitFrame(Opcodes.F_APPEND, 1, arrayOf<Any>(Opcodes.INTEGER), 0, null)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 4000)
        val label13 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label13)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        //        methodVisitor.visitLineNumber(390, label14);
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Integer",
            "valueOf",
            "(I)Ljava/lang/Integer;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Hashtable",
            "remove",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        //        methodVisitor.visitLineNumber(389, label15);
        methodVisitor.visitIincInsn(v1, 2)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label12)
        methodVisitor.visitLabel(label13)
        //        methodVisitor.visitLineNumber(392, label13);
        methodVisitor.visitFrame(Opcodes.F_CHOP, 1, null, 0, null)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v1)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitFrame(Opcodes.F_APPEND, 1, arrayOf<Any>(Opcodes.INTEGER), 0, null)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 4000)
        val label17 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label17)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        //        methodVisitor.visitLineNumber(393, label18);
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Integer",
            "valueOf",
            "(I)Ljava/lang/Integer;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Hashtable",
            "get",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/Integer")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Integer",
            "intValue",
            "()I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        val label19 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label19)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        //        methodVisitor.visitLineNumber(394, label20);
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        //        methodVisitor.visitLineNumber(395, label21);
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitLdcInsn("Find fails ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
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
        methodVisitor.visitLabel(label19)
        //        methodVisitor.visitLineNumber(392, label19);
        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null)
        methodVisitor.visitIincInsn(v1, 2)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label16)
        methodVisitor.visitLabel(label17)
        //        methodVisitor.visitLineNumber(398, label17);
        methodVisitor.visitFrame(Opcodes.F_CHOP, 1, null, 0, null)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v1)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitFrame(Opcodes.F_APPEND, 1, arrayOf<Any>(Opcodes.INTEGER), 0, null)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 4000)
        val label23 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label23)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        //        methodVisitor.visitLineNumber(399, label24);
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Integer",
            "valueOf",
            "(I)Ljava/lang/Integer;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Hashtable",
            "get",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false
        )
        val label25 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label25)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        //        methodVisitor.visitLineNumber(400, label26);
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        //        methodVisitor.visitLineNumber(401, label27);
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitLdcInsn("OOPS!!! ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
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
        methodVisitor.visitLabel(label25)
        //        methodVisitor.visitLineNumber(398, label25);
        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null)
        methodVisitor.visitIincInsn(v1, 2)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label22)
        methodVisitor.visitLabel(label23)
        //        methodVisitor.visitLineNumber(405, label23);
        methodVisitor.visitFrame(Opcodes.F_CHOP, 1, null, 0, null)
        methodVisitor.visitLdcInsn("java.lang.String")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Class",
            "forName",
            "(Ljava/lang/String;)Ljava/lang/Class;",
            false
        )
        methodVisitor.visitLdcInsn("main")
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Class")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLdcInsn(Type.getType("[Ljava/lang/String;"))
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "getDeclaredMethod",
            "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;",
            false
        )
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Object")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLdcInsn(Type.getType("[Ljava/lang/String;"))
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/reflect/Method",
            "invoke",
            "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label1)
        //        methodVisitor.visitLineNumber(408, label1);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4)
        methodVisitor.visitLabel(label2)
        //        methodVisitor.visitLineNumber(406, label2);
        methodVisitor.visitFrame(
            Opcodes.F_FULL,
            0,
            arrayOf(),
            1,
            arrayOf<Any>("java/lang/Exception")
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v0)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        //        methodVisitor.visitLineNumber(407, label28);
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Exception",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label4)
//        methodVisitor.visitLineNumber(412, label4);
//        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
    }

}