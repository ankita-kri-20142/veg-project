package com.example.minutebazar.ui.main

import com.example.minutebazar.R


data class Product(
    val name: String,
    val price: Int,
    val imageRes: Int,
    val originalPrice: Int,
    val discountPercent: Int
)

val vegetables = listOf(
    Product("Onion", 30, R.drawable.onion, 40, 25),
    Product("Potato", 33, R.drawable.potato, 52, 37),
    Product("Tomato", 36, R.drawable.tomato, 40, 10),
    Product("Mushroom", 120, R.drawable.mushroom, 140, 14),
    Product("Garlic", 70, R.drawable.garlic, 80, 13),
    Product("Carrot", 45, R.drawable.carrot, 55, 18),
    Product("Broccoli", 80, R.drawable.broccoli, 95, 16),
    Product("Cabbage", 25, R.drawable.cabbage, 30, 17),
    Product("Cauliflower", 60, R.drawable.cauliflower, 70, 14),
    Product("Green Beans", 40, R.drawable.greenbeans, 50, 20)
    // Add more products similarly
)
