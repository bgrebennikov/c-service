package com.example.data.sources.devices

import com.example.data.entity.DeviceEntity

interface DeviceDatasource {


    suspend fun insert(deviceEntity: DeviceEntity) : Long


}