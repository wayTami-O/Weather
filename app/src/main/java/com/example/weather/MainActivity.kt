package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val moskow = findViewById<Button>(R.id.Moscow)
        val samara = findViewById<Button>(R.id.samara)
        val vladivostok = findViewById<Button>(R.id.vladivostok)
        val tolliyatti = findViewById<Button>(R.id.tolyatti)
        val town = findViewById<TextView>(R.id.textView2)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weather.yandex.ru/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(WeatherApi::class.java)

        moskow.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val weather = apiService.getWeather(55.7522, 37.6156)
                val weatherShow = findViewById<TextView>(R.id.textView)
                runOnUiThread {
                    weatherShow.text = weather.fact.temp.toString() + "°"
                    town.text = "Москва"
                }
            }
        }
        vladivostok.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    val weather = apiService.getWeather(43.1056, 131.874)
                    val weatherShow = findViewById<TextView>(R.id.textView)
                    runOnUiThread {
                        weatherShow.text = weather.fact.temp.toString() + "°"
                        town.text = "Владивосток"
                    }
                }
        }
        tolliyatti.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val weather = apiService.getWeather(53.5303, 49.3461)
                val weatherShow = findViewById<TextView>(R.id.textView)
                runOnUiThread {
                    weatherShow.text = weather.fact.temp.toString() + "°"
                    town.text = "Тольятти"
                }
            }
        }
        samara.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val weather = apiService.getWeather(53.2001, 50.15)
                val weatherShow = findViewById<TextView>(R.id.textView)
                runOnUiThread {
                    weatherShow.text = weather.fact.temp.toString() + "°"
                    town.text = "Самара"
                }
            }
        }
    }
}