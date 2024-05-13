package com.example.onlineshop.data.api.dto.response

import com.google.gson.annotations.SerializedName

data class AppResponseDTO<T>(
    @SerializedName("result") var result: Int = 0,
    @SerializedName("data") var data: T? = null,
    @SerializedName("message") var message: String = ""
)