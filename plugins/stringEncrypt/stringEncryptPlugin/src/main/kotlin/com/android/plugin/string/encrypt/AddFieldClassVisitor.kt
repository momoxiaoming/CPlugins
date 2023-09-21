package com.android.plugin.string.encrypt

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.FieldNode

/**
 * @Author: hzh
 * @Date: 2022/10/11
 * @Desc: 特定系统类添加field
 */
class AddFieldClassVisitor(cv:ClassVisitor) : ClassVisitor(Opcodes.ASM9,cv) {



    private val CLAZZ_FRAGMENTACTIVITY = "androidx/fragment/app/FragmentActivity"
    private val Tag_FragmentActivity = "a"

    private val CLAZZ_RECYCLERVIEW = "androidx/recyclerview/widget/RecyclerView"
    private val Tag_RecyclerView = "c"

    private val CLAZZ_TOOLBAR = "androidx/appcompat/widget/Toolbar"
    private val Tag_Toolbar = "h"

    private val CLAZZ_CONSTRAINTLAYOUT = "androidx/constraintlayout/widget/ConstraintLayout"
    private val Tag_ConstraintLayout = "j"


    val mapping = mapOf( CLAZZ_FRAGMENTACTIVITY to Tag_FragmentActivity, CLAZZ_RECYCLERVIEW to Tag_RecyclerView, CLAZZ_TOOLBAR to Tag_Toolbar, CLAZZ_CONSTRAINTLAYOUT to Tag_ConstraintLayout)
    var className: String? = null

    override fun visit(version: Int, access: Int, name: String?, signature: String?, superName: String?, interfaces: Array<out String>?) {
        super.visit(version, access, name, signature, superName, interfaces)
        className = name
    }


    override fun visitField(
        access: Int,
        name: String?,
        desc: String?,
        signature: String?,
        value: Any?
    ): FieldVisitor {
        return super.visitField(access, name, desc, signature, value)
    }

    override fun visitEnd() {


        if ( mapping[className] != null) {
            println("visit end*************************")

            val fv = this.cv.visitField(Opcodes.ACC_STATIC, mapping[className], "Ljava/lang/String;", null, null)

            val av = fv.visitAnnotation("Landroidx/annotation/Keep;", true)
            if (fv != null) {
                println( "visit FieldVisitor*********astring****************")
                fv.visitEnd()
                av.visitEnd()
            } else {
                super.visitEnd()
            }
        } else {
            super.visitEnd()
        }
    }



}