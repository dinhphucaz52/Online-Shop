package com.example.onlineshop.data.repository

import com.example.onlineshop.data.api.APIService
import com.example.onlineshop.data.api.RetrofitClient
import com.example.onlineshop.data.api.dto.SignInBody
import com.example.onlineshop.data.api.dto.response.SignInResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {
    private val apiService: APIService? =
        RetrofitClient.getRetrofitInstance().create(APIService::class.java)

    suspend fun signIn(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val signInBody = SignInBody(email, password)
            apiService?.signIn(signInBody)
                ?.enqueue(object : Callback<SignInResponse> {
                    override fun onResponse(
                        call: Call<SignInResponse>,
                        response: Response<SignInResponse>
                    ) {
                        println("LoginRepository -> signIn -> onResponse: $response")
                    }

                    override fun onFailure(call: Call<SignInResponse>, throwable: Throwable) {
                        println("LoginRepository -> signIn -> onFailure: $throwable")
                    }
                })
            false
        }
    }
}