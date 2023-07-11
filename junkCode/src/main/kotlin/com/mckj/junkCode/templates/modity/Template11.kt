package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template11
 *
 * @author mmxm
 * @date 2023/7/11 15:57
 */
object Template11 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(64, label0)
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
        val label1 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label1)
        val label2 = Label()
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(65, label2)
        methodVisitor.visitLdcInsn("baidu.com")
        val v0 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v0)
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(66, label3)
        methodVisitor.visitLdcInsn(".")
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(67, label4)
        methodVisitor.visitLdcInsn("@")
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(69, label5)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(70, label6)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(71, label7)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v5)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(72, label8)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            6,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "indexOf",
            "(Ljava/lang/String;I)I",
            false
        )
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v5)
        val label9 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFLT, label9)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(73, label10)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        val label11 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLE, label11)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(74, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(76, label11)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            6,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(77, label13)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(78, label14)
        methodVisitor.visitIincInsn(v5, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label8)
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(80, label9)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            6,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "length",
            "()I",
            false
        )
        val label15 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label15)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(81, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(I)Ljava/lang/String;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(83, label15)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            6,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/StringBuilder",
                Opcodes.INTEGER,
                Opcodes.INTEGER
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(85, label1)
        methodVisitor.visitFrame(Opcodes.F_NEW, 0, arrayOf(), 0, arrayOf())
    }

}