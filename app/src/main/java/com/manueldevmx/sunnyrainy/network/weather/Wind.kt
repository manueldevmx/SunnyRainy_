package com.manueldevmx.sunnyrainy.network.weather

import java.io.Serializable

data class Wind(
    val speed: Float,
    val deg: Int,
): Serializable
