package com.example.onlineshop.data.repository

import com.example.onlineshop.data.api.APIService
import com.example.onlineshop.data.api.RetrofitClient
import com.example.onlineshop.data.api.dto.ProductDTO
import com.example.onlineshop.data.api.dto.response.GetProductResponse
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    private val apiService: APIService? =
        RetrofitClient.getRetrofitInstance().create(APIService::class.java)

    suspend fun getProducts(): List<ProductDTO> {
        return withContext(Dispatchers.IO) {
            val deferred = CompletableDeferred<List<ProductDTO>>()

            apiService?.getProduct()?.enqueue(object : Callback<GetProductResponse> {
                override fun onResponse(
                    call: Call<GetProductResponse>,
                    response: Response<GetProductResponse>
                ) {
                    deferred.complete(response.body()?.data ?: listOf())
                    println("MainRepository -> signIn -> onResponse: ${response.body()}")
                }

                override fun onFailure(call: Call<GetProductResponse>, throwable: Throwable) {
                    println("MainRepository -> signIn -> onFailure: $throwable")
                }
            })
            deferred.await()
        }
    }
}
