package com.example.onlineshop.data.api.dto

import com.example.onlineshop.common.AppCommon
import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("email") val email: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("phone") val phone: String = "",
    @SerializedName("userGroup") val userGroup: Int = AppCommon.USER_GROUP_DEFAULT_VALUE,
    @SerializedName("registerDate") val registerDate: String = "",
    @SerializedName("token") val token: String = ""
)