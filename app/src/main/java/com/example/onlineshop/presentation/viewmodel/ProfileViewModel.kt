package com.example.onlineshop.presentation.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import com.example.onlineshop.data.repository.ProfileRepository

class ProfileViewModel : ViewModel() {
    companion object {
        private lateinit var instance: ProfileViewModel

        @MainThread
        fun getInstance(): ProfileViewModel {
            instance = if (::instance.isInitialized) instance else ProfileViewModel()
            return instance
        }
    }

    private lateinit var profileRepository: ProfileRepository
    fun init(profileRepository: ProfileRepository) {
        this.profileRepository = profileRepository
    }



}