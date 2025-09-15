package com.example.minutebazar.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.minutebazar.ui.main.ProductListItem

data class Product(val name: String, val price: Int, val imageRes: Int)

val vegetables = listOf(
    Product("Fresh Tomato 1kg", 30, com.example.minutebazar.R.drawable.tomato),
    Product("Potato 1kg", 40, com.example.minutebazar.R.drawable.potato),
    Product("Onion 1kg", 35, com.example.minutebazar.R.drawable.onion),
)

@Composable
fun MainScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    var cartProducts by remember { mutableStateOf<List<Product>>(emptyList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Spacer(Modifier.height(20.dp))
        BasicTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .padding(16.dp)
                        .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.small)
                        .fillMaxWidth()
                        .height(48.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (searchQuery.isEmpty()) Text("Search for...", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f))
                    innerTextField()
                }
            }
        )
        Spacer(Modifier.height(8.dp))
        Text("Get 300Rs cashback", color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(16.dp))

        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            items(vegetables.size) { index ->
                ProductListItem(product = vegetables[index], onAddClick = {
                    cartProducts = cartProducts + vegetables[index]
                    navController.navigate("cart")
                })
            }
        }

        Spacer(Modifier.weight(1f))

        NavigationBar {
            NavigationBarItem(
                selected = true, icon = { Icon(Icons.Default.Home, contentDescription = null) }, label = { Text("Home") }, onClick = {}
            )
            NavigationBarItem(
                selected = false, icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) }, label = { Text("Cart") }, onClick = { navController.navigate("cart") }
            )
            NavigationBarItem(
                selected = false, icon = { Icon(Icons.Default.Person, contentDescription = null) }, label = { Text("Profile") }, onClick = {}
            )
        }
    }
}
