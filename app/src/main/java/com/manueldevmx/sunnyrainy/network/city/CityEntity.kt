package com.manueldevmx.sunnyrainy.network.city

import java.io.Serializable

data class CityEntity(
    val name: String,
    val country: String,
) : Serializable
