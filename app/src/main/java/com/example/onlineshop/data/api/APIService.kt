package com.example.onlineshop.data.api

import com.example.onlineshop.data.api.dto.SignInBody
import com.example.onlineshop.data.api.dto.response.GetCartResponse
import com.example.onlineshop.data.api.dto.response.GetProductResponse
import com.example.onlineshop.data.api.dto.response.SignInResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST

interface APIService {

    @POST("/user/sign-in")
    fun signIn(
        @Body signInBody: SignInBody
    ): Call<SignInResponse>

    @GET("/product")
    fun getProduct(): Call<GetProductResponse>

    @GET("/cart")
    fun getCart(): Call<GetCartResponse>
}