package com.mckj.annotation.visitor

import com.mckj.annotation.Constant
import com.mckj.annotation.utlis.HexEncryptUtils
import com.mckj.annotation.utlis.Logger
import org.objectweb.asm.AnnotationVisitor

class PluginAnnotationVisitor(annotationVisitor: AnnotationVisitor) :
    AnnotationVisitor(Constant.ASM, annotationVisitor) {

    override fun visit(name: String?, value: Any?) {
        if (value is String && name == "value") {
            Logger.i("start encrypt value [$value]")
            //byte最大值为127,防止Int转Byte溢出
            val password = IntRange(1,127).random()
            val passwordByte = password.toByte()
            val result = HexEncryptUtils.encrypt(
                value.toByteArray(), password
            )
            val newBytes = ByteArray(result.size + 1)
            result.copyInto(newBytes)
            newBytes[newBytes.size - 1] = passwordByte
            super.visit("value", newBytes)
            return
        }
        super.visit(name, value)
    }
}