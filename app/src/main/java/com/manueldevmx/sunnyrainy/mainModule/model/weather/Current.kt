package com.manueldevmx.sunnyrainy.mainModule.model.weather

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Current(
    val dt: Long,
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("wind_speed")
    val wind: Double,
    val pressure: Int,
    val humidity: Int,
    val weather: List<Weather>
): Serializable
