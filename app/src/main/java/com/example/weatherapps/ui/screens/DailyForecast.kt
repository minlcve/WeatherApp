package com.example.weatherapps.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapps.MainViewModel
import androidx.compose.ui.text.font.FontWeight

@Composable
fun DailyForecast(mainViewModel: MainViewModel) {
    val weather = mainViewModel.weather.collectAsState().value
    val forecastList = weather?.forecast?.forecastday
    val location = weather?.location?.name

    Column(modifier = Modifier.padding(16.dp)) {
        if (location != null) {
            Text(text = "$location, Nova Scotia", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Text(text = "Daily Forecast", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))

        if (forecastList != null) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(forecastList) { day ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter("https:${day.day.condition.icon}"),
                                contentDescription = day.day.condition.text,
                                modifier = Modifier
                                    .size(64.dp)
                                    .padding(end = 16.dp)
                            )

                            Column {
                                Text(text = day.date, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                                Text(text = day.day.condition.text, fontSize = 14.sp)
                                Text(text = "High: ${day.day.maxTempC}°C, Low: ${day.day.minTempC}°C", fontSize = 14.sp)
                                Text(text = "Precip: ${day.day.dailyPrecipMm} mm (${day.day.dailyChanceOfRain}%)", fontSize = 14.sp)
                                Text(text = "Wind: ${day.day.maxWindKph} km/h", fontSize = 14.sp)
                                Text(text = "Humidity: ${day.day.avgHumidity}%", fontSize = 14.sp)
                            }
                        }
                    }
                }
            }
        } else {
            Text(text = "Loading forecast...")
        }
    }
}
