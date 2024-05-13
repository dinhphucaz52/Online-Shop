package com.example.onlineshop.data.repository

import com.example.onlineshop.data.api.APIService
import com.example.onlineshop.data.api.AppResource
import com.example.onlineshop.data.api.RetrofitClient
import com.example.onlineshop.data.api.dto.UserDTO
import com.example.onlineshop.data.api.dto.response.AppResponseDTO
import com.example.onlineshop.data.model.User
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationRepository {

    private val apiService: APIService by lazy {
        RetrofitClient.getRetrofitInstance().create(APIService::class.java)
    }

    suspend fun signIn(email: String, password: String): AppResource<User> {
        return withContext(Dispatchers.IO) {
            val deferred = CompletableDeferred<AppResource<User>>()

            apiService.signIn(hashMapOf("email" to email, "password" to password))
                .enqueue(object : Callback<AppResponseDTO<UserDTO>> {
                    override fun onResponse(
                        call: Call<AppResponseDTO<UserDTO>>,
                        response: Response<AppResponseDTO<UserDTO>>
                    ) {
                        if (response.errorBody() != null) {
                            deferred.complete(AppResource.Error(response.errorBody()!!.string()))
                        } else {
                            val user = response.body()!!.data?.let { User(it) }
                            deferred.complete(AppResource.Success(user))
                        }
                    }

                    override fun onFailure(
                        call: Call<AppResponseDTO<UserDTO>>,
                        throwable: Throwable
                    ) {
                        println("AuthenticationRepository -> signIn -> onFailure: $throwable")
                    }
                })
            deferred.await()
        }
    }
}

