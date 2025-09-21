package com.example.minutebazar.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateMapOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minutebazar.ui.cart.CartScreen
import com.example.minutebazar.ui.login.LoginScreen
import com.example.minutebazar.ui.main.MainScreen
import com.example.minutebazar.ui.main.MinuteBazarProfileScreen
import com.example.minutebazar.ui.otp.OtpVerificationScreen
import com.example.minutebazar.ui.register.RegisterScreen
import com.example.minutebazar.ui.splash.SplashScreen
import com.example.minutebazar.ui.theme.MinuteBazarTheme
import com.example.minutebazar.ui.main.Product

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinuteBazarTheme {
                Surface {
                    val navController = rememberNavController()
                    // Shared cart state for MainScreen and CartScreen
                    val cartProducts = remember { mutableStateMapOf<Product, Int>() }

                    NavHost(
                        navController = navController,
                        startDestination = "splash"
                    ) {
                        composable("splash") {
                            SplashScreen(navController)
                        }
                        composable("main") {
                            MainScreen(navController, cartProducts)  // Pass cartProducts here
                        }
                        composable("cart") {
                            CartScreen(navController, cartProducts)  // Pass cartProducts here
                        }
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("register") {
                            RegisterScreen(navController)
                        }
                        composable("otp") {
                            OtpVerificationScreen(navController)
                        }
                        composable("profile") {
                            MinuteBazarProfileScreen(navController)
                        }

                    }
                }
            }
        }
    }
}

