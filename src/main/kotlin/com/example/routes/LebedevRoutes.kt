package com.example.routes

import com.example.data.requests.LebedevFormRequest
import com.example.usecase.CreateOrderUseCase
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.lebedevRoutes() {

//    singlePageApplication {
//        filesPath = "allfix-frontend"
//        defaultPage = "index.html"
//        ignoreFiles { it.endsWith(".txt") }
//    }

    singlePageApplication(){
        useResources = true
        react("allfix-frontend")
    }


    route("/feedback") {
        lebedevFeedback()
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