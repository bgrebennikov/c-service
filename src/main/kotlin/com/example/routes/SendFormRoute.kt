package com.example.routes

import com.example.usecase.CreateOrderUseCase
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.sendFormRoute(){

    val createOrderUseCase by inject<CreateOrderUseCase>()

    post {

        val phone = call.receiveParameters()["Phone"]

        call.respond(
            createOrderUseCase.invoke(
                phone,
                call.request.host()
            )
        )
    }
}