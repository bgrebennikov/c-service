package com.example.DI.modules

import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val databaseModule = module {
    single {
        KMongo
            .createClient(
                "mongodb://localhost:27017"
            )
            .coroutine
            .getDatabase("CompService")
    }
}