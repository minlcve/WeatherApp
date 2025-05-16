package com.example.weatherapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapps.ui.screens.CurrentWeatherScreen
import com.example.weatherapps.ui.screens.DailyForecastScreen
import com.example.weatherapps.ui.theme.WeatherAppsTheme

class MainActivity : ComponentActivity() {

    // Create the ViewModel instance for accessing weather data
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppsTheme {
                DisplayUI(mainViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayUI(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    var selectedItem by remember { mutableIntStateOf(0) } // ✅ modern recommended state for primitives

    Scaffold(
        // Top app bar with location title
        topBar = {
            TopAppBar(
                title = { Text("Halifax, Nova Scotia") }
            )
        },
        // Bottom navigation bar with "Now" and "Daily" tabs
        bottomBar = {
            NavigationBar {
                // Now Tab
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.WbSunny, contentDescription = "Now") },
                    label = { Text("Now") },
                    selected = selectedItem == 0,
                    onClick = {
                        selectedItem = 0
                        navController.navigate("current") {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                // Daily Forecast Tab
                NavigationBarItem(
                    icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Daily") },
                    label = { Text("Daily") },
                    selected = selectedItem == 1,
                    onClick = {
                        selectedItem = 1
                        navController.navigate("daily") {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        // Set up the screen navigation between current and daily forecast
        NavHost(
            navController = navController,
            startDestination = "current",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("current") {
                CurrentWeatherScreen(mainViewModel)
            }
            composable("daily") {
                DailyForecastScreen(mainViewModel)
            }
        }
    }
}
