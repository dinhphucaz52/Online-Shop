package com.example.onlineshop.data.repository

import com.example.onlineshop.data.api.APIService
import com.example.onlineshop.data.api.RetrofitClient

class ProfileRepository {
    private val apiService: APIService = RetrofitClient.getRetrofitInstance().create(APIService::class.java)

}