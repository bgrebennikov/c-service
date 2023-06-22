package com.example.usecase

import com.example.data.entity.OrderEntity
import com.example.data.responses.ErrorResponse
import com.example.routes.SuccessResult
import com.example.services.orders.OrderService
import com.example.services.telegram.BotService
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

    suspend operator fun invoke(p: String?): Any {
        try {
            p ?: return err
            val phone = p.replace("[^0-9]".toRegex(), "").trim()
            println("Phone is $phone")
            if (phone.length != 11) return err


            return if (
                orderService.createOrder(
                    OrderEntity(
                        phone = phone
                    )
                )
            ) {
                telegramService.sendNotification("Новая заявка!\n\nТелефон: $phone", 1979249233)
                telegramService.sendNotification("Новая заявка!\n\nТелефон: $phone",868633316)
                SuccessResult()
            } else err

        } catch (e: Exception) {
            return err
        }
    }

}