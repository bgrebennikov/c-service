package com.example.data.requests

data class LebedevFormRequest(
    val tag: String?,
    val city: String?,
    val phone: String,
    val description: String?,
    val fromLanding: String?,
    val clientName: String?,
    val clientId: String?,
    val timeUnix: Long?,
    val campaignId: String?
)
