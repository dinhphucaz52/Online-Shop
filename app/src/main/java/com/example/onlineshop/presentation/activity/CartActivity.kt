package com.example.onlineshop.presentation.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlineshop.databinding.ActivityCartBinding
import com.example.onlineshop.presentation.adapter.CartFoodAdapter
import com.example.onlineshop.presentation.`interface`.ActivityBaseInterface

class CartActivity : AppCompatActivity(), ActivityBaseInterface {
    private lateinit var binding: ActivityCartBinding

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
            adapter = CartFoodAdapter()
        }

    }

    override fun setEvents() {
    }
}