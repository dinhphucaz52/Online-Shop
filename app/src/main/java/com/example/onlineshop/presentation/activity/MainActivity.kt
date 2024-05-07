package com.example.onlineshop.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlineshop.databinding.ActivityMainBinding
import com.example.onlineshop.presentation.adapter.FoodAdapter
import com.example.onlineshop.presentation.`interface`.ActivityBaseInterface

class MainActivity : AppCompatActivity(), ActivityBaseInterface {
    private lateinit var binding: ActivityMainBinding
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
            adapter = FoodAdapter()
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
        }
    }
}