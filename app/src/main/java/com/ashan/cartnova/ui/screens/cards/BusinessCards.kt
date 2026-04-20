package com.ashan.cartnova.ui.screens.cards

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.ui.theme.Pink40

// 🎨 NEW THEME (MATCHES HOME + ABOUT)
val CoralPink = Color(0xFFE79A94)
val SoftBlue = Color(0xFF9FB7BE)
val PureWhite = Color(0xFFFFFFFF)
val TextDark = Color(0xFF1A1A1A)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusinessCards(navController: NavController) {

    Scaffold(
        containerColor = Color.Transparent,

        topBar = {
            TopAppBar(
                title = {
                    Text("Business Cards", color = PureWhite)
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, null, tint = PureWhite)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CoralPink
                )
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = CoralPink
            ) {
                Icon(Icons.Default.Add, contentDescription = null, tint = PureWhite)
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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            BusinessCard("John Doe", "Android Developer", "+254 712 345 678", "john@example.com")
            BusinessCard("Mary Wanjiku", "UI/UX Designer", "+254 723 456 789", "mary@example.com")
            BusinessCard("David Otieno", "Software Engineer", "+254 734 567 890", "david@example.com")
        }
    }
}

// 💎 MODERN BUSINESS CARD
@Composable
fun BusinessCard(
    name: String,
    role: String,
    phone: String,
    email: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = PureWhite),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                name,
                color = TextDark,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                role,
                color = TextDark.copy(alpha = 0.6f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("📞 $phone", color = TextDark)
            Text("✉ $email", color = TextDark)
        }
    }
}

// 🧪 PREVIEW
@Preview(showBackground = true)
@Composable
fun BusinessCardsPreview() {
    BusinessCards(rememberNavController())
}