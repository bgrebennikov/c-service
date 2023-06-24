package com.example.services.telegram

import com.example.data.telegram.states.BotState
import com.example.services.contacts.ContactsService
import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.bot.ktor.telegramBot
import dev.inmo.tgbotapi.extensions.api.send.send
import dev.inmo.tgbotapi.extensions.api.send.sendMessage
import dev.inmo.tgbotapi.extensions.api.send.sendTextMessage
import dev.inmo.tgbotapi.extensions.behaviour_builder.BehaviourContext
import dev.inmo.tgbotapi.extensions.behaviour_builder.expectations.waitPhoto
import dev.inmo.tgbotapi.extensions.behaviour_builder.expectations.waitText
import dev.inmo.tgbotapi.extensions.behaviour_builder.telegramBotWithBehaviourAndFSMAndStartLongPolling
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.command
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onCommand
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onText
import dev.inmo.tgbotapi.extensions.utils.extensions.raw.text
import dev.inmo.tgbotapi.requests.send.SendTextMessage
import dev.inmo.tgbotapi.types.ChatId
import dev.inmo.tgbotapi.types.IdChatIdentifier
import dev.inmo.tgbotapi.types.buttons.KeyboardMarkup
import dev.inmo.tgbotapi.types.buttons.ReplyKeyboardMarkup
import dev.inmo.tgbotapi.types.buttons.SimpleKeyboardButton
import dev.inmo.tgbotapi.utils.matrix
import dev.inmo.tgbotapi.utils.row
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BotService : KoinComponent{

    private val contactsService : ContactsService by inject()

    private var bot: TelegramBot = telegramBot("6215463347:AAEA3y87LiGwTZ4X3E4e50U2BEAQaFLhlbc")

    private val scope = CoroutineScope(Dispatchers.IO)

    fun start() {
        scope.launch {
            telegramBotWithBehaviourAndFSMAndStartLongPolling(
                "6215463347:AAEA3y87LiGwTZ4X3E4e50U2BEAQaFLhlbc",
                CoroutineScope(Dispatchers.IO),
                onStateHandlingErrorHandler = BotStateErrorHandler(),
                defaultExceptionsHandler = {
                    it.printStackTrace()
                }
            ) {


                onCommand("start") {
                    sendWelcome(this, it.chat.id)
                }

                onText {
                    when (it.content.text) {
                        "Изменить контакты" -> {
                            sendMessage(
                                it.chat.id, "Какую информацию необходимо поменять?", replyMarkup = ReplyKeyboardMarkup(
                                    matrix {
                                        row {
                                            +SimpleKeyboardButton("Изменить Email")
                                        }
                                        row {
                                            +SimpleKeyboardButton("Изменить Telegram")
                                        }
                                        row {

                                            +SimpleKeyboardButton("Изменить Телефон")
                                        }
                                        row {
                                            +SimpleKeyboardButton("Изменить Viber")
                                        }
                                        row {
                                            +SimpleKeyboardButton("Изменить WhatsApp")
                                        }

                                        row {
                                            +SimpleKeyboardButton("В меню")
                                        }

                                    },
                                    oneTimeKeyboard = true,
                                    resizeKeyboard = true
                                )
                            )
                        }
                        "Изменить Телефон" -> {
                            val phone = waitText(
                                SendTextMessage(it.chat.id,
                                "Отправьте новый номер телефона"
                                )
                            ).first().text
                            val updResult = contactsService.updatePhone(phone)
                            if (updResult) sendMessage(it.chat.id, "Номер телефона обновлен")

                        }
                        "В меню" -> sendWelcome(this, it.chat.id)
                    }
                }




            }.also {
                bot = it.first
                it.second.join()
            }
        }
    }

    private suspend fun sendWelcome(context: BehaviourContext, chaiId: IdChatIdentifier) {
        context.sendMessage(
            chaiId, "Выбери действие:",
            replyMarkup = ReplyKeyboardMarkup(
                matrix {
                    row {
                        +SimpleKeyboardButton("Изменить контакты")
                    }
                    row {
                        +SimpleKeyboardButton("Настройки уведомлений")
                    }
                },
                oneTimeKeyboard = true,
                resizeKeyboard = true
            )
        )
    }

    suspend fun sendNotification(text: String, toUser: Long) {
        bot.sendTextMessage(ChatId(toUser), text)
    }


}