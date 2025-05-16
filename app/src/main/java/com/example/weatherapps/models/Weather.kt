package com.example.weatherapps.models

// main weather data that includes current conditions and list of daily forecasts
data class Weather(
    val current: Current, // current weather info
    val forecast: List<Forecast> // list of the forecasts for upcoming days
)

// holds current weather details
data class Current(
    val icon: Int,
    val condition: String,
    val temperature: String,
    val precipType: String,
    val precipAmount: String,
    val windDirection: String,
    val windSpeed: String
)
// represents one day's forecast
data class Forecast(
    val date: String,
    val icon: Int,
    val condition: String,
    val high: String,
    val low: String,
    val precipType: String,
    val precipAmount: String,
    val precipProb: String,
    val windDirection: String,
    val windSpeed: String,
    val humidity: String
)
