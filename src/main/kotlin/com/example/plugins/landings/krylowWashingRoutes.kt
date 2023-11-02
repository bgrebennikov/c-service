package com.example.plugins.landings

import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.krylowWashingRoutes(){
    get {
        val utmCity: Map<String, String> = when (call.parameters["utm_city"]) {
            "KIN" -> mapOf(
                "name" to "Кинель",
                "name_prep" to "Кинеле",
                "name_accus" to "Кинеля",
                "title" to "в Кинеле",
                "city_icon" to "https://s13.stc.yc.kpcdn.net/share/i/12/11201350/wr-960.webp",
                "map_image_url" to "/static/washing/map_kin.png"
            )

            "NVK" -> mapOf(
                "name" to "Новокуйбышевск",
                "name_prep" to "Новокуйбышевске",
                "name_accus" to "Новокуйбышевска",
                "title" to "в Новокуйбышевске",
                "city_icon" to "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/56/42/96/caption.jpg?w=500&h=400&s=1",
                "map_image_url" to "/static/washing/map_nvk.png"
            )

            else -> mapOf(
                "name" to "Самара",
                "name_prep" to "Самаре",
                "name_accus" to "Самары",
                "title" to "в Самаре и области",
                "city_icon" to "static/img/adr.jpg",
                "map_image_url" to "https://static.tildacdn.com/tild3764-3635-4339-b761-373063323235/photo.png"
            )
        }

        call.respond(
            FreeMarkerContent(
                "krylowWashings/kwashing.ftl",
                mapOf("city" to utmCity),
                ""
            )
        )
    }
}