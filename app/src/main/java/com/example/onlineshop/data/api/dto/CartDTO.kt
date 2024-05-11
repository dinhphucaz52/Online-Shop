package com.example.onlineshop.data.api.dto

import com.google.gson.annotations.SerializedName

data class CartDTO(
    @SerializedName("_id") val id: String = "",
    @SerializedName("product") val product: List<ProductDTO> = listOf(),
    @SerializedName("id_user") val idUser: String = "",
    @SerializedName("price") val price: Int = 0,
    @SerializedName("date_create") val dateCreate: String = "",
    @SerializedName("__v") val v: Int = 0
)