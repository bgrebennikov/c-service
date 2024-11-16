package com.example.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class DeviceEntity(
    val title: String,
    val model_name: String,
    val price: String,
    val image_original: String,
    val url_path: String
)
