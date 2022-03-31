package com.manueldevmx.sunnyrainy.mainModule.model.weather

import com.manueldevmx.sunnyrainy.mainModule.model.city.CityEntity
import java.io.Serializable

data class OneCallEntity(
    val current: Current,
    val hourly: List<Current>,
    var city: CityEntity?
): Serializable
