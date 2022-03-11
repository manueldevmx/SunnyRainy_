package com.manueldevmx.sunnyrainy.network.weather

import com.manueldevmx.sunnyrainy.network.city.CityEntity
import java.io.Serializable

data class OneCallEntity(
    val current: Current,
    val hourly: List<Current>,
    var city: CityEntity?
): Serializable
