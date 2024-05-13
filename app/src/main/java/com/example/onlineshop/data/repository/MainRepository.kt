package com.example.onlineshop.data.repository

import com.example.onlineshop.data.api.APIService
import com.example.onlineshop.data.api.RetrofitClient
import com.example.onlineshop.data.api.dto.ProductDTO
import com.example.onlineshop.data.api.dto.response.AppResponseDTO
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    private val apiService: APIService? =
        RetrofitClient.getRetrofitInstance().create(APIService::class.java)

    suspend fun getProducts(): AppResponseDTO<List<ProductDTO>> {
        return withContext(Dispatchers.IO) {
            val deferred = CompletableDeferred<AppResponseDTO<List<ProductDTO>>>()

            apiService?.getProduct()?.enqueue(object : Callback<AppResponseDTO<List<ProductDTO>>> {
                override fun onResponse(
                    call: Call<AppResponseDTO<List<ProductDTO>>>,
                    response: Response<AppResponseDTO<List<ProductDTO>>>
                ) {
                    deferred.complete(response.body()!!)
                }

                override fun onFailure(
                    call: Call<AppResponseDTO<List<ProductDTO>>>, throwable: Throwable
                ) {
                    println("Error: ${throwable.message}")
                }
            })
            deferred.await()
        }
    }
}
