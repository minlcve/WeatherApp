package com.example.weatherapps.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.weatherapps.MainViewModel

@Composable
fun DailyForecastScreen(mainViewModel: MainViewModel) {
    // collect the forecast list from the Viewmodel
    val forecast = mainViewModel.weather.collectAsState().value.forecast

    // main colum layout that can scroll vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // the screen title
        Text(
            text = "Daily Forecast",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // loop through each forecast day
        forecast.forEach { day ->
            Spacer(modifier = Modifier.height(16.dp))

            Card(
                // card for each forecast entry
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    // weather icons. i gave it rounded corners
                    Image(
                        painter = painterResource(id = day.icon),
                        contentDescription = "Forecast Icon",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(text = day.date, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Text(text = day.condition)
                        Text(text = "High: ${day.high}, Low: ${day.low}")
                        Text(text = "Precip: ${day.precipType} ${day.precipAmount} (${day.precipProb})")
                        Text(text = "Wind: ${day.windDirection} ${day.windSpeed}")
                        Text(text = "Humidity: ${day.humidity}")
                    }
                }
            }
        }
    }
}
