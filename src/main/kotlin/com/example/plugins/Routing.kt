package com.example.plugins

import com.example.routes.callRedirectRoute
import com.example.routes.feedback
import com.example.routes.sendFormRoute
import io.ktor.server.routing.*
import io.ktor.server.response.*
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

        route("/sendForm"){
            sendFormRoute()
        }

        host("call.xn-----6kcjnd6aiezscikejc8m.xn--p1ai"){
            route("/"){
                callRedirectRoute()
            }
        }



    }
}
