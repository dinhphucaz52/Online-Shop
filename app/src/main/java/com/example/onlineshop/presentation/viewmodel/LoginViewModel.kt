package com.example.onlineshop.presentation.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import com.example.onlineshop.data.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel {

    companion object {
        private lateinit var instance: LoginViewModel

        @MainThread
        fun getInstance(): LoginViewModel {
            instance = if (::instance.isInitialized) instance else LoginViewModel()
            return instance
        }
    }

    private lateinit var loginRepository: LoginRepository

    fun init(loginRepository: LoginRepository) {
        this.loginRepository = loginRepository
    }

    private val loginLiveData = MutableLiveData(false)

    fun observeLoginLiveData() = loginLiveData

    fun login(username: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = loginRepository.signIn(username, password)
            loginLiveData.postValue(result)
        }
    }


}