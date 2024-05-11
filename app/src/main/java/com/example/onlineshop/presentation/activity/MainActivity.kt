package com.example.onlineshop.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlineshop.data.repository.MainRepository
import com.example.onlineshop.databinding.ActivityMainBinding
import com.example.onlineshop.presentation.adapter.ProductAdapter
import com.example.onlineshop.presentation.`interface`.ActivityBaseInterface
import com.example.onlineshop.presentation.viewmodel.MainViewmodel

class MainActivity : AppCompatActivity(), ActivityBaseInterface {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainRepository: MainRepository
    private lateinit var productAdapter: ProductAdapter
    private val mainMVVM = MainViewmodel.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setEvents()
    }

    override fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.foodRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            productAdapter = ProductAdapter()
            adapter = productAdapter
        }
        mainRepository = MainRepository()
        mainMVVM.init(mainRepository)
        mainMVVM.getProducts()
        dataBinding()
    }

    private fun dataBinding() {
        mainMVVM.observeProductsLiveData().observe(this) {
            productAdapter.updateData(it)
        }
    }

    override fun setEvents() {
        binding.apply {
            cartButton.setOnClickListener {
                startActivity(Intent(this@MainActivity, CartActivity::class.java))
            }
            historyButton.setOnClickListener {
                startActivity(Intent(this@MainActivity, HistoryActivity::class.java))
            }
            nameUserTextView.setOnClickListener {
                startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
            }
        }
    }
}