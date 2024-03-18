package br.com.fiap.saudeplena.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.fiap.saudeplena.ui.theme.Gray50

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabNavigationScreen(navController: NavHostController) {
    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            TabRow(
                selectedTabIndex = currentTab,
                contentColor = Gray50,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
            ) {
                Tab(
                    selected = currentTab == 0,
                    onClick = { navController.navigate("login"); currentTab = 0 },
                    text = { Text(text = "Tab 1") }
                )
                Tab(
                    selected = currentTab == 1,
                    onClick = { navController.navigate("heartbeat"); currentTab = 1 },
                    text = { Text(text = "Tab 2") }
                )
            }
        }
    ) {
        NavHost(navController, startDestination = "login") {
            composable("login") { LoginScreen(navController = navController) }
            composable("heartbeat") { HeartbeatScreen(navController = navController) }
        }
    }
}

private var currentTab: Int by mutableStateOf(0)


@Composable
fun TabContent(content: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = content)
    }
}

@Preview
@Composable
fun PreviewTabContent() {
    TabContent("Tab Content")
}
