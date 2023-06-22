package com.example.services.contacts

import com.example.data.entity.ContactsEntity
import com.example.data.sources.ContactDataSource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ContactsServiceImpl : ContactsService, KoinComponent {

    private val contactsDs : ContactDataSource by inject()

    override suspend fun get(): ContactsEntity? {
//        contactsDs.update(
//            ContactsEntity(
//                phone = "79879009975",
//                whatsapp = "79879009975",
//                viber = "79879009975",
//                telegram = "mrx2000",
//                email = "bgrebennikovv@gmail.com"
//            )
//        )
        return contactsDs.get()
    }
}