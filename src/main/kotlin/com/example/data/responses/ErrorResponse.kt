package com.example.data.responses

data class ErrorResponse(
    val ok: Int = 0,
    val errors: Map<String, String> = mapOf(
        "phone" to "Поле [ Телефон ] не заполнено"
    )
)
