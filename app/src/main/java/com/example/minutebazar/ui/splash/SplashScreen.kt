package com.example.minutebazar.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.minutebazar.R
import kotlinx.coroutines.delay
import androidx.compose.material3.MaterialTheme

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(1500)
        navController.navigate("main") { popUpTo("splash") { inclusive = true } }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.minutebazarlogo), // Place your logo in drawable as ic_logo
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text("Minute Bazar", style = MaterialTheme.typography.displayLarge, color = Color.White)
            Text("Delivery in 10 Minutes", style = MaterialTheme.typography.bodyMedium, color = Color.White)
        }
    }
}
