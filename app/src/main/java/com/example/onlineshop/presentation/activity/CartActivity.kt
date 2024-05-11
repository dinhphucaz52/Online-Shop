package com.example.onlineshop.presentation.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlineshop.data.repository.CartRepository
import com.example.onlineshop.databinding.ActivityCartBinding
import com.example.onlineshop.presentation.adapter.CartAdapter
import com.example.onlineshop.presentation.`interface`.ActivityBaseInterface
import com.example.onlineshop.presentation.viewmodel.CartViewModel

class CartActivity : AppCompatActivity(), ActivityBaseInterface {
    private lateinit var binding: ActivityCartBinding
    private lateinit var cartAdapter: CartAdapter
    private lateinit var cartRepository: CartRepository
    private val cartMVVM = CartViewModel.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setEvents()
    }

    override fun init() {
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@CartActivity, LinearLayoutManager.VERTICAL, false)
            cartAdapter = CartAdapter()
            adapter = cartAdapter
        }
        cartRepository = CartRepository()
        cartMVVM.init(cartRepository)
        cartMVVM.getCart()
        dataBinding()
    }

    private fun dataBinding() {
        cartMVVM.apply {
            observeCartLiveData().observe(this@CartActivity) {
                cartAdapter.updateData(it.productsList)
            }
        }
    }

    override fun setEvents() {
    }
}