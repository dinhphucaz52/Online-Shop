package com.example.onlineshop.data.api.dto.response

import com.example.onlineshop.data.api.dto.SignUpDTO
import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("result") val result: Int = 0,
    @SerializedName("message") val message: String = "",
    @SerializedName("data") val data: SignUpDTO? = null
)

