package com.example.weatherapps

import androidx.lifecycle.ViewModel
import com.example.weatherapps.models.Current
import com.example.weatherapps.models.Forecast
import com.example.weatherapps.models.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    // Backing property for weather data using StateFlow
    private val _weather = MutableStateFlow(
        Weather(
            // Current weather data object
            current = Current(
                icon = R.drawable.cloudy,              // Weather icon for current conditions
                condition = "Overcast",                // e.g., "Sunny"
                temperature = "6°C",                   // Current temperature
                precipType = "Feels like 2°C",         // Extra weather info (feels like)
                precipAmount = "Wind SW",              // Wind direction
                windDirection = "18",                  // Wind degree or direction
                windSpeed = "kph"                      // Wind speed
            ),
            // List of forecast data for upcoming days
            forecast = listOf(
                Forecast(
                    date = "May 16",
                    icon = R.drawable.cloudy,           // Icon for this day’s forecast
                    condition = "Cloudy",
                    high = "8°C",
                    low = "3°C",
                    precipType = "Rain",
                    precipAmount = "2 mm",
                    precipProb = "40%",
                    windDirection = "NE",
                    windSpeed = "12 km/h",
                    humidity = "60%"
                ),
                Forecast(
                    date = "May 17",
                    icon = R.drawable.sunny,            // Icon for sunny weather
                    condition = "Sunny",
                    high = "12°C",
                    low = "6°C",
                    precipType = "None",
                    precipAmount = "0 mm",
                    precipProb = "0%",
                    windDirection = "W",
                    windSpeed = "10 km/h",
                    humidity = "45%"
                ),
                Forecast(
                    date = "May 18",
                    icon = R.drawable.storm,            // Icon for stormy weather
                    condition = "Thunderstorms",
                    high = "10°C",
                    low = "5°C",
                    precipType = "Thunderstorm",
                    precipAmount = "5 mm",
                    precipProb = "70%",
                    windDirection = "S",
                    windSpeed = "25 km/h",
                    humidity = "80%"
                )
            )
        )
    )

    val weather: StateFlow<Weather> = _weather
}
