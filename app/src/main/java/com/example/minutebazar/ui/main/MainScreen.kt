package com.example.minutebazar.ui.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    val cartProducts = remember { mutableStateMapOf<Product, Int>() }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var showAccountDialog by remember { mutableStateOf(false) }

    val filteredProducts = vegetables.filter { it.name.contains(searchQuery, true) }
    val cartAmount = cartProducts.entries.sumOf { (product, qty) -> product.price * qty }
    val cartItemCount = cartProducts.values.sum()
    val showProceedBar = cartProducts.isNotEmpty()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            Column {
                if (showProceedBar) {
                    ProceedBar(cartAmount, cartItemCount) {
                        showAccountDialog = true
                    }
                }
                NavigationBar {
                    NavigationBarItem(
                        selected = true,
                        icon = { Icon(Icons.Default.Home, contentDescription = null) },
                        label = { Text("Home") },
                        onClick = {}
                    )
                    NavigationBarItem(
                        selected = false,
                        icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
                        label = { Text("Cart") },
                        onClick = { navController.navigate("cart") }
                    )
                    NavigationBarItem(
                        selected = false,
                        icon = { Icon(Icons.Default.Person, contentDescription = null) },
                        label = { Text("Profile") },
                        onClick = {}
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF6FFF6))
        ) {
            Spacer(Modifier.height(16.dp))
            BasicTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                decorationBox = { innerTextField ->
                    Box(
                        Modifier
                            .padding(horizontal = 16.dp)
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
            Spacer(Modifier.height(12.dp))
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFCC00))
                    .padding(vertical = 12.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "Get 300Rs cashback",
                    color = Color.Black,
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Spacer(Modifier.height(12.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(filteredProducts) { product ->
                    val quantity = cartProducts[product] ?: 0
                    ProductListItem(
                        product = product,
                        quantity = quantity,
                        onAdd = {
                            cartProducts[product] = quantity + 1
                            scope.launch { snackbarHostState.showSnackbar("Added to cart") }
                        },
                        onRemove = {
                            if (quantity > 0) cartProducts[product] = quantity - 1
                            if (cartProducts[product] == 0) cartProducts.remove(product)
                        }
                    )
                }
            }
        }

        if (showAccountDialog) {
            AccountCheckDialog(
                onHaveAccount = {
                    showAccountDialog = false
                    navController.navigate("login")
                },
                onNoAccount = {
                    showAccountDialog = false
                    navController.navigate("register")
                },
                onDismiss = { showAccountDialog = false }
            )
        }
    }
}

@Composable
fun ProceedBar(amount: Int, itemCount: Int, onProceed: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null, tint = Color(0xFF2C2C2C))
        Spacer(Modifier.width(10.dp))
        Text("₹$amount  ·  $itemCount item", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.weight(1f))
        Button(
            onClick = onProceed,
            colors = ButtonDefaults.buttonColors(Color(0xFFFFD600))
        ) {
            Text("Proceed", color = Color.Black, style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
fun AccountCheckDialog(
    onHaveAccount: () -> Unit,
    onNoAccount: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Do you have an account?") },
        confirmButton = {
            TextButton(onClick = onHaveAccount) {
                Text("Yes")
            }
        },
        dismissButton = {
            TextButton(onClick = onNoAccount) {
                Text("No")
            }
        }
    )
}
