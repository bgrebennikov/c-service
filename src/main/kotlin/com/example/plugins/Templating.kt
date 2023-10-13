package com.example.plugins

import com.example.plugins.landings.*
import com.example.services.contacts.ContactsService
import freemarker.cache.ClassTemplateLoader
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import javax.swing.text.MaskFormatter

fun Application.configureTemplating() {

    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }
    routing {

        host(
            "xn-----6kcjnd6aiezscikejc8m.xn--p1ai"
        ){
            pcRepairRoutes()
        }

        // мастер-крылов.рф
        host("xn----7sbhk0agcvocgm6j.xn--p1ai"){
            pcRepairRoutes()
            route("/tv"){
                krylowTvRoutes()
            }
        }



        host("washrepair.ru"){
            washRepairRoutes()

            route("/coolers"){
                coolersRepairRoutes()
            }
        }

        // мастер-аксенов.рф
        host("xn----7sbbimc8alpkqkfi.xn--p1ai"){
            washRepairRoutes()

            route("/coolers"){
                coolersRepairRoutes()
            }

            route("/tv"){
                acsenovTvRoutes()
            }

        }

        host("tvmaster.ru"){
            route("/tv"){
                krylowTvRoutes()
            }
        }

        host("coolersrepair.ru"){
            coolersRepairRoutes()
        }

    }
}

data class IndexData(val items: List<Int>)
