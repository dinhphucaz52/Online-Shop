package com.example.onlineshop.presentation.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityHistoryDetailBinding
import com.example.onlineshop.presentation.`interface`.ActivityBaseInterface

class HistoryDetailActivity : AppCompatActivity(), ActivityBaseInterface {

    private lateinit var binding: ActivityHistoryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setEvents()
    }

    override fun init() {
        binding = ActivityHistoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
    }

    override fun setEvents() {
    }
}