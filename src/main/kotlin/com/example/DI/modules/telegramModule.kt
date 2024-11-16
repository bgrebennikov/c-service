package com.example.DI.modules

import com.example.services.telegram.BotService
import org.koin.dsl.module


val telegramModule = module {
    single { BotService() }
}