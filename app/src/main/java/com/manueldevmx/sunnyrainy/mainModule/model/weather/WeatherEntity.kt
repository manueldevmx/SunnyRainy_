package com.manueldevmx.sunnyrainy.mainModule.model.weather

import java.io.Serializable


data class WeatherEntity (
    val base: String,
    val main: Main,
    val sys: Sys,
    val id: Int,
    val name: String,
    val wind: Wind,
    val weather: List<Weather>,
    val dt: Long,
): Serializable