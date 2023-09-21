package com.android.plugin.string.encrypt

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.FieldNode

/**
 * @Author: hzh
 * @Date: 2022/10/11
 * @Desc: 修改HexDecryptUtils 中的加载so文件名称
 */
class ModifySoNameClassVisitor(private val soName: String, cv: ClassVisitor) : ClassVisitor(Opcodes.ASM9, cv) {

    private val needModifySoNameClass = "com/android/lib/string/decrypt/HexDecryptUtils"
    private val needModifySoNameClass2 = "androidx/security/crypto/utils/RiskLoadUtil"
    private val needModifySoNameClass3 = "com/android/lib/NativeToolsLib"

    var className: String? = null


    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        super.visit(version, access, name, signature, superName, interfaces)
        className = name

        StringEncryptPlugin.log("ModifySoNameClassVisitor className >>> $className")
    }


    override fun visitMethod(
        access: Int,
        name: String?,
        desc: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {

        var mv = super.visitMethod(access, name, desc, signature, exceptions)
        if(className == needModifySoNameClass || className == needModifySoNameClass2 || className == needModifySoNameClass3) {
            mv = ModifySoNameMethodVisitor(mv, name, soName)
            println("modifysoname soName="+soName+"needModifySoNameClass3="+needModifySoNameClass3)
        }
        return mv
    }


}