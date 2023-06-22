package com.example.plugins

import com.example.services.contacts.ContactsService
import freemarker.cache.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureTemplating() {

    val contacts : ContactsService by inject()

    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }
    routing {
        get {
            call.respond(FreeMarkerContent("index.ftl", mapOf("contacts" to contacts.get()), ""))
        }

        get("/thx") {
            call.respond(FreeMarkerContent(
                "thx.ftl",
                null
            ))
        }
    }
}

data class IndexData(val items: List<Int>)
