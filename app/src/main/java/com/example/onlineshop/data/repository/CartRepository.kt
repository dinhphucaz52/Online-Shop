package com.example.onlineshop.data.repository

import com.example.onlineshop.data.api.APIService
import com.example.onlineshop.data.api.RetrofitClient
import com.example.onlineshop.data.model.Cart
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartRepository {

    private val apiService: APIService? =
        RetrofitClient.getRetrofitInstance().create(APIService::class.java)

    suspend fun getCarts(): Cart {
        return withContext(Dispatchers.IO) {
            val deferred = CompletableDeferred<Cart>()

//            apiService?.getCart()?.enqueue(object : Callback<GetCartResponse> {
//                override fun onResponse(
//                    call: Call<GetCartResponse>,
//                    response: Response<GetCartResponse>
//                ) {
//                    println("CartRepository -> getCarts -> onResponse: $response")
//                    (response.body()?.data)?.let { deferred.complete(Cart(it)) }
//                }
//
//                override fun onFailure(call: Call<GetCartResponse>, throwable: Throwable) {
//                    println("MainRepository -> signIn -> onFailure: $throwable")
//                }
//            })
            deferred.await()
        }
    }

}