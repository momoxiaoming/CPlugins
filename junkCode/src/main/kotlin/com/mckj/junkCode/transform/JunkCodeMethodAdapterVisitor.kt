package com.mckj.junkCode.transform

import com.mckj.junkCode.templates.modity.*
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.commons.AdviceAdapter
import kotlin.random.Random

/**
 * JunkCodeMethodAdapterVisitor
 *
 * @author mmxm
 * @date 2023/7/11 14:25
 */
open class JunkCodeMethodAdapterVisitor(mv: MethodVisitor, access: Int,name: String?, descriptor: String?,var index: Int) : AdviceAdapter(
    Opcodes.ASM7,mv, access, name, descriptor) {

    override fun onMethodEnter() {
        super.onMethodEnter()
        modifyMethod(index)
    }

    private fun modifyMethod(index: Int) {
        when(Random.nextInt(20)){
            0->{
                Template1.modifyFromCode(mv,index)
            }
            1->{
                Template2.modifyFromCode(mv,index)
            }
            2->{
                Template3.modifyFromCode(mv,index)
            }
            3->{
                Template4.modifyFromCode(mv,index)
            }
            4->{
                Template5.modifyFromCode(mv,index)
            }
            5->{
                Template6.modifyFromCode(mv,index)
            }
            6->{
                Template7.modifyFromCode(mv,index)
            }
            7->{
                Template8.modifyFromCode(mv,index)
            }
            8->{
                Template9.modifyFromCode(mv,index)
            }
            9->{
                Template10.modifyFromCode(mv,index)
            }
            10->{
                Template11.modifyFromCode(mv,index)
            }
            11->{
                Template12.modifyFromCode(mv,index)
            }
            12->{
                Template13.modifyFromCode(mv,index)
            }
            13->{
                Template14.modifyFromCode(mv,index)
            }
            14->{
                Template15.modifyFromCode(mv,index)
            }
            15->{
                Template16.modifyFromCode(mv,index)
            }
            16->{
                Template17.modifyFromCode(mv,index)
            }
            17->{
                Template18.modifyFromCode(mv,index)
            }
            18->{
                Template19.modifyFromCode(mv,index)
            }
            19->{
                Template20.modifyFromCode(mv,index)
            }
        }
    }
}