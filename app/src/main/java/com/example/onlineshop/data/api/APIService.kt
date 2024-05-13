package com.example.onlineshop.data.api

import com.example.onlineshop.data.api.dto.ProductDTO
import com.example.onlineshop.data.api.dto.UserDTO
import com.example.onlineshop.data.api.dto.response.AppResponseDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {
    @POST("user/sign-in")
    fun signIn(@Body map: HashMap<String, Any>): Call<AppResponseDTO<UserDTO>>

    @GET("product")
    fun getProduct(): Call<AppResponseDTO<List<ProductDTO>>>
}