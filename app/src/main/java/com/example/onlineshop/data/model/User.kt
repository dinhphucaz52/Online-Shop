package com.example.onlineshop.data.model

import com.example.onlineshop.common.AppCommon
import com.example.onlineshop.data.api.dto.UserDTO

data class User(
    var email: String = "",
    var name: String = "",
    var phone: String = "",
    var userGroup: Int = AppCommon.USER_GROUP_DEFAULT_VALUE,
    var registerDate: String = "",
    var token: String = ""
) {
    constructor(userDTO: UserDTO) : this() {
        this.email = userDTO.email
        this.name = userDTO.name
        this.phone = userDTO.phone
        this.userGroup = userDTO.userGroup
        this.registerDate = userDTO.registerDate
        this.token = userDTO.token
    }
}