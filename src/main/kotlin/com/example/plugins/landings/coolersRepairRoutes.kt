package com.example.plugins.landings

import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.coolersRepairRoutes(){

    get{
        call.respond(
            FreeMarkerContent(
                "coolers/index.ftl",
                null,
                ""
            )
        )
    }

}