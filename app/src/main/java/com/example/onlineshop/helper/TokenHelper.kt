package com.example.onlineshop.helper

object TokenHelper {

    private var token = ""

    fun getToken(): String {
        return token
    }

    fun setToken(token: String) {
        this.token = token
    }
}