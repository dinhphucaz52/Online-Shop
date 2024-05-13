package com.example.onlineshop.presentation.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshop.data.api.AppResource
import com.example.onlineshop.data.model.User
import com.example.onlineshop.data.repository.AuthenticationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthenticationViewModel: ViewModel() {

    companion object {
        private lateinit var instance: AuthenticationViewModel

        @MainThread
        fun getInstance(): AuthenticationViewModel {
            instance = if (::instance.isInitialized) instance else AuthenticationViewModel()
            return instance
        }
    }

    private lateinit var authenticationRepository: AuthenticationRepository

    fun init(authenticationRepository: AuthenticationRepository) {
        this.authenticationRepository = authenticationRepository
    }


    private val signInLiveData = MutableLiveData<AppResource<User>>()
    fun observeSignInLiveData() = signInLiveData

    fun login(email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = authenticationRepository.signIn(email, password)
            signInLiveData.postValue(result)
        }
    }


}