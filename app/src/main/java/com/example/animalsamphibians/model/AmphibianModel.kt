package com.example.animalsamphibians.model

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