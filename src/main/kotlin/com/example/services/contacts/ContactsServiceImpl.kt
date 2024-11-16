package com.example.services.contacts

import com.example.data.entity.ContactsEntity
import com.example.data.sources.ContactDataSource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ContactsServiceImpl : ContactsService, KoinComponent {

    private val contactsDs : ContactDataSource by inject()

    override suspend fun get(): ContactsEntity? {
        return contactsDs.get()
    }

    override suspend fun updatePhone(phone: String): Boolean {
        if (phone.length  !in 11..12) throw Exception("Не верный формат номера телефона")
        return contactsDs.updateOne(ContactsEntity::phone, phone)
    }

    override suspend fun updateEmail(email: String): Boolean {
        return contactsDs.updateOne(ContactsEntity::email, email)
    }

    override suspend fun updateViber(viber: String): Boolean {
        return contactsDs.updateOne(ContactsEntity::viber, viber)
    }

    override suspend fun updateWhatsApp(whatsapp: String): Boolean {
        return contactsDs.updateOne(ContactsEntity::whatsapp, whatsapp)
    }

    override suspend fun updateTelegram(telegram: String): Boolean {
        return contactsDs.updateOne(ContactsEntity::telegram, telegram)
    }
}