package com.example.DI.modules

import com.example.data.sources.devices.DeviceDatasource
import com.example.data.sources.devices.DeviceDatasourceImpl
import com.example.services.devices.DeviceService
import com.example.services.devices.DeviceServiceImpl
import org.koin.dsl.module

val devicesModule = module {
    single<DeviceDatasource> {
        DeviceDatasourceImpl()
    }

    single<DeviceService> {
        DeviceServiceImpl()
    }
}