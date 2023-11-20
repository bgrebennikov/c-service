package com.example.plugins

import com.example.routes.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*

fun Application.configureRouting() {

    routing {
        static("/static") {
            resources("static")
        }

        route("/feedback/") {
            feedback()
        }

        route("/coolers-sendForm") {
            coolerSendFormRoute()
        }

        route("/sendForm") {
            washingSendFormRoute()
        }

        route("/coolers/sendForm") {
            kCoolersSendFormRoutes()
        }

        host("call.xn----7sbhk0agcvocgm6j.xn--p1ai") {
            route("/") {
                callRedirectRoute()
            }
        }

        // мастер-лебедев.рф
        host("xn----7sbeejdbbb9ch4clo.xn--p1ai"){
            lebedevRoutes()
        }

        host("localhost") {
            lebedevRoutes()
        }


    }
}
