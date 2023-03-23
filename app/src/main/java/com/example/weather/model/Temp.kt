package com.example.weather.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Temp(
    @SerializedName("temp")
    @Expose
    val temp: Number
)
