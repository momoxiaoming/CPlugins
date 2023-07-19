package com.plugin.unitybug.vistor


import com.plugin.unitybug.extension.ExtensionManager
import org.objectweb.asm.*

/**
 * 字符串加密核心类
 *
 * @author mmxm
 * @date 2022/1/21 16:53
 */
class ByteClassVisitor(cw: ClassWriter) :
    ClassVisitor(Opcodes.ASM6, cw) {

    companion object {

    }
    private lateinit var mClassName: String

    init {
        //初始化的时候,先管理加密类


    }

    /**
     * 访问的每个类的回调接口
     * @param version Int
     * @param access Int
     * @param name String
     * @param signature String
     * @param superName String
     * @param interfaces Array<out String>
     */
    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        mClassName = name!!
        super.visit(version, access, name, signature, superName, interfaces)
    }

    /**
     * 返回类的注解,我们可以在此方法识别注解接口类型,通过此类型判断是否需要过滤掉此类
     * @param desc String
     * @param visible Boolean
     * @return AnnotationVisitor
     */
    override fun visitAnnotation(desc: String?, visible: Boolean): AnnotationVisitor? {
        return super.visitAnnotation(desc, visible)
    }
    /**
     * 访问类的变量field的回调接口,我们需要在此把所有类变量存储起来,便于在后续方法中使用时,加密解密
     * @param access Int 权限
     * @param name String 变量名
     * @param desc String
     * @param signature String
     * @param value Any
     * @return FieldVisitor
     */
    override fun visitField(
        access: Int,
        name: String?,
        desc: String?,
        signature: String?,
        value: Any?
    ): FieldVisitor {
        return  super.visitField(access, name, desc, signature, value)
    }

    /**
     * 访问方法时的回调,在此方法中我们可以实现对字符串的加密逻辑
     * @param access Int
     * @param name String
     * @param desc String
     * @param signature String
     * @param exceptions Array<out String>
     * @return MethodVisitor
     */
    override fun visitMethod(
        access: Int,
        name: String?,
        desc: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        val mv=super.visitMethod(access, name, desc, signature, exceptions)
        val hasThod=ExtensionManager.extension?.getMethods(mClassName)?.find {
            it==name
        }!=null
        if(hasThod){
            println("unityDebug->删除class: "+mClassName+"中的方法--->"+name)
            return ByteMethodVisitor(mv)
        }
        return mv
    }

    override fun visitModule(name: String?, access: Int, version: String?): ModuleVisitor {
        return super.visitModule(name, access, version)
    }


}