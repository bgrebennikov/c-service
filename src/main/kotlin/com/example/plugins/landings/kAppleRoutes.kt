package com.example.plugins.landings

import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.kAppleRoutes(){
    route("/"){

        get {
            call.respond(
                FreeMarkerContent(
                    "kApple/kApple.ftl",
                    null
                )
            )
        }

        get("/devices") {
            call.respond(
                FreeMarkerContent(
                    "kApple/kAppleDevices.ftl",
                    null
                )
            )
        }

        get("/stock") {
            call.respond(
                FreeMarkerContent(
                    "kApple/kAppleStocks.ftl",
                    null
                )
            )
        }

        typesRoutes()


    }
}

fun Route.typesRoutes(){
    get("/laptop") {
        call.respond(
            FreeMarkerContent(
                "kApple/kAppleLaptop.ftl",
                null
            )
        )
    }

    post("/load_more_models"){
        call.respond(
            FreeMarkerContent(
                "kApple/laptop_models.ftl",
                null
            )
        )
    }
}