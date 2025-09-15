package com.example.minutebazar.ui.otp


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun OtpVerificationScreen(navController: NavController) {
    var otp by remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))
        Text("Verify with OTP", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = otp,
            onValueChange = { if (it.length <= 4) otp = it },
            label = { Text("Enter 4-digit OTP") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.width(200.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text("Get OTP via WhatsApp", color = MaterialTheme.colorScheme.primary)
        Spacer(Modifier.height(24.dp))
        Button(onClick = { /* Verify OTP here */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Verify")
        }
    }
}
