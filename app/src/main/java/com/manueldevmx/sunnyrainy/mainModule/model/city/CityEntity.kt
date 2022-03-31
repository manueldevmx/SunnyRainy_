package com.manueldevmx.sunnyrainy.mainModule.model.city

import java.io.Serializable

data class CityEntity(
    val name: String,
    val country: String,
) : Serializable
