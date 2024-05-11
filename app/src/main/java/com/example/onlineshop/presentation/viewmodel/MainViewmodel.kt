package com.example.onlineshop.presentation.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshop.data.model.Product
import com.example.onlineshop.data.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

    private val getProductsLiveData = MutableLiveData<List<Product>>()

    fun observeProductsLiveData() = getProductsLiveData

    fun getProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val products = mutableListOf<Product>()
                mainRepository.getProducts().forEach {
                    products.add(Product(it))
                }
                products.sortBy { it.name }
                getProductsLiveData.postValue(products)
            } catch (e: Exception) {
                println("MainViewmodel getProducts(): $e")
            }
        }
    }


}