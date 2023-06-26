package com.example.services.telegram.ext

import dev.inmo.tgbotapi.types.buttons.ReplyKeyboardMarkup
import dev.inmo.tgbotapi.types.buttons.SimpleKeyboardButton
import dev.inmo.tgbotapi.utils.matrix
import dev.inmo.tgbotapi.utils.row

const val CONTACTS_LABEL = "\uD83D\uDCCD Изменить контакты"

const val CHANGE_PHONE_LABEL = "\uD83D\uDCF1 Изменить Телефон"
const val CHANGE_VIBER_LABEL = "\uD83D\uDCDE Изменить Viber"
const val CHANGE_WHATSAPP_LABEL = "\uD83D\uDC4B Изменить WhatsApp"
const val CHANGE_TELEGRAM_LABEL = "✈ Изменить Telegram"
const val CHANGE_EMAIL_LABEL = "✉ Изменить Email"

const val BACK_TO_CONTACTS = "\uD83D\uDCCD Вернуться назад"

val mainKeys = ReplyKeyboardMarkup(
    matrix {
        row {
            +SimpleKeyboardButton(CONTACTS_LABEL)
        }
        row {
            +SimpleKeyboardButton("\uD83D\uDD14 Настройки уведомлений")
        }
    },
    oneTimeKeyboard = true,
    resizeKeyboard = true
)

val contactsKeys = ReplyKeyboardMarkup(
    matrix {
        row {
            +SimpleKeyboardButton(CHANGE_EMAIL_LABEL)
        }
        row {
            +SimpleKeyboardButton(CHANGE_TELEGRAM_LABEL)
        }
        row {

            +SimpleKeyboardButton(CHANGE_PHONE_LABEL)
        }
        row {
            +SimpleKeyboardButton(CHANGE_VIBER_LABEL)
        }
        row {
            +SimpleKeyboardButton(CHANGE_WHATSAPP_LABEL)
        }

        row {
            +SimpleKeyboardButton("В меню")
        }

    },
    oneTimeKeyboard = true,
    resizeKeyboard = true
)

val backToContactsKeys = ReplyKeyboardMarkup(
    matrix {
        row {
            +SimpleKeyboardButton(BACK_TO_CONTACTS)
        }
    },
    oneTimeKeyboard = true,
    resizeKeyboard = true
)
