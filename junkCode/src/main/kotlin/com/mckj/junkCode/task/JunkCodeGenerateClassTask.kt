package com.mckj.junkCode.task

import com.mckj.junkCode.ext.ExtensionManager
import com.mckj.junkCode.util.Helper
import com.squareup.javapoet.*
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.util.*
import javax.lang.model.element.Modifier
import kotlin.random.Random

/**
 * 随机生成垃圾类
 * 1. 记录生成的垃圾类, 并输出表单用于keep
 *
 * @author mmxm
 * @date 2023/7/11 9:35
 */
open class JunkCodeGenerateClassTask : DefaultTask() {

    @Input
    lateinit var outDir: File

    @TaskAction
    fun doTask() {
        println("JunkCodeGenerateClassTask do task")
        if(!outDir.exists()){
            outDir.mkdirs()
        }
        //随机出包名列表
        val pkgList= mutableListOf<String>()
        val maxRandomPackageNum= if(ExtensionManager.extension?.maxRandomPackageNum?.size==2){
            val min= ExtensionManager.extension?.maxRandomPackageNum?.get(0)?:10
            val max= ExtensionManager.extension?.maxRandomPackageNum?.get(1)?:20
            Random.nextInt(min,max)
        }else{
            Random.nextInt(10,20)
        }

        println("junkCode 随机包名数量:$maxRandomPackageNum")

        for(i in 0 until maxRandomPackageNum){
            pkgList.add("${Helper.randomName()}.${Helper.randomName()}.${Helper.randomName()}")
        }
        val maxRandomClassNum = ExtensionManager.extension?.maxRandomClassCount ?: 0
        val junkClassCount = Random.nextInt(maxRandomClassNum)+10
        println("junkCode 随机添加垃圾类个数:$junkClassCount")
        for (i in 0..junkClassCount) {
            createClassFile(pkgList[Random.nextInt(pkgList.size)])
        }
    }

    private fun createClassFile(packageName:String?) {
       val pkg= if(packageName.isNullOrEmpty()){
            "${Helper.randomName()}.${Helper.randomName()}.${Helper.randomName()}"
        }else{
           packageName
        }
        val className = Helper.randomName()

        //生成垃圾类
        val classBuilder = TypeSpec.classBuilder(className)
        val methodCount = Random.nextInt(ExtensionManager.extension?.maxRandomMethodCount ?: 0)
//        println("junkCode 随机添加垃圾类方法个数:$methodCount")

        //添加方法
        for (i in 0..methodCount) {
            val methodName = Helper.randomName()
            val methodBuilder = MethodSpec.methodBuilder(methodName)
            randomMethodsContent(methodBuilder)
            classBuilder.addMethod(methodBuilder.build())
        }

        //添加Field
        val fieldCount = Random.nextInt(ExtensionManager.extension?.maxRandomFieldCount ?: 0)
        for (i in 0..fieldCount){
            val types= arrayOf(TypeName.BOOLEAN,TypeName.BYTE, TypeName.CHAR,TypeName.INT,TypeName.DOUBLE)
            val field=FieldSpec.builder(types[Random.nextInt(types.size)],Helper.randomName())
            classBuilder.addField(field.build())
        }

        JavaFile.builder(pkg,classBuilder.build()).build().writeTo(outDir)
        val obsClassName = "-keep , allowobfuscation class $pkg.** { *; } \n"
        ExtensionManager.mappingMap.add(obsClassName)
    }

    /**
     * 随机一种方法模板
     * @param methodBuilder Builder
     */
    private fun randomMethodsContent(methodBuilder: MethodSpec.Builder) {
        when (Random.nextInt(10)) {
            0 -> {
                methodBuilder.addStatement("long now = \$T.currentTimeMillis()", System::class.java)
                    .beginControlFlow("if (\$T.currentTimeMillis() < now)", System::class.java)
                    .addStatement("\$T.out.println(\$S)", System::class.java, Helper.randomLengthName(10,100))
                    .nextControlFlow("else if (\$T.currentTimeMillis() == now)", System::class.java)
                    .addStatement("\$T.out.println(\$S)", System::class.java, Helper.randomLengthName(10,100))
                    .nextControlFlow("else")
                    .addStatement("\$T.out.println(\$S)", System::class.java, Helper.randomLengthName(10,100))
                    .endControlFlow()
            }
            1 -> {
                methodBuilder.addCode(
                    ""
                            + "int total = 0;\n"
                            + "for (int i = 0; i < 10; i++) {\n"
                            + "  total += i;\n"
                            + "}\n"
                )
            }
            2 -> {
                methodBuilder.beginControlFlow("try")
                    .addStatement("throw new Exception(\$S)", Helper.randomLengthName(10,100))
                    .nextControlFlow("catch (\$T e)", Exception::class.java)
                    .addStatement("throw new \$T(e)", RuntimeException::class.java)
                    .endControlFlow()
            }
            3 -> {
                methodBuilder.returns(Date::class.java)
                    .addStatement("return new \$T()", Date::class.java)
            }
            4 -> {
                methodBuilder.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .returns(TypeName.VOID)
                        .addParameter(Array<String>::class.java, "args")
                        .addStatement("\$T.out.println(\$S)", System::class.java, Helper.randomLengthName())
            }
            5 -> {
                methodBuilder.returns(Int::class.java)
                    .addCode("int i = ${Random.nextInt(10000)};\n" +
                            "int j=${Random.nextInt(10000)};\n" +
                            "int max=i+j;\n" +
                            "return max;")
            }
            6 -> {
                methodBuilder.addParameter(String::class.java,"str")
                    .beginControlFlow("try")
                    .addStatement("\$T.forName(str)", Class::class.java)
                    .nextControlFlow("catch (\$T e)", Exception::class.java)
                    .addStatement("throw new \$T(e)", RuntimeException::class.java)
                    .endControlFlow()

            }

            7 -> {
                methodBuilder.addParameter(IntArray::class.java,"arr")
                    .addCode(" int max = arr[0];\n" +
                            "    for (int i = 1; i < arr.length; i++) {\n" +
                            "        if (arr[i] > max) {\n" +
                            "            max = arr[i];\n" +
                            "        }\n" +
                            "    }")
            }
            8   -> {
                methodBuilder.addParameter(String::class.java,"str1")
                    .addParameter(String::class.java,"str2")
                    .returns(String::class.java)
                    .addCode(" return str1+str2;")
            }

            9   -> {
                methodBuilder.returns(Int::class.java)
                    .addStatement("return new \$T().nextInt(${Random.nextInt(1000)})", java.util.Random::class.java)
            }
        }
    }
}