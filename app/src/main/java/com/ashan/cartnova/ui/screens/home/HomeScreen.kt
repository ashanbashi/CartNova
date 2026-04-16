package com.ashan.cartnova.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ashan.cartnova.R
import com.ashan.cartnova.navigation.ROUTE_INTENT
import com.ashan.cartnova.ui.theme.CartNovaTheme

// -------------------- DATA MODELS --------------------

data class Category(
    val name: String,
    val image: Int
)

data class Product(
    val name: String,
    val price: String,
    val image: Int
)

// -------------------- MAIN SCREEN --------------------

@Composable
fun HomeScreen(navController: NavController) {
    HomeScreenContent(
        onProductClick = {
            navController.navigate(ROUTE_INTENT)
        }
    )
}

// -------------------- UI CONTENT --------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(onProductClick: () -> Unit) {

    val categories = listOf(
        Category("Groceries", R.drawable.grocery1),
        Category("Electronics", R.drawable.grocery1),
        Category("Fashion", R.drawable.grocery1),
        Category("Home", R.drawable.grocery1)
    )

    val products = List(10) {
        Product("Product $it", "Ksh ${(it + 1) * 500}", R.drawable.grocery1)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        // 🔹 Top Bar
        item {
            TopAppBar(
                title = { Text("CartNova") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = null)
                    }
                },

                colors = topAppBarColors(
                    containerColor = _root_ide_package_.com.ashan.cartnova.ui.theme.Pink40,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,
                    titleContentColor = Color.White
                )
            )
        }

        // 🔹 Banner
        item {
            Banner()
        }

        // 🔹 Categories
        item {
            SectionTitle("Categories")
            CategoryList(categories)
        }

        // 🔹 Products
        item {
            SectionTitle("Popular Products")
        }

        gridItems(products, onProductClick)

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

// -------------------- BANNER --------------------

@Composable
fun Banner() {
    Image(
        painter = painterResource(R.drawable.grocery1),
        contentDescription = "banner",
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}

// -------------------- SECTION TITLE --------------------

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(16.dp)
    )
}

// -------------------- CATEGORY LIST --------------------

@Composable
fun CategoryList(categories: List<Category>) {

    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 10.dp)
    ) {
        categories.forEach {
            CategoryItem(it)
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}

@Composable
fun CategoryItem(category: Category) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(category.image),
            contentDescription = category.name,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(text = category.name, fontSize = 14.sp)
    }
}

// -------------------- GRID --------------------

fun LazyListScope.gridItems(
    products: List<Product>,
    onClick: () -> Unit
) {
    items(products.chunked(2)) { rowItems ->

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            rowItems.forEach {
                ProductItem(it, onClick)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}

// -------------------- PRODUCT CARD --------------------

@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {

    Column(
        modifier = Modifier
            .width(160.dp)
            .padding(8.dp)
    ) {

        Image(
            painter = painterResource(product.image),
            contentDescription = product.name,
            modifier = Modifier
                .height(140.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(product.name, fontWeight = FontWeight.Bold)

        Text(product.price, color = Color.Gray)

        Spacer(modifier = Modifier.height(6.dp))

        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Buy")
        }
    }
}

// -------------------- PREVIEW --------------------

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    CartNovaTheme {
        HomeScreenContent(onProductClick = {})
    }
}