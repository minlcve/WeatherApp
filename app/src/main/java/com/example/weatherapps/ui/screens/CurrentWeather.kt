package com.example.weatherapps.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapps.MainViewModel

@Composable
fun CurrentWeatherScreen(mainViewModel: MainViewModel) {
    // collect the current weather data from the Viewmodel
    val current = mainViewModel.weather.collectAsState().value.current

    // Main colum layout, has scrolling and padding enabled
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        // shows the weather icons i have chosen
        Image(
            painter = painterResource(id = current.icon),
            contentDescription = "Current Weather Icon",
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        //shows current condition
        Text(text = current.condition, fontSize = 24.sp)
        // shows current temperature
        Text(text = current.temperature, fontSize = 22.sp)
        // show precipitation info
        Text(text = "${current.precipType} ${current.precipAmount}", fontSize = 18.sp)
        // show wind details
        Text(text = "Wind: ${current.windDirection} ${current.windSpeed}", fontSize = 18.sp)
    }
}
