package com.example.onlineshop.data.api.dto

import com.google.gson.annotations.SerializedName

open class SignUpDTO(
    @SerializedName("email") val email: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("phone") val phone: String = "",
    @SerializedName("userGroup") val userGroup: Int = 0,
    @SerializedName("registerDate") val registerDate: String = "",
)