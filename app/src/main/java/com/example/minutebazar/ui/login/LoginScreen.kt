package com.example.minutebazar.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.text.input.PasswordVisualTransformation


@Composable
fun LoginScreen(navController: NavController) {
    var loginByPhone by remember { mutableStateOf(true) }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))

        Text(
            "Great deals on your first purchase",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.height(16.dp))

        // Toggle group for login type
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { loginByPhone = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (loginByPhone) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                )
            ) {
                Text("Phone")
            }
            Spacer(Modifier.width(16.dp))
            Button(
                onClick = { loginByPhone = false },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (!loginByPhone) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                )
            ) {
                Text("Email")
            }
        }
        Spacer(Modifier.height(16.dp))

        if (loginByPhone) {
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Enter your phone number") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Enter your email") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter your password") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
        }

        Spacer(Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = true, onCheckedChange = {})
            Text("By continuing, you agree to Minute Bazar's privacy and policy")
        }
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("otp") },
            modifier = Modifier.fillMaxWidth(),
            enabled = if (loginByPhone) phone.isNotBlank() else email.isNotBlank() && password.isNotBlank()
        ) {
            Text("Login using OTP")
        }
    }
}
