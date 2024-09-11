package com.example.amphibiansapp.network

import retrofit2.http.GET

interface AmphibiansApiService {

    @GET
    suspend fun getAmphibians(): List<AmphibiansData>
}