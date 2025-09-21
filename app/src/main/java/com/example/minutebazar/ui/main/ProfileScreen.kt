package com.example.minutebazar.ui.main


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MinuteBazarProfileScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            // Header profile area with cash
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.AccountCircle, contentDescription = null, modifier = Modifier.size(48.dp), tint = Color(0xFF7B7B7B))
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Ankita kumari", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text("75428 32211", color = Color.Gray, fontSize = 14.sp)
                }
                Spacer(Modifier.weight(1f))
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFFF4E7FD)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                        Icon(Icons.Default.CardGiftcard, contentDescription = null, tint = Color(0xFFBC59F4), modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(5.dp))
                        Text("Free Cash", color = Color(0xFFBC59F4), fontWeight = FontWeight.Medium, fontSize = 13.sp)
                        Spacer(Modifier.width(5.dp))
                        Text("₹50", color = Color(0xFFBC59F4), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                }
            }
            // Row with orders, help, wishlist
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ProfileActionButton(icon = Icons.Default.Receipt, label = "Your Orders")
                ProfileActionButton(icon = Icons.Default.Help, label = "Help & Support")
                ProfileActionButton(icon = Icons.Default.FavoriteBorder, label = "Your Wishlist")
            }
            Spacer(Modifier.height(16.dp))
            // Card for saved amount
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF205226))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
                    Icon(Icons.Default.MonetizationOn, contentDescription = null, tint = Color.Yellow)
                    Spacer(Modifier.width(10.dp))
                    Column {
                        Text("You've saved ₹87 so far with Zepto Daily", color = Color.White)
                        Text("Renew daily", color = Color.Yellow, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            // Zepto Cash & Gift Card section
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF4E7FD))
            ) {
                Row(
                    Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.AccountBalanceWallet, contentDescription = null, tint = Color(0xFFBC59F4))
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically){
                                Text("Zepto Cash & Gift Card", fontWeight = FontWeight.Bold, color = Color(0xFFBC59F4), fontSize = 15.sp)
                                Spacer(Modifier.width(8.dp))
                                Surface(
                                    color = Color(0xFFD2F6DC), shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text("NEW",modifier=Modifier.padding(horizontal = 4.dp, vertical = 1.dp), color = Color(0xFF27AE5F), fontSize = 10.sp)
                                }
                            }
                            Text("Available Balance ₹0", color = Color.Gray, fontSize = 14.sp)
                        }
                    }
                    Button(onClick = { }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBC59F4))) {
                        Text("Add Balance", color = Color.White, fontSize = 14.sp)
                    }
                }
            }

            // All Settings section
            Spacer(Modifier.height(18.dp))
            Text(
                text = "Your Information",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
            )
            Divider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
            ProfileListItem("Your Orders", Icons.Default.Receipt)
            ProfileListItem("Your Wishlist", Icons.Default.FavoriteBorder)
            ProfileListItem("E-Gift Cards", Icons.Default.CardGiftcard)
            ProfileListItem("Help & Support", Icons.Default.Help)
            ProfileListItem("Refunds", Icons.Default.AttachMoney)
            ProfileListItem("Saved Addresses", Icons.Default.LocationOn, trailingText = "1 Addresses")
            ProfileListItem("Profile", Icons.Default.AccountCircle)
            ProfileListItem("Rewards", Icons.Default.Redeem)
            ProfileListItem("Payment Management", Icons.Default.AccountBalanceWallet)
            Spacer(Modifier.height(20.dp))
            // Other Info Section
            Text(
                "Other Information",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
            )
            Divider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
            ProfileListItem("Suggest Products", Icons.Default.StarBorder)
            ProfileListItem("Notifications", Icons.Default.NotificationsNone)
            ProfileListItem("General Info", Icons.Default.Info)
            // Log out
            Spacer(Modifier.height(24.dp))
            Button(
                onClick = { /* Log out logic here */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEB5757))
            ) {
                Text("Log Out", color = Color.White)
            }
            Spacer(Modifier.height(10.dp))
            Text(
                "App version 25.9.1\nv84-24",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp),
                color = Color.Gray,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun ProfileActionButton(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(32.dp), tint = Color(0xFF389348))
        Spacer(Modifier.height(3.dp))
        Text(label, fontSize = 13.sp, color = Color(0xFF1C1C1C))
    }
}

@Composable
fun ProfileListItem(label: String, icon: ImageVector, trailingText: String? = null) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 22.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = Color(0xFF3E3E3E), modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(label, Modifier.weight(1f), fontSize = 16.sp, color = Color(0xFF1C1C1C))
        if (trailingText != null) {
            Text(trailingText, color = Color.Gray, fontSize = 15.sp)
        }
        Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.Gray)
    }
}
