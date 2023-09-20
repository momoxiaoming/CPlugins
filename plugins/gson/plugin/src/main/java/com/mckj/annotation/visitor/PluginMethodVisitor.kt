package com.mckj.annotation.visitor

import com.mckj.annotation.Constant
import com.mckj.annotation.utlis.Logger
import org.objectweb.asm.MethodVisitor

class PluginMethodVisitor(methodVisitor: MethodVisitor) :
    MethodVisitor(Constant.ASM, methodVisitor) {


    /**
     * 替换后效果
     * public Gson() {
     * this(Excluder.DEFAULT,
     *      VFieldNameStrategy.DEFAULT,
     *      Collections.emptyMap(),
     *      false,false,false,
     *      DEFAULT_ESCAPE_HTML,
     *      false,false,false,
     *      LongSerializationPolicy.DEFAULT,
     *      null, 2, 2,
     *      Collections.emptyList(),
     *      Collections.emptyList(),
     *      Collections.emptyList());
     *      }
     */
    override fun visitFieldInsn(opcode: Int, owner: String?, name: String?, descriptor: String?) {
        if (owner == Constant.GSON_FIELD_NAMING_POLICY_OWNER && name == Constant.GSON_FIELD_NAMING_POLICY_ENUM) {
            Logger.i("start replace FieldNamingPolicy class info")
            super.visitFieldInsn(
                opcode,
                Constant.REPLACE_FIELD_NAMING_POLICY_OWNER,
                Constant.REPLACE_FIELD_NAMING_POLICY_ENUM,
                Constant.REPLACE_FIELD_NAMING_POLICY_DESCRIPTOR
            )
            return
        }
        super.visitFieldInsn(opcode, owner, name, descriptor)
    }
}