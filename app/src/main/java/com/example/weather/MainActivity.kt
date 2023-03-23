package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weather.yandex.ru/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(WeatherApi::class.java)
        val weather = apiService.getWeather(53.530927, 49.429897)
        val weatherShow = findViewById<TextView>(R.id.textView)
        weatherShow.text = weather.factTemp.temp.toString()
    }
}