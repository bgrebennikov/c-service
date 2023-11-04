package com.example.plugins

import com.example.plugins.landings.*
import com.example.routes.krylowCommonRoutes
import freemarker.cache.ClassTemplateLoader
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.routing.*

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
            route("/coolers"){
                kCoolersRoutes()
            }
            route("/washing"){
                krylowWashingRoutes()
            }
        }

        // мастер-лебедев.рф
        host("xn----7sbeejdbbb9ch4clo.xn--p1ai"){
            route("/"){
                krylowCommonRoutes()
            }
        }

        host("washrepair.ru"){

            route("/remont"){
                krylowCommonRoutes()
            }

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
            route("/"){
                acsenovTvRoutes()
            }
        }

        host("coolersrepair.ru"){
            krylowWashingRoutes()
        }

        host("192.168.13.210"){
            krylowWashingRoutes()
        }

    }
}

data class IndexData(val items: List<Int>)
