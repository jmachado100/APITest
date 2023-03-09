package com.example.apitest.Network

import com.example.apitest.Models.Counties
import retrofit2.http.GET

private const val apiLink = "https://api.covid19api.com"

interface Covid19Service {
    @GET("$apiLink/countries")
    suspend fun getCountries(): List<Counties>
}