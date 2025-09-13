package com.example.minutebazar.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.minutebazar.R
import com.example.minutebazar.ui.theme.MinuteBazarTheme
import com.example.minutebazar.ui.theme.PrimaryGreen
import com.example.minutebazar.ui.theme.Typography
import com.example.minutebazar.ui.theme.White

@Composable
fun SplashScreen() {
    MinuteBazarTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(PrimaryGreen),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Logo should be vector or transparent PNG from your assets
                Image(
                    painter = painterResource(id = R.drawable.logo_minute_bazar),
                    contentDescription = "Minute Bazar Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(140.dp)
                        .padding(bottom = 18.dp)
                )
                Text(
                    text = "Minute Bazar",
                    style = Typography.displayLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = White
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Delivery in 10 Minutes",
                    style = Typography.bodyLarge.copy(
                        fontWeight = FontWeight.Normal,
                        color = White
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
