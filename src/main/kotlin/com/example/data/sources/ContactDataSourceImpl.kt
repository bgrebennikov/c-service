package com.example.data.sources

import com.example.data.entity.ContactsEntity
import com.mongodb.client.model.UpdateOptions
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.litote.kmongo.coroutine.CoroutineDatabase

class ContactDataSourceImpl : ContactDataSource, KoinComponent {

    private val db : CoroutineDatabase by inject()
    private val contacts = db.getCollection<ContactsEntity>()

    override suspend fun get(): ContactsEntity? {
        return contacts.find().first() ?: ContactsEntity(
            phone = "79991710011",
            whatsapp = "79991710011",
            viber = "79991710011",
            email = "bgrebennikovv@gmail.com",
            telegram = "mrx2000"
        )
    }

    override suspend fun update(contactsEntity: ContactsEntity): Boolean {
        val upd = contacts.updateOneById(
            id = contactsEntity.id, contactsEntity,
            UpdateOptions().upsert(true)
        )
        return upd.wasAcknowledged()
    }
}