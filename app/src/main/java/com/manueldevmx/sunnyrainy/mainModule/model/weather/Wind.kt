package com.manueldevmx.sunnyrainy.mainModule.model.weather

import java.io.Serializable

data class Wind(
    val speed: Float,
    val deg: Int,
): Serializable
