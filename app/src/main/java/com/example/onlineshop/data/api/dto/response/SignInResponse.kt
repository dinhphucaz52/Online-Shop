package com.example.onlineshop.data.api.dto.response

import com.example.onlineshop.data.api.dto.SignInDTO
import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("result") val result: Int = 0,
    @SerializedName("data") val data: SignInDTO? = null,
    @SerializedName("message") val message: String = ""
)
