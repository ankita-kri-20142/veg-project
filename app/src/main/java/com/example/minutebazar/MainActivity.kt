package com.example.minutebazar.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minutebazar.ui.cart.CartScreen
import com.example.minutebazar.ui.login.LoginScreen
import com.example.minutebazar.ui.main.MainScreen
import com.example.minutebazar.ui.otp.OtpVerificationScreen
import com.example.minutebazar.ui.register.RegisterScreen
import com.example.minutebazar.ui.splash.SplashScreen
import com.example.minutebazar.ui.theme.MinuteBazarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinuteBazarTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "splash"
                    ) {
                        // Splash Screen composable (single instance)
                        composable("splash") {
                            SplashScreen(navController)
                        }
                        // Main Screen composable
                        composable("main") {
                            MainScreen(navController)
                        }
                        // Cart Screen composable
                        composable("cart") {
                            CartScreen(navController)
                        }
                        // Login Screen composable
                        composable("login") {
                            LoginScreen(navController)
                        }
                        // Register Screen composable
                        composable("register") {
                            RegisterScreen(navController)
                        }
                        // OTP Verification composable
                        composable("otp") {
                            OtpVerificationScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
