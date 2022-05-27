package com.plugin.art.task


import jdk.internal.org.objectweb.asm.ClassWriter
import jdk.internal.org.objectweb.asm.Label
import jdk.internal.org.objectweb.asm.Opcodes.*
import jdk.internal.org.objectweb.asm.Type
import java.io.File


/**
 * 字节码层面生成一个java文件,用于防止arouter被keep
 * @author mmxm
 * @date 2022/1/25 18:11
 */
object EncryptClassGenerator {
    /**
     * 生成默认加解密文件
     * @param targetClass String
     * @param applicationId String
     * @param outFile File
     */
    fun createDefaultEncrypt(
        targetClass: String,
        applicationId: String,
        arouterFiles: List<String>,
        outFile: File
    ) {

        val packageName="${applicationId.replace(".","/")}/"
        //确定好是否是外部传入的自定义
        val listClzz = mutableListOf<String>()
        arouterFiles.forEach {
            listClzz.add(it.replace(".", "/"))
        }
        val classWriter = ClassWriter(0);
        classWriter.visit(
            V1_8,
            ACC_PUBLIC or ACC_SUPER,
            packageName + targetClass,
            null,
            "java/lang/Object",
            null
        )
        val fieldVisitor = classWriter.visitField(0, "clzz", "[Ljava/lang/Class;", null, null);
        fieldVisitor.visitEnd();

        val methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        methodVisitor.visitCode();
        val label0 = Label()
        methodVisitor.visitLabel(label0);
        methodVisitor.visitLineNumber(8, label0);
        methodVisitor.visitVarInsn(ALOAD, 0);
        methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        val label1 = Label();
        methodVisitor.visitLabel(label1);
        methodVisitor.visitLineNumber(9, label1);
        methodVisitor.visitVarInsn(ALOAD, 0);
        val size=listClzz.size
        when {
            size <= 5 -> {
                methodVisitor.visitInsn(3+size);
            }
            size in 6..127 -> {
                methodVisitor.visitIntInsn(BIPUSH, size);
            }
            else -> {
                methodVisitor.visitIntInsn(SIPUSH, size);
            }
        }
        methodVisitor.visitTypeInsn(ANEWARRAY, "java/lang/Class");
        var count =0
        listClzz.forEachIndexed { i, s ->
            methodVisitor.visitInsn(DUP);
            when {
                count <= 5 -> {
                    methodVisitor.visitInsn(3+count);
                }
                count in 6..127 -> {
                    methodVisitor.visitIntInsn(BIPUSH, count);
                }
                else -> {
                    methodVisitor.visitIntInsn(SIPUSH, count);
                }
            }
            val newName = s.replace(".", "/")
            methodVisitor.visitLdcInsn(Type.getType("L$newName;"));
            methodVisitor.visitInsn(AASTORE);
            count++

        }
        methodVisitor.visitFieldInsn(
            PUTFIELD,
            packageName + targetClass,
            "clzz",
            "[Ljava/lang/Class;"
        );
        val label2 = Label()
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLineNumber(12 + count, label2);
        methodVisitor.visitInsn(RETURN);

        val label3 = Label()
        methodVisitor.visitLabel(label3);
        methodVisitor.visitLocalVariable(
            "this",
            "L" + packageName + targetClass + ";",
            null,
            label0,
            label3,
            0
        );
        methodVisitor.visitMaxs(5, 1);
        methodVisitor.visitEnd();

        // 获取生成的class文件对应的二进制流
        val code = classWriter.toByteArray()
        //将class 二进制流保存到本地磁盘上
        outFile.writeBytes(code)
    }


}