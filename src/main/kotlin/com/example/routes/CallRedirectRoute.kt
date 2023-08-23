package com.example.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.callRedirectRoute(){
    get("/{phone}"){
        val phone = call.parameters["phone"] ?: call.respond(HttpStatusCode.BadRequest)

        call.respondRedirect("tel:+$phone")

    }
}