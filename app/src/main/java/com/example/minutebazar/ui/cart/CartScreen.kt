package com.example.minutebazar.ui.cart


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CartScreen(navController: NavController) {
    // Placeholder for cart product (add cart view model or state as needed)
    val productsInCart = listOf("Fresh Onion 1kg" to 40) // Example
    val total = productsInCart.sumOf { it.second }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Select Delivery Slot", style = MaterialTheme.typography.titleMedium)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("7AM-9AM", "9AM-11AM", "11AM-1PM").forEach {
                Button(onClick = {}, modifier = Modifier.weight(1f)) { Text("Today\n$it") }
            }
        }
        Spacer(Modifier.height(16.dp))
        productsInCart.forEach { (name, price) ->
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(name, modifier = Modifier.weight(1f))
                Text("₹$price")
            }
        }
        Spacer(Modifier.weight(1f))
        Text("Total: ₹$total", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(16.dp))
        Button(onClick = { navController.navigate("login") }, modifier = Modifier.fillMaxWidth()) {
            Text("Checkout your order")
        }
    }
}
