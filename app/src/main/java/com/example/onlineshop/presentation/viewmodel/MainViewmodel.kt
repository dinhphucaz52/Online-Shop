package com.example.onlineshop.presentation.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import com.example.onlineshop.data.repository.MainRepository

class MainViewmodel : ViewModel() {

    companion object {
        private lateinit var instance: MainViewmodel

        @MainThread
        fun getInstance(): MainViewmodel {
            instance = if (::instance.isInitialized) instance else MainViewmodel()
            return instance
        }
    }

    private lateinit var mainRepository: MainRepository

    fun init(mainRepository: MainRepository) {
        this.mainRepository = mainRepository
    }



}