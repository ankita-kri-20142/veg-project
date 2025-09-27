import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.minutebazar.ui.cart.CartScreen
import com.example.minutebazar.ui.login.LoginScreen
import com.example.minutebazar.ui.main.MainScreen
import com.example.minutebazar.ui.main.MinuteBazarProfileScreen
import com.example.minutebazar.ui.main.Product
import com.example.minutebazar.ui.otp.OtpVerificationScreen
import com.example.minutebazar.ui.register.RegistrationScreen
import com.example.minutebazar.ui.splash.SplashScreen
import com.example.minutebazar.ui.theme.MinuteBazarTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            FirebaseApp.initializeApp(this)
            firebaseAuth = FirebaseAuth.getInstance()
            Log.d("MainActivity", "Firebase initialized successfully")
        } catch (e: Exception) {
            Log.e("MainActivity", "Firebase initialization failed", e)
        }

        setContent {
            MinuteBazarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val cartProducts = remember { mutableStateMapOf<Product, Int>() }

                    // Temporary minimal UI to test visibility — replace with NavHost when ready
                    // Text("App Loaded Successfully")

                    NavHost(
                        navController = navController,
                        startDestination = "splash"
                    ) {
                        composable("splash") {
                            SplashScreen(navController)
                        }
                        composable("main") {
                            MainScreen(navController, cartProducts)
                        }
                        composable("cart") {
                            CartScreen(navController, cartProducts)
                        }
                        composable("login") {
                            LoginScreen(navController, firebaseAuth)
                        }
                        composable("register") {
                            RegistrationScreen(navController, firebaseAuth)
                        }
                        composable(
                            "otp_screen/{phone}/{verificationId}",
                            arguments = listOf(
                                navArgument("phone") { type = NavType.StringType },
                                navArgument("verificationId") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val phone = backStackEntry.arguments?.getString("phone") ?: ""
                            val verificationId = backStackEntry.arguments?.getString("verificationId") ?: ""
                            OtpVerificationScreen(navController, phone, verificationId, firebaseAuth)
                        }
                        composable("profile") {
                            MinuteBazarProfileScreen(navController)
                        }
                        composable("home") {
                            MainScreen(navController, cartProducts)
                        }
                    }
                }
            }
        }
    }
}
