package com.example.onlineshop.data.api.dto

import com.google.gson.annotations.SerializedName

class SignInDTO(
    @SerializedName("token") val token: String = ""
) : SignUpDTO()