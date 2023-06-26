package com.example.plugins

import com.example.services.contacts.ContactsService
import freemarker.cache.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import javax.swing.text.MaskFormatter

fun Application.configureTemplating() {

    val contacts: ContactsService by inject()

    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }
    routing {
        get {
            val contactsValues = contacts.get()

            val phoneMask = MaskFormatter("# (###) ###-##-##").apply {
                valueContainsLiteralCharacters = false
            }
            val phoneFormatted = phoneMask.valueToString(contactsValues?.phone)

            call.respond(
                FreeMarkerContent(
                    "index.ftl", mapOf(
                        "contacts" to contactsValues,
                        "phoneFormatted" to phoneFormatted,
                        "images" to listOf("Image1", "Image2", "Image3")
                    ), ""
                )
            )
        }

        get("/thx") {
            call.respond(
                FreeMarkerContent(
                    "thx.ftl",
                    null
                )
            )
        }
    }
}

data class IndexData(val items: List<Int>)
