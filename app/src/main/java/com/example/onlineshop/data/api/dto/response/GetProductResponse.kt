package com.example.onlineshop.data.api.dto.response

import com.example.onlineshop.data.api.dto.ProductDTO
import com.google.gson.annotations.SerializedName

class GetProductResponse(
    @SerializedName("result") val result: Int = 0,
    @SerializedName("data") val data: List<ProductDTO> = listOf(),
)