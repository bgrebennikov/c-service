package com.example.services.telegram.handlers

import com.example.data.telegram.states.BotState
import com.example.services.contacts.ContactsService
import com.example.services.telegram.ext.*
import dev.inmo.tgbotapi.extensions.api.send.sendMessage
import dev.inmo.tgbotapi.extensions.behaviour_builder.BehaviourContext
import dev.inmo.tgbotapi.extensions.behaviour_builder.DefaultBehaviourContextWithFSM
import dev.inmo.tgbotapi.extensions.behaviour_builder.expectations.waitText
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onText
import dev.inmo.tgbotapi.requests.send.SendTextMessage
import dev.inmo.tgbotapi.types.ChatId
import dev.inmo.tgbotapi.types.ChatIdentifier
import kotlinx.coroutines.flow.first
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.lang.StringBuilder

class ContactsHandler : KoinComponent {

    private val contactsService: ContactsService by inject()


    private suspend fun BehaviourContext.initialContacts(chatId: ChatIdentifier) {

        val contacts = contactsService.get()

        val body = StringBuilder().apply {
            appendLine("Ваши контакты\n")
            contacts?.email.let { appendLine("Email: $it") }
            contacts?.telegram.let { appendLine("Telegram: $it") }
            contacts?.phone.let { appendLine("Телефон: $it") }
            contacts?.viber.let { appendLine("Viber: $it") }
            contacts?.whatsapp.let { appendLine("WhatsApp: $it") }
            appendLine("\nКакую информацию необходимо поменять?")
        }

        sendMessage(
            chatId,
            body.toString(),
            replyMarkup = contactsKeys
        )
    }

    private suspend fun BehaviourContext.changeEmail(chatId: ChatIdentifier) {
        val receivedValue = waitText(
            SendTextMessage(
                chatId,
                "Отправьте новый Email",
                replyMarkup = backToContactsKeys
            )
        ).first().text.takeIf { it != BACK_TO_CONTACTS }
        receivedValue?.let {
            val updResult = contactsService.updateEmail(it)
            if (updResult) sendMessage(
                chatId,
                "Email обновлен",
                replyMarkup = contactsKeys
            )
            initialContacts(chatId)
        }

    }

    private suspend fun BehaviourContext.changeTelegram(chatId: ChatIdentifier) {
        val receivedValue = waitText(
            SendTextMessage(
                chatId,
                "Отправьте Telegram контакт в формате @username",
                replyMarkup = backToContactsKeys
            )
        ).first().text.takeIf { it != BACK_TO_CONTACTS }
        receivedValue?.let {
            val updResult = contactsService.updateTelegram(it)
            if (updResult) sendMessage(
                chatId,
                "Telegram обновлен",
                replyMarkup = contactsKeys
            )
            initialContacts(chatId)
        }

    }

    private suspend fun BehaviourContext.changeViber(chatId: ChatIdentifier) {
        val receivedValue = waitText(
            SendTextMessage(
                chatId,
                "Отправьте новый номер Viber",
                replyMarkup = backToContactsKeys
            )
        ).first().text.takeIf { it != BACK_TO_CONTACTS }
        receivedValue?.let {
            val updResult = contactsService.updateViber(it)
            if (updResult) sendMessage(
                chatId,
                "Viber обновлен",
                replyMarkup = contactsKeys
            )
            initialContacts(chatId)
        }

    }

    private suspend fun BehaviourContext.changeWhatsapp(chatId: ChatIdentifier) {
        val receivedValue = waitText(
            SendTextMessage(
                chatId,
                "Отправьте новый номер WhatsApp",
                replyMarkup = backToContactsKeys
            )
        ).first().text.takeIf { it != BACK_TO_CONTACTS }
        receivedValue?.let {
            val updResult = contactsService.updateWhatsApp(it)
            if (updResult) sendMessage(
                chatId,
                "WhatsApp обновлен",
                replyMarkup = contactsKeys
            )
            initialContacts(chatId)
        }

    }

    private suspend fun BehaviourContext.changePhoneNumber(chatId: ChatIdentifier) {
        val phone = waitText(
            SendTextMessage(
                chatId,
                "Отправьте новый номер телефона",
                replyMarkup = backToContactsKeys
            )
        ).first().text.takeIf { it != BACK_TO_CONTACTS }
        phone?.let {

            try {
                val newPhone = it.replace("[^0-9]".toRegex(), "").trim()
                val updResult = contactsService.updatePhone(newPhone)
                if (updResult) sendMessage(
                    chatId,
                    "Номер телефона обновлен",
                    replyMarkup = contactsKeys
                )
                initialContacts(chatId)
            } catch (e: Exception){
                sendMessage(chatId, "Неверный формат номера телефона")
                changePhoneNumber(chatId)
            }
        }
    }

    suspend fun onReceive(context: DefaultBehaviourContextWithFSM<BotState>) {

        context.onText(initialFilter = {it.chat.id == ChatId(868633316) || it.chat.id == ChatId(1979249233)}) {
            when (it.content.text) {
                CONTACTS_LABEL, BACK_TO_CONTACTS -> initialContacts(it.chat.id)

                CHANGE_EMAIL_LABEL -> changeEmail(it.chat.id)
                CHANGE_TELEGRAM_LABEL -> changeTelegram(it.chat.id)
                CHANGE_PHONE_LABEL -> changePhoneNumber(it.chat.id)
                CHANGE_VIBER_LABEL -> changeViber(it.chat.id)
                CHANGE_WHATSAPP_LABEL -> changeWhatsapp(it.chat.id)
            }
        }
    }

}