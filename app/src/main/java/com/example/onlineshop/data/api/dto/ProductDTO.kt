package com.example.onlineshop.data.api.dto

import com.google.gson.annotations.SerializedName

data class ProductDTO(
    @SerializedName("_id") val id: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("address") val address: String = "",
    @SerializedName("price") val price: Int = 0,
    @SerializedName("img") val img: String = "",
    @SerializedName("quantity") val quantity: Int = 0,
    @SerializedName("gallery") val gallery: List<String> = listOf(),
    @SerializedName("date_created") val dateCreated: String = "",
    @SerializedName("date_updated") private val dateUpdated: String,
    @SerializedName("__v") private val v: Int = 0
)