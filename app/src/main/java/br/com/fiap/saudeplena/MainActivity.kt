package br.com.fiap.saudeplena

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import br.com.fiap.saudeplena.screens.TabNavigationScreen
import br.com.fiap.saudeplena.ui.theme.SaudePlenaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaudePlenaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF070D1C)
                ) {
                    val navController = rememberNavController()
                    TabNavigationScreen(navController);
                }
            }
        }
    }
}