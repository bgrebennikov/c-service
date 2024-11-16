package com.example.database

import com.example.common.ext.getEnv
import com.example.data.schemas.DeviceSchema
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    fun init(application: Application){
        Database.connect(hikari(application))

        transaction {
            SchemaUtils.create(DeviceSchema)
            SchemaUtils.createMissingTablesAndColumns(DeviceSchema)
        }

    }


    private fun hikari(app: Application) : HikariDataSource {
        val config = HikariConfig()

        config.driverClassName = app.getEnv("database.driver")
        config.jdbcUrl = app.getEnv("database.url")
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.username = app.getEnv("database.user")
        config.password = app.getEnv("database.password")
        config.validate()

        return HikariDataSource(config)
    }

}