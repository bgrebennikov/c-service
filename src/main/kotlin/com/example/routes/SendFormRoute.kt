package com.example.routes

import com.example.usecase.CreateOrderUseCase
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

data class CoolersOrderRequest(
    val phone: String,
    val name : String?,
    val text: String?,
    val city: String,
    val tag: String,
    val form_name: String?
)
fun Route.coolerSendFormRoute(){

    val createOrderUseCase by inject<CreateOrderUseCase>()

    post {

        val params = call.receiveNullable<CoolersOrderRequest>()

        call.respond(
            createOrderUseCase.invoke(
                params?.phone,
                call.request.host(),
                params?.text,
                params?.name,
                params?.tag,
                params?.city,
                params?.form_name
            )
        )
    }
}