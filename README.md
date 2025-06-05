# WeatherApp ☀️🌧️

An Android weather app built with Kotlin and Jetpack Compose.

## Features

- Displays current weather and daily forecast
- Uses a clean, scrollable UI with cards and styling
- Fetches live weather data using the [WeatherAPI.com](https://www.weatherapi.com/) web API
- Gets the device's current location to show local weather
- Shows a loading spinner while fetching data

## Tech Used

- Kotlin + Jetpack Compose
- Retrofit for API calls
- Google Play Services for location
- Accompanist for permissions

## Assignment Info

- Assignment 1: Basic weather UI, mock data
- Assignment 2: Connected to live API and device location

## Setup

1. Clone this repo:
2. Open in Android Studio.
3. Add your WeatherAPI key in `WeatherService.kt`:
```kotlin
const val API_KEY = "your_api_key_here"


### Current Weather Screen  
Now uses live weather data from WeatherAPI.com and the user's device location.

![Current Weather](https://github.com/minlcve/WeatherApp/blob/main/app/src/main/java/com/example/weatherapps/screenshots/current.png?raw=true)

### Daily Forecast Screen  
Shows a 3-day scrollable forecast using live data, weather icons, and extra info like wind and humidity.

![Daily Forecast](https://github.com/minlcve/WeatherApp/blob/main/app/src/main/java/com/example/weatherapps/screenshots/daily%20part%202.png?raw=true)

---

## Image Credits

- Cloud icon from [flaticon.com](https://www.flaticon.com/)
- Sunny icon from [flaticon.com](https://www.flaticon.com/)
- Storm icon from [flaticon.com](https://www.flaticon.com/)



## Assignment

This project was created for:
> **MOBI3002 – Android Development 2**  
> NSCC Spring 2025 – Assignment 2

---

