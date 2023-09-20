package com.mckj.annotation.visitor

import com.mckj.annotation.Constant
import com.mckj.plugin.common.utils.Logger
import org.objectweb.asm.AnnotationVisitor
import org.objectweb.asm.FieldVisitor

class PluginFieldVisitor(fieldVisitor: FieldVisitor) : FieldVisitor(Constant.ASM, fieldVisitor) {

    override fun visitAnnotation(
        descriptor: String?,
        visible: Boolean
    ): AnnotationVisitor { //如果是SerializedName注解,就进行替换
        val visitor = if (descriptor?.contains(Constant.ANNOTATION_GSON) == true) {
            Logger.i("find SerializedName annotation, prepare encrypt.")
            PluginAnnotationVisitor(super.visitAnnotation(Constant.ANNOTATION_GSON_SAFE, visible))
        } else {
            super.visitAnnotation(descriptor, visible)
        }
        return visitor
    }
}