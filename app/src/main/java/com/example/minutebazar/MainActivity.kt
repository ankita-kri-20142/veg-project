package com.example.minutebazar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minutebazar.ui.theme.BlackText
import com.example.minutebazar.ui.theme.SplashYellow
import com.example.minutebazar.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainShopScreen()
        }
    }
}

data class Product(
    val imageRes: Int,
    val name: String,
    val price: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainShopScreen() {
    val products = listOf(
        Product(R.drawable.tomato, "Fresh Tomato 1Kg", "Rs30"),
        Product(R.drawable.potato, "Potato 1kg", "Rs40"),
        Product(R.drawable.onion, "Onion 1kg", "Rs35")
    )

    var selectedTab by remember { mutableStateOf(0) }

    Column(
        Modifier
            .fillMaxSize()
            .background(White)
            .padding(10.dp)
    ) {
        // Top row with logo and search bar (simplified)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo_minute_bazar),
                contentDescription = "App Logo",
                modifier = Modifier.size(38.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search for", color = Color.Gray) },
                shape = RoundedCornerShape(28.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    containerColor = Color(0xFFF5F5F5)
                ),
                singleLine = true
            )
        }

        Spacer(Modifier.height(16.dp))

        // Cashback banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .background(SplashYellow),
            contentAlignment = Alignment.Center
        ) {
            Text(
                buildAnnotatedString {
                    append("Get ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("300Rs cashback")
                    }
                },
                fontSize = 18.sp,
                color = BlackText
            )
        }

        Spacer(Modifier.height(16.dp))

        // Featured products list horizontally
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(products) { product ->
                FeaturedProductCard(product)
            }
        }

        Spacer(Modifier.height(16.dp))

        // Product grid placeholders
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(9) {
                Box(
                    modifier = Modifier
                        .aspectRatio(0.75f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFE0E0E0))
                )
            }
        }

        // Bottom navigation
        NavigationBar(
            containerColor = Color(0xFFF5F5F5)
        ) {
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Cart") },
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                selected = selectedTab == 2,
                onClick = { selectedTab = 2 }
            )
        }
    }
}

@Composable
fun FeaturedProductCard(product: Product) {
    Column(
        modifier = Modifier.width(110.dp)
    ) {
        Image(
            painter = painterResource(product.imageRes),
            contentDescription = product.name,
            modifier = Modifier
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = product.name,
            fontSize = 13.sp,
            color = BlackText,
            maxLines = 2
        )
        Text(
            text = product.price,
            fontSize = 13.sp,
            color = BlackText
        )
    }
}
