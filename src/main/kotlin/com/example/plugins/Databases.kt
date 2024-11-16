package com.example.plugins

import com.example.database.DatabaseFactory
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureDatabases() {
    val database: DatabaseFactory by inject()
    database.init(this)
}
