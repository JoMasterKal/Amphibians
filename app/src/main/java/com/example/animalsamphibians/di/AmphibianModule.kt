package com.example.animalsamphibians.di

import com.example.animalsamphibians.data.network.AmphibianApiService
import com.example.animalsamphibians.data.repository.AmphibianRepositoryImpl
import com.example.animalsamphibians.domain.repository.AmphibianRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AmphibianModule {

    @Singleton
    @Provides
    fun provideAmphibianApi(): AmphibianApiService {
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com")
            .build()
            .create(AmphibianApiService::class.java)
    }


    @Singleton
    @Provides
     fun provideAmphibianRepository(api: AmphibianApiService):AmphibianRepository{
         return  AmphibianRepositoryImpl(api)
     }

}