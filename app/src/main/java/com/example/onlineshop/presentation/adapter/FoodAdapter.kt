package com.example.onlineshop.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.ItemFoodBinding

open class FoodAdapter : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 20
}