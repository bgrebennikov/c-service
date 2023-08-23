package com.example.plugins.landings

import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.washRepairRoutes(){


    get {
        call.respond(
            FreeMarkerContent(
                "washing/index.ftl", null, ""
            )
        )
    }


}