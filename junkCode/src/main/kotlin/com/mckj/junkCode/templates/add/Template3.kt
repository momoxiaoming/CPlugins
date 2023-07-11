package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template3
 *
 * @author mmxm
 * @date 2023/7/11 15:41
 */
object Template3 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/ClassNotFoundException")
        val label3 = Label()
        val label4 = Label()
        val label5 = Label()
        methodVisitor.visitTryCatchBlock(label3, label4, label5, "java/lang/Exception")
        val label6 = Label()
        val label7 = Label()
        val label8 = Label()
        methodVisitor.visitTryCatchBlock(
            label6,
            label7,
            label8,
            "java/security/NoSuchAlgorithmException"
        )
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(151, label9)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(152, label10)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 2)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(154, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        val label12 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label12)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2)
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label12)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(155, label13)
        methodVisitor.visitInsn(Opcodes.RETURN)
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(158, label12)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 2)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(159, label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(160, label15)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(162, label16)
        methodVisitor.visitLdcInsn("ssl.SocketFactory.provider")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(164, label17)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label6)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(170, label18)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(171, label19)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Object",
            "getClass",
            "()Ljava/lang/Class;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "getName",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label3)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(172, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(173, label21)
        methodVisitor.visitInsn(Opcodes.RETURN)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(176, label3)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(178, label0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Class",
            "forName",
            "(Ljava/lang/String;)Ljava/lang/Class;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(190, label1)
        val label22 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label22)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(179, label2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(181, label23)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Thread",
            "currentThread",
            "()Ljava/lang/Thread;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Thread",
            "getContextClassLoader",
            "()Ljava/lang/ClassLoader;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 7)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(182, label24)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        val label25 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label25)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(183, label26)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/ClassLoader",
            "getSystemClassLoader",
            "()Ljava/lang/ClassLoader;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 7)
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(186, label25)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label22)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(188, label27)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Class",
            "forName",
            "(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(191, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "newInstance",
            "()Ljava/lang/Object;",
            false
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "javax/net/ssl/SSLSocketFactory")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(192, label28)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 6)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(193, label4)
        methodVisitor.visitInsn(Opcodes.RETURN)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(194, label5)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(201, label6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "javax/net/ssl/SSLContext",
            "getDefault",
            "()Ljavax/net/ssl/SSLContext;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(202, label29)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label7)
        val label30 = Label()
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(203, label30)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "javax/net/ssl/SSLContext",
            "getSocketFactory",
            "()Ljavax/net/ssl/SSLSocketFactory;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(206, label7)
        methodVisitor.visitInsn(Opcodes.RETURN)
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(207, label8)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        val label31 = Label()
        methodVisitor.visitLabel(label31)
        methodVisitor.visitLineNumber(208, label31)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label32 = Label()
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLocalVariable("cl", "Ljava/lang/ClassLoader;", null, label24, label22, 7)
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/lang/ClassNotFoundException;",
            null,
            label23,
            label22,
            6
        )
        methodVisitor.visitLocalVariable(
            "cls",
            "Ljava/lang/Class;",
            "Ljava/lang/Class<*>;",
            label0,
            label5,
            5
        )
        methodVisitor.visitLocalVariable(
            "fac",
            "Ljavax/net/ssl/SSLSocketFactory;",
            null,
            label28,
            label5,
            6
        )
        methodVisitor.visitLocalVariable(
            "context",
            "Ljavax/net/ssl/SSLContext;",
            null,
            label29,
            label8,
            5
        )
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/security/NoSuchAlgorithmException;",
            null,
            label31,
            label32,
            5
        )
        methodVisitor.visitLocalVariable(
            "defaultSocketFactory",
            "Ljavax/net/ssl/SSLSocketFactory;",
            null,
            label10,
            label32,
            1
        )
        methodVisitor.visitLocalVariable("lastVersion", "I", null, label11, label32, 2)
        methodVisitor.visitLocalVariable(
            "previousDefaultSocketFactory",
            "Ljavax/net/ssl/SSLSocketFactory;",
            null,
            label15,
            label32,
            3
        )
        methodVisitor.visitLocalVariable("clsName", "Ljava/lang/String;", null, label17, label32, 4)
        methodVisitor.visitMaxs(3, 8)
        methodVisitor.visitEnd()
    }

}