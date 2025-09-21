import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.minutebazar.ui.main.Product
import androidx.compose.foundation.layout.size


@Composable
fun ProductImage(product: Product) {
    Image(
        painter = painterResource(id = product.imageRes),
        contentDescription = product.name,
        modifier = Modifier.size(60.dp)
    )
}
