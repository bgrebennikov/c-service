package com.example.plugins.landings

import com.example.data.landing1.Landing1SubmitFormEntity
import com.example.data.responses.ErrorResponse
import com.example.services.contacts.ContactsService
import com.example.usecase.CreateOrderUseCase
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.Langing1() {

    val createOrderUseCase: CreateOrderUseCase by inject()

    route("ремонт") {
        get {
            call.respond(
                FreeMarkerContent(
                    template = "landing1/index.ftl", null
                )
            )
        }
        post {

            val formData = call.receiveParameters()

            when (createOrderUseCase.invoke(
                formData["Phone"],
                "/ремонт",
                formData["polomka"]
            )) {
                is ErrorResponse -> call.respondText("ERROR_REQUIRED")
                else -> call.respondText("success")
            }

        }
    }
}