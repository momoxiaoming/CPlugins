package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template7
 *
 * @author mmxm
 * @date 2023/7/11 15:56
 */
object Template7 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/net/MalformedURLException")
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(38, label3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "android/os/SystemClock",
            "elapsedRealtime",
            "()J",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "nanoTime",
            "()J",
            false
        )
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitLdcInsn(2147483647L)
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label4 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label4)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(39, label5)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(41, label0)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/net/URL")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitLdcInsn("https://www.baidu.com")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/net/URL",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(44, label1)
        val label6 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label6)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(42, label2)
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(43, label7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/MalformedURLException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(45, label6)
        methodVisitor.visitLdcInsn("www@baidu.com")
        methodVisitor.visitInsn(Opcodes.ICONST_4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(I)Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(46, label8)
        methodVisitor.visitLdcInsn("temp/cache/?tc.aar")
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 12)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(I)Ljava/lang/String;",
            false
        )
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(47, label9)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v4)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(48, label10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/URL",
            "toString",
            "()Ljava/lang/String;",
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
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(49, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitLdcInsn("http")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(50, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitLdcInsn("ab")
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
        methodVisitor.visitLineNumber(51, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitLdcInsn("www@baidu.com:8866")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(52, label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitLdcInsn("www")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(53, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(54, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitLdcInsn("temp/cache/")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(55, label17)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(59, label4)
    }

}