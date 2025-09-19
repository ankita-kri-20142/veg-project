package com.example.minutebazar.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.border


data class CartItem(val name: String, var price: Int, var quantity: Int)

@Composable
fun CartScreen(navController: NavController) {
    // Delivery slots
    val deliverySlots = listOf("5 AM - 7 AM", "7 AM - 9 AM", "9 AM - 11 AM", "11 AM - 1 PM")
    var selectedSlot by remember { mutableStateOf(0) }

    // Cart items (as state)
    val deliveryThreshold = 219
    val initialCart = remember {
        mutableStateListOf(
            CartItem("Fresh Onion 1kg", 30, 1)
            // Add more items as needed
        )
    }

    val itemTotal = initialCart.sumOf { it.price * it.quantity }
    val deliveryShortAmount = (if (itemTotal < deliveryThreshold) deliveryThreshold - itemTotal else 0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Delivery slots
        Text("SELECT DELIVERY SLOT", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp))
        Row {
            deliverySlots.forEachIndexed { idx, slot ->
                val selected = idx == selectedSlot
                val slotColor = if (selected) Color(0xFFE6F3E6) else Color.White
                val borderColor = if (selected) Color(0xFF00834C) else Color(0xFFD3D8DF)
                TextButton(
                    onClick = { selectedSlot = idx },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .padding(end = if (idx != deliverySlots.lastIndex) 8.dp else 0.dp)
                        .background(slotColor)
                        .border(2.dp, borderColor, RoundedCornerShape(8.dp))
                ) {
                    Text(
                        text = "Tomorrow\n$slot",
                        color = if (selected) Color(0xFF00834C) else Color.Black,
                        fontSize = 13.sp,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        // Cart Items section
        initialCart.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Text(item.name, modifier = Modifier.weight(1f), fontSize = 15.sp)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = { if (item.quantity > 1) item.quantity-- },
                        enabled = item.quantity > 1
                    ) {
                        Icon(Icons.Filled.Remove, contentDescription = "Remove")
                    }
                    Text(item.quantity.toString(), modifier = Modifier.width(24.dp), fontSize = 15.sp)
                    IconButton(
                        onClick = { item.quantity++ }
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "Add")
                    }
                }
                Spacer(Modifier.width(10.dp))
                Text("₹${item.price * item.quantity}", fontWeight = FontWeight.SemiBold)
            }
        }

        if (deliveryShortAmount > 0) {
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F8E9)),
            ) {
                Text(
                    "Add items worth ₹$deliveryShortAmount more for Free delivery",
                    modifier = Modifier.padding(12.dp),
                    fontSize = 14.sp,
                    color = Color(0xFF388E3C)
                )
            }
        }

        Spacer(Modifier.weight(1f))

        Divider()
        Spacer(Modifier.height(8.dp))

        // Total and action button
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("You pay", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            Text("₹$itemTotal", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("checkout") },
            modifier = Modifier.fillMaxWidth(),
            enabled = itemTotal > 0
        ) {
            Text(if (itemTotal > 0) "Proceed to pay" else "Add items to continue")
        }
    }
}
