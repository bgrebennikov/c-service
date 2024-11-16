package com.example.services.devices

import com.example.data.requests.DeviceRequest

interface DeviceService {

    suspend fun insert(device: DeviceRequest) : Long

}