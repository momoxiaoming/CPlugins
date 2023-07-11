package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template5
 *
 * @author mmxm
 * @date 2023/7/11 15:54
 */
object Template5 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(194, label0)
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
        methodVisitor.visitLdcInsn(2147483647L)
        methodVisitor.visitInsn(Opcodes.LAND)
        methodVisitor.visitInsn(Opcodes.LCONST_0)
        methodVisitor.visitInsn(Opcodes.LCMP)
        val label1 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label1)
        val label2 = Label()
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(195, label2)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/net/Proxy",
            "NO_PROXY",
            "Ljava/net/Proxy;"
        )
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(196, label3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "getSecurityManager",
            "()Ljava/lang/SecurityManager;",
            false
        )
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(197, label4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/Proxy",
            "address",
            "()Ljava/net/SocketAddress;",
            false
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/net/InetSocketAddress")
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(198, label5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/InetSocketAddress",
            "getAddress",
            "()Ljava/net/InetAddress;",
            false
        )
        val label6 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label6)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(199, label7)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/InetSocketAddress",
            "getAddress",
            "()Ljava/net/InetAddress;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/Object;)V",
            false
        )
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(201, label6)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label1)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(202, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/InetSocketAddress",
            "isUnresolved",
            "()Z",
            false
        )
        val label9 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label9)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(203, label10)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/net/InetSocketAddress")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/InetSocketAddress",
            "getHostName",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/InetSocketAddress",
            "getPort",
            "()I",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/net/InetSocketAddress",
            "<init>",
            "(Ljava/lang/String;I)V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v3)
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(204, label9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/InetSocketAddress",
            "isUnresolved",
            "()Z",
            false
        )
        val label11 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label11)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(205, label12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/InetSocketAddress",
            "getHostName",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/InetSocketAddress",
            "getPort",
            "()I",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/SecurityManager",
            "checkConnect",
            "(Ljava/lang/String;I)V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label1)
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(207, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/InetSocketAddress",
            "getAddress",
            "()Ljava/net/InetAddress;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/InetAddress",
            "getHostAddress",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v3)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(208, label13)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/net/InetSocketAddress",
            "getPort",
            "()I",
            false
        )
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(207, label14)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/SecurityManager",
            "checkConnect",
            "(Ljava/lang/String;I)V",
            false
        )
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(212, label1)
    }

}