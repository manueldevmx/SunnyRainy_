package com.manueldevmx.sunnyrainy.mainModule.model.city

import retrofit2.http.GET
import retrofit2.http.Query

interface CityService {
    @GET("geo/1.0/reverse")
    suspend fun getCitiesByLatLng(
        @Query("lat") lat: String,
        @Query("long") lon: String,
        @Query("appid") appid: String
    ): List<CityEntity>
}