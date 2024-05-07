package com.example.onlineshop.presentation.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlineshop.databinding.ActivityHistoryBinding
import com.example.onlineshop.presentation.adapter.HistoryAdapter
import com.example.onlineshop.presentation.`interface`.ActivityBaseInterface

class HistoryActivity : AppCompatActivity(), ActivityBaseInterface {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setEvents()
    }

    override fun init() {
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.historyRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@HistoryActivity, LinearLayoutManager.VERTICAL, false)
            adapter = HistoryAdapter()
        }

    }

    override fun setEvents() {

    }
}