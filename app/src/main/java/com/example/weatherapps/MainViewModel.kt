package com.example.weatherapps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapps.models.Weather
import com.example.weatherapps.services.WeatherService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private val _weather = MutableStateFlow<Weather?>(null)
    val weather: StateFlow<Weather?> = _weather

    private val _location = MutableStateFlow("Loading...")
    val location: StateFlow<String> = _location

    private val weatherService: WeatherService = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherService::class.java)

    init {
        loadWeather("Halifax")
    }

    fun loadWeather(location: String) {
        viewModelScope.launch {
            try {
                val result = weatherService.getWeather(
                    apiKey = "24dae7e8621c4ecba24183517252305",
                    location = location,
                    days = 7,
                    aqi = "no",
                    alerts = "no"
                )
                _weather.value = result
                _location.value = result.location.name + ", Nova Scotia"
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
