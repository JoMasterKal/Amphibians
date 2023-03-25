package com.example.animalsamphibians.domain.repository

import com.example.animalsamphibians.data.model.AmphibianModel

interface AmphibianRepository {
    suspend fun getAmphibians(): List<AmphibianModel>
}