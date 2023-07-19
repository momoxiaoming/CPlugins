package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type

/**
 * Template16
 *
 * @author mmxm
 * @date 2023/7/11 16:01
 */
object Template16 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(88, label0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/Calendar",
            "getInstance",
            "()Ljava/util/Calendar;",
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
        val label1 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label1)
        val label2 = Label()
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(90, label2)
        methodVisitor.visitLdcInsn("a")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Object",
            "getClass",
            "()Ljava/lang/Class;",
            false
        )
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(91, label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "getGenericInterfaces",
            "()[Ljava/lang/reflect/Type;",
            false
        )
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(92, label4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label1)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(93, label5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v5)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            6,
            arrayOf<Any>(
                Opcodes.TOP,
                "java/lang/Class",
                "[Ljava/lang/reflect/Type;",
                "[Ljava/lang/reflect/Type;",
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v6)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(94, label7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, "java/lang/reflect/ParameterizedType")
        val label8 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label8)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(95, label9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v6)
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/reflect/ParameterizedType")
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(96, label10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/lang/reflect/ParameterizedType",
            "getRawType",
            "()Ljava/lang/reflect/Type;",
            true
        )
        methodVisitor.visitLdcInsn(Type.getType("Ljava/lang/Comparable;"))
        methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/lang/reflect/ParameterizedType",
            "getActualTypeArguments",
            "()[Ljava/lang/reflect/Type;",
            true
        )
        methodVisitor.visitInsn(Opcodes.DUP)
        val v0 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v0)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label8)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(97, label12)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "getName",
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
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(93, label8)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            6,
            arrayOf<Any>(
                Opcodes.TOP,
                "java/lang/Class",
                "[Ljava/lang/reflect/Type;",
                "[Ljava/lang/reflect/Type;",
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitIincInsn(v5, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label6)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(105, label1)
        methodVisitor.visitFrame(Opcodes.F_NEW, 0, arrayOf(), 0, arrayOf())
    }

}