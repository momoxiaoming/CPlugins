package com.mckj.junkCode.templates.add

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type

/**
 * Template20
 *
 * @author mmxm
 * @date 2023/7/11 15:52
 */
object Template20 {
    fun fillfromCode(methodVisitor: MethodVisitor) {
        methodVisitor.visitCode()
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/ClassNotFoundException")
        val label3 = Label()
        methodVisitor.visitLabel(label3)
        methodVisitor.visitLineNumber(1230, label3)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 1)
        val label4 = Label()
        methodVisitor.visitLabel(label4)
        methodVisitor.visitLineNumber(1231, label4)
        methodVisitor.visitInsn(Opcodes.ICONST_5)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Class")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitLdcInsn(Type.getType("Ljava/lang/String;"))
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitLdcInsn(Type.getType("Ljava/lang/String;"))
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_2)
        methodVisitor.visitLdcInsn(Type.getType("Ljava/lang/String;"))
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_3)
        methodVisitor.visitLdcInsn(Type.getType("Ljava/lang/String;"))
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_4)
        methodVisitor.visitLdcInsn(Type.getType("Ljava/lang/String;"))
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2)
        val label5 = Label()
        methodVisitor.visitLabel(label5)
        methodVisitor.visitLineNumber(1233, label5)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/IdentityHashMap")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/util/IdentityHashMap",
            "<init>",
            "(I)V",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 3)
        val label6 = Label()
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(1234, label6)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 6)
        val label7 = Label()
        methodVisitor.visitLabel(label7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        val label8 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 6)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 7)
        val label9 = Label()
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(1236, label9)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 8)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(1238, label0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "getName",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 1)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/Class",
            "forName",
            "(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 8)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(1240, label1)
        val label10 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label10)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(1239, label2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 9)
        methodVisitor.visitLabel(label10)
        methodVisitor.visitLineNumber(1241, label10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        val label11 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ACMPEQ, label11)
        val label12 = Label()
        methodVisitor.visitLabel(label12)
        methodVisitor.visitLineNumber(1242, label12)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
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
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/Object;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitLdcInsn(" is not visible from class loader")
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
            "java/lang/IllegalArgumentException",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label11)
        methodVisitor.visitLineNumber(1246, label11)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "isInterface",
            "()Z",
            false
        )
        val label13 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label13)
        val label14 = Label()
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(1247, label14)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
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
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        val label15 = Label()
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(1248, label15)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "getName",
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
        methodVisitor.visitLdcInsn(" is not an interface")
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
            "java/lang/IllegalArgumentException",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label13)
        methodVisitor.visitLineNumber(1251, label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/lang/Boolean",
            "TRUE",
            "Ljava/lang/Boolean;"
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/util/Map",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            true
        )
        val label16 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label16)
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(1252, label17)
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException")
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
        methodVisitor.visitLdcInsn("repeated interface: ")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 8)
        val label18 = Label()
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(1253, label18)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "getName",
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
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "toString",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESPECIAL,
            "java/lang/IllegalArgumentException",
            "<init>",
            "(Ljava/lang/String;)V",
            false
        )
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(1234, label16)
        methodVisitor.visitIincInsn(6, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7)
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(1257, label8)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(1258, label19)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 17)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(1261, label20)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 6)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 6)
        methodVisitor.visitInsn(Opcodes.ARRAYLENGTH)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 7)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 8)
        val label21 = Label()
        methodVisitor.visitLabel(label21)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 7)
        val label22 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 8)
        methodVisitor.visitInsn(Opcodes.AALOAD)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 9)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(1262, label23)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 9)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "getModifiers",
            "()I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 10)
        val label24 = Label()
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(1263, label24)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 10)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/lang/reflect/Modifier",
            "isPublic",
            "(I)Z",
            false
        )
        val label25 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label25)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(1264, label26)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 16)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 5)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(1265, label27)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 9)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Class",
            "getName",
            "()Ljava/lang/String;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 11)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(1266, label28)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 11)
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 46)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "lastIndexOf",
            "(I)I",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ISTORE, 12)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(1267, label29)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 12)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        val label30 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label30)
        methodVisitor.visitLdcInsn("")
        val label31 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label31)
        methodVisitor.visitLabel(label30)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 11)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 12)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/String",
            "substring",
            "(II)Ljava/lang/String;",
            false
        )
        methodVisitor.visitLabel(label31)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 13)
        val label32 = Label()
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(1268, label32)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label25)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(1269, label33)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 13)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(1261, label25)
        methodVisitor.visitIincInsn(8, 1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label21)
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(1274, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 4)
        val label34 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label34)
        val label35 = Label()
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(1276, label35)
        methodVisitor.visitLdcInsn("")
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 4)
        val label36 = Label()
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLineNumber(1277, label36)
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
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/StringBuilder",
            "append",
            "(I)Ljava/lang/StringBuilder;",
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
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(1280, label34)
        methodVisitor.visitInsn(Opcodes.RETURN)
        val label37 = Label()
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLocalVariable(
            "interfaceClass",
            "Ljava/lang/Class;",
            "Ljava/lang/Class<*>;",
            label0,
            label16,
            8
        )
        methodVisitor.visitLocalVariable(
            "intf",
            "Ljava/lang/Class;",
            "Ljava/lang/Class<*>;",
            label9,
            label16,
            7
        )
        methodVisitor.visitLocalVariable("name", "Ljava/lang/String;", null, label28, label25, 11)
        methodVisitor.visitLocalVariable("n", "I", null, label29, label25, 12)
        methodVisitor.visitLocalVariable("pkg", "Ljava/lang/String;", null, label32, label25, 13)
        methodVisitor.visitLocalVariable("flags", "I", null, label24, label25, 10)
        methodVisitor.visitLocalVariable(
            "intf",
            "Ljava/lang/Class;",
            "Ljava/lang/Class<*>;",
            label23,
            label25,
            9
        )
        methodVisitor.visitLocalVariable(
            "loader",
            "Ljava/lang/ClassLoader;",
            null,
            label4,
            label37,
            1
        )
        methodVisitor.visitLocalVariable(
            "interfaces",
            "[Ljava/lang/Class;",
            "[Ljava/lang/Class<*>;",
            label5,
            label37,
            2
        )
        methodVisitor.visitLocalVariable(
            "interfaceSet",
            "Ljava/util/Map;",
            "Ljava/util/Map<Ljava/lang/Class<*>;Ljava/lang/Boolean;>;",
            label6,
            label37,
            3
        )
        methodVisitor.visitLocalVariable(
            "proxyPkg",
            "Ljava/lang/String;",
            null,
            label19,
            label37,
            4
        )
        methodVisitor.visitLocalVariable("accessFlags", "I", null, label20, label37, 5)
        methodVisitor.visitMaxs(4, 14)
        methodVisitor.visitEnd()
    }

}