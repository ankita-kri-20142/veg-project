package com.example.minutebazar.ui.otp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minutebazar.R
import com.example.minutebazar.ui.theme.PrimaryGreen

@Composable
fun OtpScreen(
    onBack: () -> Unit = {}
) {
    var otpInputs by remember { mutableStateOf(List(4) { "" }) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top Bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            IconButton(onClick = { onBack() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back), // Provide your back arrow vector asset
                    contentDescription = "Back"
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Enter OTP",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Headings
        Text(
            text = "Verify with OTP",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Text(
            text = "sent via SMS to your phone number",
            fontSize = 13.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 3.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // OTP boxes
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            repeat(4) { idx ->
                Box(
                    modifier = Modifier
                        .size(44.dp, 56.dp)
                        .border(
                            BorderStroke(1.dp, Color(0xFFE0E0E0)),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .background(Color(0xFFF3F3F3), RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = otpInputs[idx],
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Autofill/status area
        Text(
            text = "Trying to auto fill OTP",
            fontSize = 13.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Get OTP on Whatsapp row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp), // Your whatsapp icon resource
                contentDescription = "Whatsapp",
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Get OTP on ",
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                text = "Whatsapp",
                fontSize = 14.sp,
                color = PrimaryGreen,
                fontWeight = FontWeight.Medium,
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Divider(color = Color(0xFFE0E0E0), thickness = 1.dp)

        // Login alternatives and help
        Column(modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(top = 18.dp)) {
            Text(
                text = "Login using Password",
                fontSize = 15.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Having trouble in logging in ? Get help",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
