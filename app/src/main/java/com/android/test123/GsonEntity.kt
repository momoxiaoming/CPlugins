package com.android.test123

import com.google.gson.annotations.SerializedName

data class GsonEntity(
    @SerializedName("name")
    val name: String,
    @SerializedName("tools")
    val tools: String
)