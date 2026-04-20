package com.ashan.cartnova.ui.screens.intent

import android.annotation.SuppressLint
import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.navigation.ROUTE_HOME

// 🎨 CARTNOVA COLORS
val CoralPink = Color(0xFFE79A94)
val SoftBlue = Color(0xFF9FB7BE)
val PureWhite = Color(0xFFFFFFFF)
val TextDark = Color(0xFF1A1A1A)

@SuppressLint("QueryPermissionsNeeded")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntentScreen(navController: NavController) {

    val context = LocalContext.current
    var selectedIndex by remember { mutableStateOf(1) }

    Scaffold(

        containerColor = Color.Transparent,

        topBar = {
            TopAppBar(
                title = {
                    Text("Intents Hub", color = PureWhite)
                },
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
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0; navController.navigate(ROUTE_HOME) },
                    icon = { Icon(Icons.Default.Person, null) },
                    label = { Text("Home") }
                )

                NavigationBarItem(
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1 },
                    icon = { Icon(Icons.Default.Favorite, null) },
                    label = { Text("Actions") }
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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            IntentCard("Mpesa Payment", Icons.Default.ShoppingCart) {
                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                    ?.let { context.startActivity(it) }
            }

            IntentCard("Call Support", Icons.Default.Phone) {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = "tel:0720245837".toUri()
                context.startActivity(intent)
            }

            IntentCard("Send SMS", Icons.Default.Send) {
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = "smsto:0720245837".toUri()
                intent.putExtra("sms_body", "Hello CartNova!")
                context.startActivity(intent)
            }

            IntentCard("Email Us", Icons.Default.Email) {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("support@cartnova.com"))
                intent.putExtra(Intent.EXTRA_SUBJECT, "CartNova Support")
                intent.putExtra(Intent.EXTRA_TEXT, "Hello, I need help...")
                context.startActivity(intent)
            }

            IntentCard("Share App", Icons.Default.Share) {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "https://github.com/cartnova")
                context.startActivity(Intent.createChooser(intent, "Share"))
            }

            IntentCard("Open Camera", Icons.Default.Face) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (intent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(intent)
                }
            }
        }

    }
}

@Composable
fun IntentCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = PureWhite),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = CoralPink
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = title,
                color = TextDark,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = SoftBlue
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IntentScreenPreview() {
    IntentScreen(rememberNavController())
}