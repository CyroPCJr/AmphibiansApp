package com.example.amphibiansapp.network

import retrofit2.http.GET
import retrofit2.http.Url

interface AmphibiansApiService {

    @GET("amphibians")
    suspend fun getAmphibians(): List<AmphibiansData>
}