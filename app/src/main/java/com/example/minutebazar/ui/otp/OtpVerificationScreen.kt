package com.example.minutebazar.ui.otp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider



@Composable
fun OtpVerificationScreen(
    navController: NavController,
    phone: String,
    verificationId: String,
    firebaseAuth: FirebaseAuth
) {
    var otpCode by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf<String?>(null) }

    fun verifyOtp(code: String) {
        isLoading = true
        message = null
        val credential = PhoneAuthProvider.getCredential(verificationId, code)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener { task ->
            isLoading = false
            if (task.isSuccessful) {
                message = "Verified"
                navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            } else {
                message = "Reenter the valid OTP"
            }
        }
    }

    Column(
        Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Verify OTP for $phone", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(24.dp))

        OutlinedTextField(
            value = otpCode,
            onValueChange = { otpCode = it },
            label = { Text("Enter OTP") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                if (otpCode.length == 6) {
                    verifyOtp(otpCode)
                } else {
                    message = "Enter a valid 6 digit OTP"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Verify")
        }

        Spacer(Modifier.height(16.dp))

        message?.let {
            Text(
                it,
                style = MaterialTheme.typography.bodyLarge,
                color = if (it == "Verified")
                    MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
            )
        }

        if (isLoading) {
            Spacer(Modifier.height(16.dp))
            CircularProgressIndicator()
        }
    }
}
