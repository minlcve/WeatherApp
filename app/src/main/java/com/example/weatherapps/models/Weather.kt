package com.example.weatherapps.models

import com.google.gson.annotations.SerializedName

data class Weather(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)

data class Location(
    val name: String
)

data class Current(
    @SerializedName("temp_c") val tempC: Float,
    val condition: Condition
)

data class Condition(
    val text: String,
    val icon: String
)

data class Forecast(
    val forecastday: List<ForecastDay>
)

data class ForecastDay(
    val date: String,
    val day: Day
)

data class Day(
    @SerializedName("maxtemp_c") val maxTempC: Float,
    @SerializedName("mintemp_c") val minTempC: Float,
    @SerializedName("avgtemp_c") val avgTempC: Float,
    @SerializedName("maxwind_kph") val maxWindKph: Float,
    @SerializedName("avghumidity") val avgHumidity: Float,
    @SerializedName("daily_precip_mm") val dailyPrecipMm: Float,
    @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int,
    val condition: Condition
)
