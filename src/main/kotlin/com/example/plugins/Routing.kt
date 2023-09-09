package com.example.plugins

import com.example.routes.callRedirectRoute
import com.example.routes.feedback
import com.example.routes.coolerSendFormRoute
import com.example.routes.washingSendFormRoute
import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*

fun Application.configureRouting() {

    routing {
        static("/static") {
            resources("static")
        }

        route("/feedback/"){
            feedback()
        }

        route("/coolers-sendForm"){
            coolerSendFormRoute()
        }

        route("/sendForm"){
            washingSendFormRoute()
        }

        host("call.xn----7sbhk0agcvocgm6j.xn--p1ai"){
            route("/"){
                callRedirectRoute()
            }
        }



    }
}
