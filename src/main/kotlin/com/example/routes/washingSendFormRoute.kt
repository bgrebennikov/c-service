package com.example.routes

import com.example.usecase.CreateOrderUseCase
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.washingSendFormRoute() {
    val createOrderUseCase by inject<CreateOrderUseCase>()

    post {

        val params = call.receiveParameters()

        val phone = params["Phone"]
        val clientId = params["clientId"]
        val utmCampaign = params["utm_campaign"]
        val timeUnix = params["timeUnix"]

        call.respond(
            createOrderUseCase.invoke(
                p = phone,
                fromLanding = call.request.host(),
                clientID = clientId,
                utm_campaign = utmCampaign,
                timeMillis = timeUnix?.toLong()
            )
        )
    }
}