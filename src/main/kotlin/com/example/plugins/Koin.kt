package com.example.plugins

import com.example.DI.modules.*
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configureKoin(){
    install(Koin){
        modules(
            useCasesModule,
            databaseModule,
            ordersModule,
            telegramModule,
            contactsModule
        )
    }
}