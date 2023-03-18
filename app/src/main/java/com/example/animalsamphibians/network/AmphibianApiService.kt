package com.example.animalsamphibians.network

import com.example.animalsamphibians.model.AmphibianModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<AmphibianModel>

}

object AmphibianApi {
    val retrofitService : AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }
}