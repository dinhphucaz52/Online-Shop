package com.example.onlineshop.data.model

import com.example.onlineshop.data.api.dto.CartDTO

class Cart(
    var id: String = "",
    var idUser: String = "",
    var productsList: MutableList<Product> = mutableListOf(),
    var totalPrice: Int = 0,
    var dateCreate: String = ""
) {
    constructor(cartDTO: CartDTO) : this() {
        id = cartDTO.id
        idUser = cartDTO.idUser
        cartDTO.product.forEach {
            productsList.add(Product(it))
        }
        totalPrice = cartDTO.price
        dateCreate = cartDTO.dateCreate
    }

}
