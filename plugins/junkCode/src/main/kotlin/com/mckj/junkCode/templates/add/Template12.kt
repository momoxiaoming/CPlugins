package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template12
 *
 * @author mmxm
 * @date 2023/7/11 15:46
 */
object Template12 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/Exception")
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(710, label3)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/String")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLdcInsn("--help")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitLdcInsn("-h")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(711, label4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        val label5 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label5)
        methodVisitor.visitLdcInsn("--help")
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label5)
        methodVisitor.visitLdcInsn("-h")
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label6 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label6)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(712, label5)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("HELP_PAGE_GENERAL")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        val label7 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7)
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(713, label6)
        methodVisitor.visitLdcInsn("--version")
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label8 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label8)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(714, label9)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("VERSION")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7)
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(716, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(718, label0)
        methodVisitor.visitLdcInsn("sign")
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label10 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label10)
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(719, label11)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/Arrays",
            "copyOfRange",
            "([Ljava/lang/Object;II)[Ljava/lang/Object;",
            false
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "[Ljava/lang/String;")
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "[Ljava/lang/String;")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/Object;)V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label1)
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(720, label10)
        methodVisitor.visitLdcInsn("verify")
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label12 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label12)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(721, label13)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/Arrays",
            "copyOfRange",
            "([Ljava/lang/Object;II)[Ljava/lang/Object;",
            false
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "[Ljava/lang/String;")
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "[Ljava/lang/String;")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/Object;)V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label1)
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(722, label12)
        methodVisitor.visitLdcInsn("help")
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label14 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label14)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(723, label15)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("HELP_PAGE_GENERAL")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label1)
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(724, label14)
        methodVisitor.visitLdcInsn("version")
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label16 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label16)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(725, label17)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("VERSION")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label1)
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(727, label16)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/Exception")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/StringBuilder",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitLdcInsn("Unsupported command: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn(". See --help for supported commands")
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
            Opcodes.INVOKESPECIAL,
            "java/lang/Exception",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(732, label1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(729, label2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(730, label18)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "err",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Exception",
            "getMessage",
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
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(731, label19)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/System",
            "exit",
            "(I)V",
            false
        )
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(734, label7)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLocalVariable("e", "Ljava/lang/Exception;", null, label18, label7, 3)
        methodVisitor.visitLocalVariable("str", "Ljava/lang/String;", null, label0, label7, 2)
        methodVisitor.visitLocalVariable("strArr", "[Ljava/lang/String;", null, label4, label20, 1)
        methodVisitor.visitMaxs(4, 4)
        methodVisitor.visitEnd()
    }

}