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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun OtpVerificationScreen(navController: NavController) {
    var otp by remember { mutableStateOf("") }
    var isVerifying by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Verify with OTP", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = otp,
            onValueChange = { if (it.length <= 4) otp = it },
            label = { Text("Enter 4-digit OTP") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.width(200.dp),
            enabled = !isVerifying
        )
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = {
                isVerifying = true
                scope.launch {
                    delay(1500)
                    isVerifying = false
                    // Navigate to cart screen after successful verification
                    navController.navigate("cart") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = otp.length == 4 && !isVerifying
        ) {
            if (isVerifying) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(24.dp)
                )
            } else {
                Text("Verify")
            }
        }
    }
}
