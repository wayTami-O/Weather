package com.example.weather.model

data class Tzinfo(
    val abbr: String,
    val dst: Boolean,
    val name: String,
    val offset: Int
)