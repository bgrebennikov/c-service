package com.example.data.sources.devices

import com.example.common.ext.dbQuery
import com.example.data.entity.DeviceEntity
import com.example.data.schemas.DeviceSchema
import org.jetbrains.exposed.sql.insert

class DeviceDatasourceImpl : DeviceDatasource {

    private val devices = DeviceSchema

    override suspend fun insert(deviceEntity: DeviceEntity): Long {
        return dbQuery {
            devices.insert {
                it[title] = deviceEntity.title
                it[model_name] = deviceEntity.model_name
                it[price] = deviceEntity.price
                it[image_original] = deviceEntity.image_original
                it[url_path] = deviceEntity.url_path
            }
        }[DeviceSchema.id]
    }
}