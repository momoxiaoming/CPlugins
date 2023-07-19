package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template8
 *
 * @author mmxm
 * @date 2023/7/11 15:44
 */
object Template8 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(1361, label0)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/Random")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/Random",
            "<init>",
            "()V",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/util/Random",
            "nextFloat",
            "()F",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.FSTORE, 1)
        val label1 = Label()
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(1362, label1)
        methodVisitor.visitVarInsn(Opcodes.FLOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Float",
            "floatToIntBits",
            "(F)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 2)
        val label2 = Label()
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(1363, label2)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 16)
        methodVisitor.visitInsn(Opcodes.IUSHR)
        methodVisitor.visitLdcInsn(32768)
        methodVisitor.visitInsn(Opcodes.IAND)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 3)
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(1364, label3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2)
        methodVisitor.visitLdcInsn(2147483647)
        methodVisitor.visitInsn(Opcodes.IAND)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 4096)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 4)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(1366, label4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitLdcInsn(1199570944)
        val label5 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label5)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(1368, label6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2)
        methodVisitor.visitLdcInsn(2147483647)
        methodVisitor.visitInsn(Opcodes.IAND)
        methodVisitor.visitLdcInsn(1199570944)
        val label7 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label7)
        val label8 = Label()
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(1369, label8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitLdcInsn(2139095040)
        val label9 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label9)
        val label10 = Label()
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(1370, label10)
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
        methodVisitor.visitLdcInsn("")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 31744)
        methodVisitor.visitInsn(Opcodes.IOR)
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
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(1371, label9)
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
        methodVisitor.visitLdcInsn("")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 31744)
        methodVisitor.visitInsn(Opcodes.IOR)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2)
        methodVisitor.visitLdcInsn(8388607)
        methodVisitor.visitInsn(Opcodes.IAND)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 13)
        methodVisitor.visitInsn(Opcodes.IUSHR)
        methodVisitor.visitInsn(Opcodes.IOR)
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
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(1374, label7)
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
        methodVisitor.visitLdcInsn("")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitIntInsn(Opcodes.SIPUSH, 31743)
        methodVisitor.visitInsn(Opcodes.IOR)
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
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(1376, label5)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitLdcInsn(947912704)
        val label11 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label11)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(1377, label12)
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
        methodVisitor.visitLdcInsn("")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitLdcInsn(939524096)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 13)
        methodVisitor.visitInsn(Opcodes.IUSHR)
        methodVisitor.visitInsn(Opcodes.IOR)
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
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(1378, label11)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitLdcInsn(855638016)
        val label13 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label13)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(1379, label14)
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
        methodVisitor.visitLdcInsn("")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
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
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(1380, label13)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2)
        methodVisitor.visitLdcInsn(2147483647)
        methodVisitor.visitInsn(Opcodes.IAND)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 23)
        methodVisitor.visitInsn(Opcodes.IUSHR)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 4)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(1381, label15)
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
        methodVisitor.visitLdcInsn("")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 2)
        methodVisitor.visitLdcInsn(8388607)
        methodVisitor.visitInsn(Opcodes.IAND)
        methodVisitor.visitLdcInsn(8388608)
        methodVisitor.visitInsn(Opcodes.IOR)
        methodVisitor.visitLdcInsn(8388608)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 102)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitInsn(Opcodes.IUSHR)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 126)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 4)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitInsn(Opcodes.IUSHR)
        methodVisitor.visitInsn(Opcodes.IOR)
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
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(1384, label16)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLocalVariable("fval", "F", null, label1, label17, 1)
        methodVisitor.visitLocalVariable("fbits", "I", null, label2, label17, 2)
        methodVisitor.visitLocalVariable("sign", "I", null, label3, label17, 3)
        methodVisitor.visitLocalVariable("val", "I", null, label4, label17, 4)
        methodVisitor.visitMaxs(7, 5)
        methodVisitor.visitEnd()
    }

}