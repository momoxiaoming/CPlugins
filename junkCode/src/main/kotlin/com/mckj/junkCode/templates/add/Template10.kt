package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type

/**
 * Template10
 *
 * @author mmxm
 * @date 2023/7/11 15:45
 */
object Template10 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/IllegalAccessException")
        val label3 = Label()
        methodVisitor.visitTryCatchBlock(
            label0,
            label1,
            label3,
            "java/lang/IllegalArgumentException"
        )
        val label4 = Label()
        methodVisitor.visitTryCatchBlock(
            label0,
            label1,
            label4,
            "java/lang/reflect/InvocationTargetException"
        )
        val label5 = Label()
        val label6 = Label()
        val label7 = Label()
        methodVisitor.visitTryCatchBlock(label5, label6, label7, "java/lang/NoSuchMethodException")
        val label8 = Label()
        val label9 = Label()
        val label10 = Label()
        methodVisitor.visitTryCatchBlock(
            label8,
            label9,
            label10,
            "java/lang/ClassNotFoundException"
        )
        val label11 = Label()
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(617, label11)
        methodVisitor.visitLdcInsn("b.so")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 0)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(618, label12)
        methodVisitor.visitLdcInsn("a.so")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label13 = Label()
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(619, label13)
        methodVisitor.visitLdcInsn("c.so")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(620, label14)
        methodVisitor.visitLdcInsn("persist.sys.dalvik.vm.lib")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(622, label8)
        methodVisitor.visitLdcInsn("android.os.oo")
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(623, label15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Class",
            "forName",
            "(Ljava/lang/String;)Ljava/lang/Class;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(625, label5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitLdcInsn("get")
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Class")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLdcInsn(Type.getType("Ljava/lang/String;"))
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitLdcInsn(Type.getType("Ljava/lang/String;"))
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "getMethod",
            "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        val label16 = Label()
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(627, label16)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label0)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(628, label17)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("WTF?!")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(631, label0)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            6,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/Class",
                "java/lang/reflect/Method"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 5)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Object")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitLdcInsn("Dalvik")
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/reflect/Method",
            "invoke",
            "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;",
            false
        )
        methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, "java/lang/String")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(634, label18)
        methodVisitor.visitLdcInsn("b.so")
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label19 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label19)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(635, label20)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("Dalvik")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label21)
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(636, label19)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            7,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/Class",
                "java/lang/reflect/Method",
                "java/lang/String"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitLdcInsn("a.so")
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        val label22 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label22)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(637, label23)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("ART")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label21)
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(638, label22)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            7,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/Class",
                "java/lang/reflect/Method",
                "java/lang/String"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitLdcInsn("c.so")
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "equals",
            "(Ljava/lang/Object;)Z",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label21)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(639, label24)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("ART debug build")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(642, label21)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            7,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/Class",
                "java/lang/reflect/Method",
                "java/lang/String"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 6)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(649, label1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label6)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(643, label2)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            6,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/Class",
                "java/lang/reflect/Method"
            ),
            1,
            arrayOf<Any>("java/lang/IllegalAccessException")
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(644, label25)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("IllegalAccessException")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(649, label26)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label6)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(645, label3)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            6,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/Class",
                "java/lang/reflect/Method"
            ),
            1,
            arrayOf<Any>("java/lang/IllegalArgumentException")
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(646, label27)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("IllegalArgumentException")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(649, label28)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label6)
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(647, label4)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            6,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/Class",
                "java/lang/reflect/Method"
            ),
            1,
            arrayOf<Any>("java/lang/reflect/InvocationTargetException")
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(648, label29)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("InvocationTargetException")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(652, label6)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            5,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/Class"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label9)
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(650, label7)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            5,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/Class"
            ),
            1,
            arrayOf<Any>("java/lang/NoSuchMethodException")
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 5)
        val label30 = Label()
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(651, label30)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("SystemProperties.get(String key, String def) method is not found")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(655, label9)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            4,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String"
            ),
            0,
            arrayOf()
        )
        val label31 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label31)
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(653, label10)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            4,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String"
            ),
            1,
            arrayOf<Any>("java/lang/ClassNotFoundException")
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        val label32 = Label()
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(654, label32)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/System",
            "out",
            "Ljava/io/PrintStream;"
        )
        methodVisitor.visitLdcInsn("SystemProperties class is not found")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitLabel(label31)
        methodVisitor.visitLineNumber(656, label31)
        methodVisitor.visitFrame(
            Opcodes.F_NEW,
            4,
            arrayOf<Any>(
                "java/lang/String",
                "java/lang/String",
                "java/lang/String",
                "java/lang/String"
            ),
            0,
            arrayOf()
        )
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLocalVariable("value", "Ljava/lang/String;", null, label18, label1, 6)
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/lang/IllegalAccessException;",
            null,
            label25,
            label26,
            6
        )
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/lang/IllegalArgumentException;",
            null,
            label27,
            label28,
            6
        )
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/lang/reflect/InvocationTargetException;",
            null,
            label29,
            label6,
            6
        )
        methodVisitor.visitLocalVariable(
            "get",
            "Ljava/lang/reflect/Method;",
            null,
            label16,
            label6,
            5
        )
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/lang/NoSuchMethodException;",
            null,
            label30,
            label9,
            5
        )
        methodVisitor.visitLocalVariable(
            "systemProperties",
            "Ljava/lang/Class;",
            "Ljava/lang/Class<*>;",
            label5,
            label9,
            4
        )
        methodVisitor.visitLocalVariable(
            "e",
            "Ljava/lang/ClassNotFoundException;",
            null,
            label32,
            label31,
            4
        )
        methodVisitor.visitLocalVariable(
            "LIB_DALVIK",
            "Ljava/lang/String;",
            null,
            label12,
            label33,
            0
        )
        methodVisitor.visitLocalVariable("LIB_ART", "Ljava/lang/String;", null, label13, label33, 1)
        methodVisitor.visitLocalVariable(
            "LIB_ART_D",
            "Ljava/lang/String;",
            null,
            label14,
            label33,
            2
        )
        methodVisitor.visitLocalVariable(
            "SELECT_RUNTIME_PROPERTY",
            "Ljava/lang/String;",
            null,
            label8,
            label33,
            3
        )
        methodVisitor.visitMaxs(6, 7)
        methodVisitor.visitEnd()
    }

}