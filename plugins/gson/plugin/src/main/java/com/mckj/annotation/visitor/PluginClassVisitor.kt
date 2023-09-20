package com.mckj.annotation.visitor

import com.mckj.annotation.Constant
import com.mckj.plugin.common.utils.Logger
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor

class PluginClassVisitor(classVisitor: ClassVisitor, private val classPath: String) :
    ClassVisitor(Constant.ASM, classVisitor) {
    override fun visitField(
        access: Int, name: String?, descriptor: String?, signature: String?, value: Any?
    ): FieldVisitor {
        val visitor = super.visitField(access, name, descriptor, signature, value) //搜索所有带注解的字段
        //如果不是Gson的库,且是白名单里面的类,就替换注解
        if (!classPath.startsWith(Constant.GSON_CLASS_NAME)) {
            Logger.i("PluginClassVisitor: start replace SerializedName annotation [$classPath]")
            return PluginFieldVisitor(visitor)
        }
        return visitor
    }

    override fun visitMethod(
        access: Int,
        name: String?,
        descriptor: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        val visitor = super.visitMethod(
            access, name, descriptor, signature, exceptions
        ) //找到所有的初始化方法,替换Gson初始化源码
        return if (classPath.startsWith(Constant.GSON_CLASS_NAME) && name == "<init>" && descriptor == "()V") {
            Logger.i("PluginClassVisitor: start replace FieldNamingPolicy method [$classPath]")
            PluginMethodVisitor(visitor)
        } else {
            visitor
        }
    }
}