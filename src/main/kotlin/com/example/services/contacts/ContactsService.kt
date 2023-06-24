package com.example.services.contacts

import com.example.data.entity.ContactsEntity

interface ContactsService {

    suspend fun get(): ContactsEntity?

    suspend fun updatePhone(phone: String): Boolean
    suspend fun updateEmail(email: String): Boolean
    suspend fun updateViber(viber: String): Boolean
    suspend fun updateWhatsApp(whatsapp: String): Boolean
    suspend fun updateTelegram(telegram: String): Boolean

}