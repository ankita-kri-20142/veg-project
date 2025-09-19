package com.example.minutebazar.ui.main

import com.example.minutebazar.R

data class Product(
    val name: String,
    val price: Int,      // Discounted price
    val imageRes: Int,
    val originalPrice: Int,
    val discountPercent: Int
)

val vegetables = listOf(
    Product("Fresh Onion", 30, R.drawable.onion, 40, 25),
    Product("Fresh Potato", 33, R.drawable.potato, 52, 37),
    Product("Fresh Local Tomato", 36, R.drawable.tomato, 40, 10),
    Product("Fresh Mushroom", 120, R.drawable.tomato, 140, 14),
    Product("Fresh Garlic", 70, R.drawable.tomato, 80, 13)
    // Add more products as needed
)
