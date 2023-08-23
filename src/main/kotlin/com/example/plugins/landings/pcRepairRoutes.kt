package com.example.plugins.landings

import com.example.services.contacts.ContactsService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import javax.swing.text.MaskFormatter

fun Route.pcRepairRoutes(){

    val contacts: ContactsService by inject()

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

        val redirectUrl = call.parameters["redirectUrl"] ?: "/"
        if (redirectUrl.contains("http")) call.respond(HttpStatusCode.BadRequest)

        call.respond(
            FreeMarkerContent(
                "thx.ftl",
                mapOf("redirectUrl" to redirectUrl)
            )
        )
    }
}