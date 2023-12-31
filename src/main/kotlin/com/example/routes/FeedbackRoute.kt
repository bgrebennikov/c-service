package com.example.routes

import com.example.data.responses.ErrorResponse
import com.example.usecase.CreateOrderUseCase
import com.example.usecase.GetConfigUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

data class ActionRequest(
    val act: String,
    val phone: String? = null,
    val clientId: String? = null,
    val utm_campaign: String? = null,
    val timeUnix : Long? = null
)


data class SuccessResult(
    val ok: Int = 1,
    val infos: List<String> = listOf(
        "Спасибо за обращение! Я свяжусь с вами в течении 15 минут!"
    )
)

fun Route.feedback() {

    val cfgUseCase: GetConfigUseCase by inject()

    post {
        val params: ActionRequest = call.receive()
        when (params.act) {
            "cfg" -> {
                call.respond(cfgUseCase.invoke())
            }

            "form_zayavka" -> {
                call.respond(
                    CreateOrderUseCase().invoke(
                        p = params.phone,
                        fromLanding = call.request.host(),
                        clientID = params.clientId,
                        utm_campaign = params.utm_campaign,
                        timeMillis= params.timeUnix
                    )
                )
            }

            else -> call.respond(HttpStatusCode.BadRequest)
        }
    }
}