package com.example.DI.modules

import com.example.usecase.CreateOrderUseCase
import com.example.usecase.GetConfigUseCase
import org.koin.dsl.module


val useCasesModule = module {
    single {
        GetConfigUseCase()
    }
    single {
        CreateOrderUseCase()
    }
}