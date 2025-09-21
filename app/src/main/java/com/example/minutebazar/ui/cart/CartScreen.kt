package com.example.minutebazar.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.navigation.NavHostController
import com.example.minutebazar.ui.main.Product
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CartScreen(
    navController: NavHostController,
    cartProducts: MutableMap<Product, Int>
) {
    val deliverySlots = listOf("5 AM - 7 AM", "7 AM - 9 AM", "9 AM - 11 AM", "11 AM - 1 PM")
    var selectedSlot by remember { mutableStateOf(0) }

    val deliveryThreshold = 219
    val itemTotal = cartProducts.entries.sumOf { (product, qty) -> product.price * qty }
    val deliveryShortAmount = (if (itemTotal < deliveryThreshold) deliveryThreshold - itemTotal else 0)

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopAppBar(
            title = { Text("Cart") },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, "Back")
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.White)
        )
        Spacer(Modifier.height(16.dp))
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
                        "Tomorrow\n$slot",
                        color = if (selected) Color(0xFF00834C) else Color.Black,
                        fontSize = 13.sp,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }
        Spacer(Modifier.height(20.dp))

        cartProducts.forEach { (product, quantity) ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Text(product.name, Modifier.weight(1f), fontSize = 15.sp)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = { if (quantity > 1) cartProducts[product] = quantity - 1 },
                        enabled = quantity > 1
                    ) {
                        Icon(Icons.Filled.Remove, "Remove")
                    }
                    Text(quantity.toString(), Modifier.width(24.dp), fontSize = 15.sp)
                    IconButton(onClick = { cartProducts[product] = quantity + 1 }) {
                        Icon(Icons.Filled.Add, "Add")
                    }
                }
                Spacer(Modifier.width(10.dp))
                Text("₹${product.price * quantity}", fontWeight = FontWeight.SemiBold)
            }
        }

        if (deliveryShortAmount > 0) {
            Card(
                Modifier.fillMaxWidth().padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F8E9)),
            ) {
                Text(
                    "Add items worth ₹$deliveryShortAmount more for Free delivery",
                    Modifier.padding(12.dp),
                    fontSize = 14.sp,
                    color = Color(0xFF388E3C)
                )
            }
        }

        Spacer(Modifier.weight(1f))

        Divider()
        Spacer(Modifier.height(8.dp))

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("You pay", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            Text("₹$itemTotal", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("checkout") },
            Modifier.fillMaxWidth(),
            enabled = itemTotal > 0
        ) {
            Text(if (itemTotal > 0) "Proceed to pay" else "Add items to continue")
        }
    }
}
