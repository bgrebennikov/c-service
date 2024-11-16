package com.example.services.devices

import com.example.data.entity.DeviceEntity
import com.example.data.requests.DeviceRequest
import com.example.data.sources.devices.DeviceDatasource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DeviceServiceImpl : DeviceService, KoinComponent {

    private val devicesDataSource : DeviceDatasource by inject()

    override suspend fun insert(device: DeviceRequest): Long {
        return devicesDataSource.insert(
            DeviceEntity(
                device.title,
                device.model_name,
                device.price,
                device.image_original,
                device.url_path
            )
        )
    }
}