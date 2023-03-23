package com.example.weather

import com.example.weather.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast?")
    @Headers("X-Yandex-API-Key: 387b0b5e-b403-4b1e-bd00-77f6daf162f2")
    fun getWeather(@Query("lat") lat: Double, @Query("lon") lon: Double): WeatherResponse
}