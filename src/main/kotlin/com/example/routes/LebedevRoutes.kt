package com.example.routes

import com.example.data.requests.DeviceRequest
import com.example.data.requests.LebedevFormRequest
import com.example.services.devices.DeviceService
import com.example.usecase.CreateOrderUseCase
import com.google.gson.GsonBuilder
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.lebedevRoutes() {

    singlePageApplication(){
        useResources = true
        react("allfix-frontend")
    }


    route("/feedback") {
        lebedevFeedback()
    }

    route("/devices"){

        val deviceService : DeviceService by inject()

        post("/insert") {
            val deviceData = call.receive<DeviceRequest>()

            call.respond(deviceService.insert(deviceData))

        }

        post("/{deviceName}") {
            val deviceName = call.parameters["deviceName"] ?: call.respond(HttpStatusCode.NotFound)

            if(deviceName != "candy-cs34-1051-d1") call.respond(HttpStatusCode.NotFound)

            call.respond(
                mapOf(
                    "path" to "candy-cs34-1051-d1",
                    "model_name" to "Candy CS34 1051 D1/2-07",
                    "image_url" to "https://candy-one-remonts.ru/assets/img/stiralka/candy-cs34-1051-d12-07.jpg",
                    "coast" to "23999.00"
                )
            )

        }

    }
}


private fun Route.lebedevFeedback() {

    val createOrderUseCase: CreateOrderUseCase by inject()

    post {
        val form: LebedevFormRequest = call.receive()

        call.respond(
            createOrderUseCase.invoke(
                p = form.phone,
                fromLanding = "${call.request.host()}${form.fromLanding}",
                reason = form.description,
                tag = form.tag,
                clientID = form.clientId,
                utm_campaign = form.campaignId,
                timeMillis = form.timeUnix
            )
        )
    }
}