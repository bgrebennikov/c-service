package com.example.data.schemas

import org.jetbrains.exposed.sql.Table


object DeviceSchema : Table("devices") {

    val id = long("id").autoIncrement()

    val title = varchar("title", length = 256)
    val model_name = varchar("model_name", length = 256)
    val price = varchar("price", length = 256)
    val image_original = varchar("image_original", length = 512)
    val url_path = varchar("url_path", length = 512)

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(id)

}