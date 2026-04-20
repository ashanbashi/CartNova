package com.ashan.cartnova.ui.screens.about

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.R
import com.ashan.cartnova.navigation.ROUTE_HOME
import com.ashan.cartnova.navigation.ROUTE_LOGIN

// 🎨 COLOR SCHEME (FROM YOUR IMAGE)
val CoralPink = Color(0xFFE79A94)
val SoftBlue = Color(0xFF9FB7BE)
val PureWhite = Color(0xFFFFFFFF)
val TextDark = Color(0xFF1A1A1A)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController){

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(

        // 🌈 Gradient Background
        containerColor = Color.Transparent,

        topBar = {
            TopAppBar(
                title = { Text("CartNova", color = PureWhite) },

                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, null, tint = PureWhite)
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CoralPink
                )
            )
        },

        bottomBar = {
            NavigationBar(containerColor = CoralPink) {

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, null) },
                    label = { Text("Login") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUTE_LOGIN)
                    },
                    colors = navColors()
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("Home") },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUTE_HOME)
                    },
                    colors = navColors()
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, null) },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2 },
                    colors = navColors()
                )
            }
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(CoralPink, SoftBlue)
                    )
                )
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {

            // 🖼 HERO IMAGE
            Image(
                painter = painterResource(R.drawable.obs_1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    "About CartNova",
                    color = PureWhite,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    "Experience modern e-commerce like never before",
                    color = PureWhite
                )

                Spacer(modifier = Modifier.height(20.dp))

                // 🧩 FEATURE CARDS
                FeatureCard(
                    "Smart Shopping",
                    "Browse products easily",
                    R.drawable.product
                )

                FeatureCard(
                    "Fast Delivery",
                    "Quick and reliable delivery",
                    R.drawable.obs_2
                )

                FeatureCard(
                    "Secure Payments",
                    "Your transactions are safe",
                    R.drawable.img_1
                )

                Spacer(modifier = Modifier.height(20.dp))

                // 📞 CONTACT
                InfoCard(
                    "Contact Us",
                    listOf(
                        "support@cartnova.com",
                        "+254 700 000 000",
                        "Nairobi, Kenya"
                    )
                )

                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

// 💎 FEATURE CARD
@Composable
fun FeatureCard(title: String, desc: String, image: Int) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = PureWhite)
    ) {

        Row {

            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(12.dp)) {

                Text(title, color = TextDark, fontWeight = FontWeight.Bold)
                Text(desc, color = TextDark.copy(alpha = 0.7f))
            }
        }
    }
}

// 💎 INFO CARD
@Composable
fun InfoCard(title: String, items: List<String>) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = PureWhite)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(title, color = CoralPink, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(8.dp))

            items.forEach {
                Text("• $it", color = TextDark)
            }
        }
    }
}

// 🎨 NAV COLORS
@Composable
fun navColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = PureWhite,
    selectedTextColor = PureWhite,
    unselectedIconColor = PureWhite.copy(alpha = 0.6f),
    unselectedTextColor = PureWhite.copy(alpha = 0.6f)
)

// 🧪 PREVIEW
@Preview(showBackground = true)
@Composable
fun PreviewAbout(){
    AboutScreen(rememberNavController())
}