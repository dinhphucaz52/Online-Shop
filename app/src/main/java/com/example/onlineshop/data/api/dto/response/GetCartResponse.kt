package com.example.onlineshop.data.api.dto.response

import com.example.onlineshop.data.api.dto.CartDTO
import com.google.gson.annotations.SerializedName

data class GetCartResponse(
    @SerializedName("result") val result: Int = 0,
    @SerializedName("data") val data: CartDTO
)

