package com.example.usecase

import com.example.data.entity.OrderEntity
import com.example.data.responses.ErrorResponse
import com.example.routes.SuccessResult
import com.example.services.orders.OrderService
import com.example.services.telegram.BotService
import dev.inmo.tgbotapi.bot.exceptions.CommonRequestException
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CreateOrderUseCase : KoinComponent {

    private val orderService: OrderService by inject()
    private val telegramService: BotService by inject()

    private val err = ErrorResponse(
        mapOf(
            "phone" to "Неверный формат номера телефона"
        )
    )

    suspend operator fun invoke(
        p: String?, fromLanding: String? = null,
        reason: String? = null
    ): Any {
        try {
            p ?: return err
            val phone = p.replace("[^0-9]".toRegex(), "").trim()
            println("Phone is $phone")
            if (phone.length < 11 || phone.length > 12) return err


            return if (
                orderService.createOrder(
                    OrderEntity(
                        phone = phone
                    )
                )
            ) {

                val messageBody = buildString {
                    appendLine("Новая заявка!\n\nТелефон: $phone")
                    if (fromLanding != null) appendLine(
                        "Отправлено со страницы: https://мастер-крылов.рф/${fromLanding}"
                    )
                    if (reason != null) {
                        appendLine("Причина обращения: $reason")
                    }
                }

                try {
                    telegramService.sendNotification(messageBody, 1979249233)
                    telegramService.sendNotification(messageBody, 868633316)
                }
                catch (e: Exception){

                }
                return SuccessResult()
            } else err

        }
        catch (e: Exception) {
            e.printStackTrace()
            return err
        }
    }

}