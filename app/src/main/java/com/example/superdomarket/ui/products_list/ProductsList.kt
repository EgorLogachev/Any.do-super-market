package com.example.superdomarket.ui.products_list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.superdomarket.data.Product

//{"bagColor": "#64BD4F", "name": "Onion", "weight": "1.8kg"}	1672139796.9766734

@Composable
fun ProductsList(
    products: List<Product>,
    viewModel: ProductsViewModel = hiltViewModel(),
    onIconClick: (Color) -> Unit,
) {

    val uiState by viewModel.state.collectAsState()

    LazyColumn {
        items(products) { item: Product ->
            ProductItem(item, onIconClick)
        }
    }
}

@Composable
private fun ProductItem(
    product: Product,
    onIconClick: (Color) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8f.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(color = product.color)
                .border(1.dp, Color(red = 136, green = 136, blue = 136), shape = CircleShape)
                .clickable {
                    //todo add animation here
                    onIconClick.invoke(product.color)
                }
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    Color(red = 221, green = 221, blue = 221),
                    shape = RoundedCornerShape(3.dp)
                )
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(red = 245, green = 245, blue = 245)
            ) {
                Text(text = product.name, modifier = Modifier.padding(all = 8.dp))
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(color = Color(red = 221, green = 221, blue = 221))
            )
            Text(text = product.weight, modifier = Modifier.padding(all = 8.dp))
        }
    }


}


fun Color.fromHex(color: String) = Color(android.graphics.Color.parseColor(color))