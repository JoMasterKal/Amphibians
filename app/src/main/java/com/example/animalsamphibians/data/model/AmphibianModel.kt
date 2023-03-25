package com.example.animalsamphibians.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AmphibianModel (
    val name: String,

    val type: String,

    val description: String,

    @SerialName(value = "img_src")
    val imgSrc: String
    )