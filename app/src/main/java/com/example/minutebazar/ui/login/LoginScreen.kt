package com.example.minutebazar.ui.login


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    var phone by remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))
        Text("Great deals on your first purchase", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Enter your phone number") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = true, onCheckedChange = {})
            Text("By continuing, you agree to Minute Bazar's privacy and policy")
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = { navController.navigate("otp") }, modifier = Modifier.fillMaxWidth()) {
            Text("Login using OTP")
        }
    }
}
