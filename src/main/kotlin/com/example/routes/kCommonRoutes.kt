package com.example.routes

import com.example.usecase.CreateOrderUseCase
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.krylowCommonRoutes(){

    val createOrderUseCase by inject<CreateOrderUseCase>()

    get {

        call.respond(
            FreeMarkerContent(
                "/krylowCommon/krylowCommon.ftl",
                mapOf("city" to null),
            )
        )

    }

    post("/sendForm") {

        val params = call.receiveParameters()

        val phone = params["Phone"]
        val name = params["Name"]
        val tag = params["tag"]

        call.respond(
            createOrderUseCase.invoke(
                p = phone,
                fromLanding = call.request.host(),
                null,
                name,
                tag
            )
        )

    }

}