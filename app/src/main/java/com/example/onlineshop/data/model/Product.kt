package com.example.onlineshop.data.model

import com.example.onlineshop.common.AppCommon
import com.example.onlineshop.data.api.dto.ProductDTO

data class Product(
    var id: String = "",
    var name: String = "",
    var address: String = "",
    var price: Int = 0,
    var img: String = "",
    var quantity: Int = 0,
    var gallery: MutableList<String> = mutableListOf(),
) {
    constructor(productDTO: ProductDTO) : this() {
        id = productDTO.id
        name = productDTO.name
        address = productDTO.address
        price = productDTO.price
        img = productDTO.img
        quantity = productDTO.quantity
        productDTO.gallery.forEach {
            gallery.add(AppCommon.URL_API + it)
        }
    }

    fun getPrice(): String {
        val result = StringBuilder(price.toString())
        for (i in result.length - 3 downTo 1 step 3) {
            result.insert(i, ".")
        }
        result.append(" VND")
        return result.toString()
    }

}