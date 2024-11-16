package com.example.routes

import com.example.usecase.CreateOrderUseCase
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.kCoolersSendFormRoutes(){
    val createOrderUseCase by inject<CreateOrderUseCase>()

    post {

        val params = call.receiveParameters()

        val phone = params["Phone"]
        val reason = params["Укажите+неисправность+холодильника"]
        val years = params["Сколько+лет+Вашей+технике"]
        val model = params["Укажите+фирму+и+модель+холодильника"]

        val message = buildString {
            model?.let {
                appendLine("\n\nМодель холодильника: $it")
            }
            years?.let {
                appendLine("Лет технике: $it")
            }
            reason?.let {
                appendLine("Неисправность: $it")
            }
        }

        call.respond(
            createOrderUseCase.invoke(
                phone,
                call.request.host(),
                message.ifEmpty { null },
                null,
                "холодильники"
            )
        )
    }
}