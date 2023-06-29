package com.example.services.telegram

import com.example.services.contacts.ContactsService
import com.example.services.telegram.ext.mainKeys
import com.example.services.telegram.handlers.ContactsHandler
import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.bot.ktor.telegramBot
import dev.inmo.tgbotapi.extensions.api.send.sendMessage
import dev.inmo.tgbotapi.extensions.api.send.sendTextMessage
import dev.inmo.tgbotapi.extensions.behaviour_builder.BehaviourContext
import dev.inmo.tgbotapi.extensions.behaviour_builder.telegramBotWithBehaviourAndFSMAndStartLongPolling
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onCommand
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onText
import dev.inmo.tgbotapi.types.ChatId
import dev.inmo.tgbotapi.types.IdChatIdentifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BotService : KoinComponent{

    private val contactsService : ContactsService by inject()

    private var bot: TelegramBot = telegramBot("6215463347:AAEA3y87LiGwTZ4X3E4e50U2BEAQaFLhlbc")

    private val scope = CoroutineScope(Dispatchers.IO)

    private val contactsHandler = ContactsHandler()

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

                contactsHandler.onReceive(this)

                onText {
                    if(it.content.text == "В меню") sendWelcome(this, it.chat.id)
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
            replyMarkup = mainKeys
        )
    }

    suspend fun sendNotification(text: String, toUser: Long) {
        bot.sendTextMessage(ChatId(toUser), text)
    }


}