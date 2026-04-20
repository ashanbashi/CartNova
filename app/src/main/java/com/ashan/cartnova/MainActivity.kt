package com.ashan.cartnova

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ashan.cartnova.navigation.AppDrawerScaffold
import com.ashan.cartnova.navigation.AppNavHost
import com.ashan.cartnova.ui.theme.CartNovaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartNovaTheme {
                val navController = rememberNavController()

                AppDrawerScaffold(navController = navController) {
                    AppNavHost(navController = navController)
                }
            }
        }
    }
}



