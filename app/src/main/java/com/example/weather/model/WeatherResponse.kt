package com.example.weather.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("fact")
    @Expose
    val factTemp: Temp
)
