package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import com.example.services.telegram.BotService

fun main(args: Array<String>): Unit =
    io.ktor.server.cio.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureCORS()
    configureKoin()
    configureSerialization()
    configureTemplating()
    configureRouting()

    BotService().start()
}
