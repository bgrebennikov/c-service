package com.example.common.ext

import io.ktor.server.application.*

fun Application.getEnv(field: String) =
    environment.config.property(field).getString()