package com.example.weatherapps.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapps.MainViewModel

@Composable
fun CurrentWeather(mainViewModel: MainViewModel) {
    val current = mainViewModel.weather.collectAsState().value?.current
    val location = mainViewModel.weather.collectAsState().value?.location

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (current != null && location != null) {
            Text(text = "${location.name}, Nova Scotia", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Image(
                painter = rememberAsyncImagePainter("https:${current.condition.icon}"),
                contentDescription = current.condition.text,
                modifier = Modifier.size(96.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Temperature: ${current.tempC}°C", fontSize = 24.sp)
            Text(text = "Condition: ${current.condition.text}", fontSize = 18.sp)
        } else {
            Text(text = "Loading...", fontSize = 20.sp)
        }
    }
}
