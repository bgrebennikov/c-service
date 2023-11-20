package com.example.usecase

import com.example.data.entity.OrderEntity
import com.example.data.responses.ErrorResponse
import com.example.routes.SuccessResult
import com.example.services.orders.OrderService
import com.example.services.telegram.BotService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.net.IDN

class CreateOrderUseCase : KoinComponent {

    private val orderService: OrderService by inject()
    private val telegramService: BotService by inject()

    private val err = ErrorResponse(
        errors = mapOf(
            "phone" to "Неверный формат номера телефона"
        )
    )

    suspend operator fun invoke(
        p: String?, fromLanding: String? = null,
        reason: String? = null,
        customer_name: String? = null,
        tag: String? = null,
        city: String? = null,
        form_name: String? = null,
        clientID: String? = null,
        utm_campaign: String? = null,
        timeMillis: Long? = null
    ): Any {

        val ppcCampaigns = listOf("95845827", "99002741", "97146424", "98999696")

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
                    appendLine("Новая заявка!\n")
                    if (tag != null) {
                        appendLine("[${tag.uppercase()}]\n")
                    }
                    if (city != null) {
                        appendLine("Город: $city")
                    }
                    if (customer_name != null) {
                        appendLine("Имя клиента: $customer_name")
                    }
                    if (form_name != null) {
                        appendLine("Отправленно с формы: $form_name")
                    }
                    appendLine("Телефон: $phone\n")
                    if (fromLanding != null) appendLine(
                        "Отправлено с сайта: https://${IDN.toUnicode(fromLanding)}"
                    )
                    if (reason != null) {
                        appendLine("Причина обращения: $reason")
                    }

                    clientID?.let {
                        if(ppcCampaigns.contains(utm_campaign)){
                            appendLine(
                                "\n!!! Оффлайн Конверсия!!!\nНе забудьте указать эти данные в недельном отчете!" +
                                        "\n\n" +
                                        "ClientID: $clientID\n" +
                                        "CampaignID: $utm_campaign\n" +
                                        "TimeMillis: $timeMillis"
                            )
                        }
                    }

                }

                try {
                    telegramService.sendNotification(messageBody, 1979249233, phone)
                    telegramService.sendNotification(messageBody, 868633316, phone)



                } catch (e: Exception) {

                }
                return SuccessResult()
            } else err

        } catch (e: Exception) {
            e.printStackTrace()
            return err
        }
    }

}