package com.example.onlineshop.presentation.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshop.data.model.Cart
import com.example.onlineshop.data.repository.CartRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {

    companion object {
        private lateinit var instance: CartViewModel

        @MainThread
        fun getInstance(): CartViewModel {
            instance = if (::instance.isInitialized) instance else CartViewModel()
            return instance
        }
    }

    private lateinit var cartRepository: CartRepository

    fun init(cartRepository: CartRepository) {
        this.cartRepository = cartRepository
    }

    private val getProductsLiveData = MutableLiveData<Cart>()

    fun observeCartLiveData() = getProductsLiveData

    fun getCart() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val cart = cartRepository.getCarts()
                getProductsLiveData.postValue(cart)
            } catch (e: Exception) {
                println("MainViewmodel getProducts(): $e")
            }
        }
    }


}