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

        val utmCity: Map<String, String> = when(call.parameters["utm_city"]){
            "KIN" -> mapOf(
                "name" to "Кинель",
                "name_prep" to "Кинеле",
                "name_accus" to "Кинеля",
                "title" to "в Кинеле",
                "city_icon" to "https://s13.stc.yc.kpcdn.net/share/i/12/11201350/wr-960.webp"
            )
            "NVK" -> mapOf(
                "name" to "Новокуйбышевск",
                "name_prep" to "Новокуйбышевске",
                "name_accus" to "Новокуйбышевска",
                "title" to "в Новокуйбышевске",
                "city_icon" to "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/56/42/96/caption.jpg?w=500&h=400&s=1"
            )
            else -> mapOf(
                "name" to "Самара",
                "name_prep" to "Самаре",
                "name_accus" to "Самары",
                "title" to "в Самаре и области",
                "city_icon" to "static/img/adr.jpg"
            )
        }

        call.respond(
            FreeMarkerContent(
                "index.ftl", mapOf(
                    "contacts" to contactsValues,
                    "phoneFormatted" to phoneFormatted,
                    "images" to listOf("Image1", "Image2", "Image3"),
                    "city" to utmCity
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