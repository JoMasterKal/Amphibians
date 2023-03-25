package com.example.animalsamphibians.data.repository

import com.example.animalsamphibians.data.model.AmphibianModel
import com.example.animalsamphibians.data.network.AmphibianApiService
import com.example.animalsamphibians.domain.repository.AmphibianRepository

class AmphibianRepositoryImpl(
    private val api: AmphibianApiService
):AmphibianRepository {
    override suspend fun getAmphibians(): List<AmphibianModel> {
        return api.getAmphibians()
    }

}