package com.example.amphibiansapp.data

import com.example.amphibiansapp.network.AmphibiansApiService
import com.example.amphibiansapp.network.AmphibiansData

interface AmphibiansRepository {

    suspend fun getAmphibians(): List<AmphibiansData>

}

class NetworkAmphibiansRepository(private val amphibiansApi: AmphibiansApiService) :
    AmphibiansRepository {

    override suspend fun getAmphibians(): List<AmphibiansData> = amphibiansApi.getAmphibians()

}