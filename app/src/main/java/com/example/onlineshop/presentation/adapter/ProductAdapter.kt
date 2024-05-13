package com.example.onlineshop.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlineshop.data.model.Product
import com.example.onlineshop.databinding.ItemFoodBinding

open class ProductAdapter : RecyclerView.Adapter<ProductAdapter.FoodViewHolder>() {

    lateinit var listener: (Product) -> Unit
    private lateinit var context: Context

    private var productList = mutableListOf<Product>()

    class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        context = parent.context
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val product = productList[position]
        Glide.with(context)
            .load(product.gallery[0])
            .into(holder.binding.productImageView)

        holder.binding.apply {

            foodNameTextView.text = product.name
            foodPriceTextView.text = product.getPrice()
            quantityTextView.text = product.quantity.toString()

            //Set Events
            plusQuantityTextView.setOnClickListener {
                product.quantity++
                quantityTextView.text = product.quantity.toString()
            }
            minusQuantityTextView.setOnClickListener {
                product.quantity--
                quantityTextView.text = product.quantity.toString()
            }

            buttonAddToCart.setOnClickListener {
                listener.invoke(product)
            }
        }

    }


    override fun getItemCount() = productList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(it: List<Product>) {
        productList = it.toMutableList()
        notifyDataSetChanged()
    }
}