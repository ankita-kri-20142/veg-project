package com.example.minutebazar.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minutebazar.ui.main.Product


@Composable
fun ProductListItem(
    product: Product,
    quantity: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Discount Label
        if (product.discountPercent > 0) {
            Box(
                modifier = Modifier
                    .align(Alignment.Start)
                    .background(Color.Red, RoundedCornerShape(4.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            ) {
                Text(
                    text = "${product.discountPercent}% OFF",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(Modifier.height(4.dp))
        }

        // Product Image
        Icon(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            tint = Color.Unspecified,
            modifier = Modifier
                .size(70.dp)
                .padding(top = 6.dp)
        )

        Spacer(Modifier.height(8.dp))

        // Product Name
        Text(
            text = product.name,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            maxLines = 2
        )

        Spacer(Modifier.height(4.dp))

        // Price Section
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "₹${product.price}",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.width(4.dp))
            Text(
                text = "₹${product.originalPrice}",
                color = Color.Gray,
                fontSize = 12.sp,
                style = LocalTextStyle.current.copy(textDecoration = TextDecoration.LineThrough)
            )
        }

        Spacer(Modifier.height(6.dp))

        // Add / Remove Buttons
        if (quantity == 0) {
            IconButton(
                onClick = onAdd,
                modifier = Modifier
                    .size(36.dp)
                    .background(Color(0xFFFFD600), RoundedCornerShape(50))
            ) {
                Text("+", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color(0xFFFFF176), RoundedCornerShape(20.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    "-",
                    modifier = Modifier.clickable { onRemove() }.padding(horizontal = 6.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text("$quantity", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(
                    "+",
                    modifier = Modifier.clickable { onAdd() }.padding(horizontal = 6.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}
