package com.mckj.junkCode.templates.modity

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Template12
 *
 * @author mmxm
 * @date 2023/7/11 15:58
 */
object Template12 {
    fun modifyFromCode(methodVisitor: MethodVisitor, index2: Int) {
        var index = index2
        val label0 = Label()
        val label1 = Label()
        val label2 = Label()
        methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/io/IOException")
        val label3 = Label()
        val label4 = Label()
        val label5 = Label()
        methodVisitor.visitTryCatchBlock(label3, label4, label5, "java/lang/Throwable")
        val label6 = Label()
        val label7 = Label()
        val label8 = Label()
        methodVisitor.visitTryCatchBlock(label6, label7, label8, "java/lang/Throwable")
        val label9 = Label()
        methodVisitor.visitTryCatchBlock(label6, label7, label9, null)
        val label10 = Label()
        val label11 = Label()
        val label12 = Label()
        methodVisitor.visitTryCatchBlock(label10, label11, label12, "java/lang/Throwable")
        val label13 = Label()
        methodVisitor.visitTryCatchBlock(label8, label13, label9, null)
        val label14 = Label()
        val label15 = Label()
        val label16 = Label()
        methodVisitor.visitTryCatchBlock(label14, label15, label16, "java/io/IOException")
        val label17 = Label()
        methodVisitor.visitLabel(label17)
        methodVisitor.visitLineNumber(73, label17)
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
        val label18 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label18)
        val label19 = Label()
        methodVisitor.visitLabel(label19)
        methodVisitor.visitLineNumber(74, label19)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v1 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        val label20 = Label()
        methodVisitor.visitLabel(label20)
        methodVisitor.visitLineNumber(75, label20)
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "android/os/Build\$VERSION", "SDK_INT", "I")
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 26)
        val label21 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label21)
        methodVisitor.visitLabel(label0)
        methodVisitor.visitLineNumber(77, label0)
        methodVisitor.visitLdcInsn("temp/dir/a.ak")
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/String")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/nio/file/Paths",
            "get",
            "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;",
            false
        )
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/nio/file/StandardOpenOption",
            "CREATE",
            "Ljava/nio/file/StandardOpenOption;"
        )
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/nio/file/StandardOpenOption",
            "TRUNCATE_EXISTING",
            "Ljava/nio/file/StandardOpenOption;"
        )
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/nio/file/StandardOpenOption",
            "WRITE",
            "Ljava/nio/file/StandardOpenOption;"
        )
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/util/EnumSet",
            "of",
            "(Ljava/lang/Enum;Ljava/lang/Enum;Ljava/lang/Enum;)Ljava/util/EnumSet;",
            false
        )
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/nio/file/attribute/FileAttribute")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/nio/file/Files",
            "newByteChannel",
            "(Ljava/nio/file/Path;Ljava/util/Set;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/channels/SeekableByteChannel;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v1)
        methodVisitor.visitLabel(label1)
        methodVisitor.visitLineNumber(80, label1)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label21)
        methodVisitor.visitLabel(label2)
        methodVisitor.visitLineNumber(78, label2)
        val v2 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label22 = Label()
        methodVisitor.visitLabel(label22)
        methodVisitor.visitLineNumber(79, label22)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/IOException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label21)
        methodVisitor.visitLineNumber(82, label21)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        val label23 = Label()
        methodVisitor.visitLabel(label23)
        methodVisitor.visitLineNumber(83, label23)
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "android/os/Build\$VERSION", "SDK_INT", "I")
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 26)
        val label24 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label24)
        val label25 = Label()
        methodVisitor.visitLabel(label25)
        methodVisitor.visitLineNumber(84, label25)
        methodVisitor.visitLdcInsn("")
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/String")
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/nio/file/Paths",
            "get",
            "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;",
            false
        )
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v2)
        methodVisitor.visitLabel(label24)
        methodVisitor.visitLineNumber(86, label24)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        val v3 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v3)
        val label26 = Label()
        methodVisitor.visitLabel(label26)
        methodVisitor.visitLineNumber(87, label26)
        methodVisitor.visitInsn(Opcodes.ICONST_M1)
        val v4 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v4)
        val label27 = Label()
        methodVisitor.visitLabel(label27)
        methodVisitor.visitLineNumber(88, label27)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        val v5 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v5)
        val label28 = Label()
        methodVisitor.visitLabel(label28)
        methodVisitor.visitLineNumber(89, label28)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v3)
        val v6 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v6)
        val label29 = Label()
        methodVisitor.visitLabel(label29)
        methodVisitor.visitLineNumber(91, label29)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v5)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/nio/ByteBuffer",
            "allocate",
            "(I)Ljava/nio/ByteBuffer;",
            false
        )
        val v7 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v7)
        val label30 = Label()
        methodVisitor.visitLabel(label30)
        methodVisitor.visitLineNumber(92, label30)
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "android/os/Build\$VERSION", "SDK_INT", "I")
        methodVisitor.visitIntInsn(Opcodes.BIPUSH, 26)
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, label18)
        methodVisitor.visitLabel(label14)
        methodVisitor.visitLineNumber(93, label14)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v2)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitTypeInsn(Opcodes.ANEWARRAY, "java/nio/file/OpenOption")
        methodVisitor.visitInsn(Opcodes.DUP)
        methodVisitor.visitInsn(Opcodes.ICONST_0)
        methodVisitor.visitFieldInsn(
            Opcodes.GETSTATIC,
            "java/nio/file/StandardOpenOption",
            "READ",
            "Ljava/nio/file/StandardOpenOption;"
        )
        methodVisitor.visitInsn(Opcodes.AASTORE)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "java/nio/file/Files",
            "newByteChannel",
            "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/nio/channels/SeekableByteChannel;",
            false
        )
        val v8 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v8)
        val label31 = Label()
        methodVisitor.visitLabel(label31)
        methodVisitor.visitInsn(Opcodes.ACONST_NULL)
        val v9 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v9)
        methodVisitor.visitLabel(label6)
        methodVisitor.visitLineNumber(94, label6)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitInsn(Opcodes.I2L)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/nio/channels/SeekableByteChannel",
            "position",
            "(J)Ljava/nio/channels/SeekableByteChannel;",
            true
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label32 = Label()
        methodVisitor.visitLabel(label32)
        methodVisitor.visitLineNumber(96, label32)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/nio/ByteBuffer",
            "clear",
            "()Ljava/nio/Buffer;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label33 = Label()
        methodVisitor.visitLabel(label33)
        methodVisitor.visitLineNumber(97, label33)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/nio/channels/SeekableByteChannel",
            "read",
            "(Ljava/nio/ByteBuffer;)I",
            true
        )
        val v10 = ++index
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v10)
        val label34 = Label()
        methodVisitor.visitLabel(label34)
        methodVisitor.visitLineNumber(98, label34)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/nio/ByteBuffer",
            "rewind",
            "()Ljava/nio/Buffer;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label35 = Label()
        methodVisitor.visitLabel(label35)
        methodVisitor.visitLineNumber(99, label35)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        val label36 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGT, label36)
        val label37 = Label()
        methodVisitor.visitLabel(label37)
        methodVisitor.visitLineNumber(100, label37)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/nio/ByteBuffer",
            "limit",
            "(I)Ljava/nio/Buffer;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label38 = Label()
        methodVisitor.visitLabel(label38)
        methodVisitor.visitLineNumber(101, label38)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/nio/channels/SeekableByteChannel",
            "write",
            "(Ljava/nio/ByteBuffer;)I",
            true
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label39 = Label()
        methodVisitor.visitLabel(label39)
        methodVisitor.visitLineNumber(102, label39)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v10)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitVarInsn(Opcodes.ISTORE, v6)
        val label40 = Label()
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label40)
        methodVisitor.visitLabel(label36)
        methodVisitor.visitLineNumber(104, label36)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v4)
        methodVisitor.visitVarInsn(Opcodes.ILOAD, v6)
        methodVisitor.visitInsn(Opcodes.ISUB)
        methodVisitor.visitInsn(Opcodes.ICONST_1)
        methodVisitor.visitInsn(Opcodes.IADD)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/nio/ByteBuffer",
            "limit",
            "(I)Ljava/nio/Buffer;",
            false
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label41 = Label()
        methodVisitor.visitLabel(label41)
        methodVisitor.visitLineNumber(105, label41)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v1)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v7)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/nio/channels/SeekableByteChannel",
            "write",
            "(Ljava/nio/ByteBuffer;)I",
            true
        )
        methodVisitor.visitInsn(Opcodes.POP)
        val label42 = Label()
        methodVisitor.visitLabel(label42)
        methodVisitor.visitLineNumber(106, label42)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7)
        methodVisitor.visitLabel(label40)
        methodVisitor.visitLineNumber(108, label40)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label32)
        methodVisitor.visitLabel(label7)
        methodVisitor.visitLineNumber(109, label7)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label15)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        val label43 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label43)
        methodVisitor.visitLabel(label3)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/nio/channels/SeekableByteChannel",
            "close",
            "()V",
            true
        )
        methodVisitor.visitLabel(label4)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label15)
        methodVisitor.visitLabel(label5)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v10)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Throwable",
            "addSuppressed",
            "(Ljava/lang/Throwable;)V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label15)
        methodVisitor.visitLabel(label43)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/nio/channels/SeekableByteChannel",
            "close",
            "()V",
            true
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label15)
        methodVisitor.visitLabel(label8)
        methodVisitor.visitLineNumber(93, label8)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v10)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v10)
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label9)
        methodVisitor.visitLineNumber(109, label9)
        val v11 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v11)
        methodVisitor.visitLabel(label13)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        val label44 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label44)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        val label45 = Label()
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label45)
        methodVisitor.visitLabel(label10)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/nio/channels/SeekableByteChannel",
            "close",
            "()V",
            true
        )
        methodVisitor.visitLabel(label11)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label44)
        methodVisitor.visitLabel(label12)
        val v12 = ++index
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v12)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v9)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v12)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/lang/Throwable",
            "addSuppressed",
            "(Ljava/lang/Throwable;)V",
            false
        )
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label44)
        methodVisitor.visitLabel(label45)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEINTERFACE,
            "java/nio/channels/SeekableByteChannel",
            "close",
            "()V",
            true
        )
        methodVisitor.visitLabel(label44)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v11)
        methodVisitor.visitInsn(Opcodes.ATHROW)
        methodVisitor.visitLabel(label15)
        methodVisitor.visitLineNumber(111, label15)
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label18)
        methodVisitor.visitLabel(label16)
        methodVisitor.visitLineNumber(109, label16)
        methodVisitor.visitVarInsn(Opcodes.ASTORE, v8)
        val label46 = Label()
        methodVisitor.visitLabel(label46)
        methodVisitor.visitLineNumber(110, label46)
        methodVisitor.visitVarInsn(Opcodes.ALOAD, v8)
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            "java/io/IOException",
            "printStackTrace",
            "()V",
            false
        )
        methodVisitor.visitLabel(label18)
        methodVisitor.visitLineNumber(114, label18)
    }

}