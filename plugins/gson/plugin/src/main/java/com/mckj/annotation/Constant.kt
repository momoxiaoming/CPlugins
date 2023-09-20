package com.mckj.annotation

import org.objectweb.asm.Opcodes

object Constant {
    const val ASM = Opcodes.ASM7

    const val ANNOTATION_CONFIG_NAME = "AnnotationConfig"

    const val GSON_CLASS_NAME = "com/google/gson"

    const val ANNOTATION_GSON = "Lcom/google/gson/annotations/SerializedName;"

    /**
     * 替换的加密注解
     */
    const val ANNOTATION_GSON_SAFE = "Lcom/mckj/annotation/tools/EncryptSerializedName;"

    /**
     * Gson --- FieldNamingPolicy 地址
     */
    const val GSON_FIELD_NAMING_POLICY_OWNER = "com/google/gson/FieldNamingPolicy"

    /**
     * Gson --- FieldNamingPolicy --- IDENTITY 枚举
     */
    const val GSON_FIELD_NAMING_POLICY_ENUM = "IDENTITY"

    /**
     * 替换FieldNamingPolicy类信息
     */
    const val REPLACE_FIELD_NAMING_POLICY_OWNER = "com/mckj/annotation/tools/VFieldNameStrategy"
    const val REPLACE_FIELD_NAMING_POLICY_DESCRIPTOR = "Lcom/mckj/annotation/tools/VFieldNameStrategy;"
    const val REPLACE_FIELD_NAMING_POLICY_ENUM = "DEFAULT"

}