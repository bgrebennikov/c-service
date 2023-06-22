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
        return contacts.find().first()
    }

    override suspend fun update(contactsEntity: ContactsEntity): Boolean {
        val upd = contacts.updateOneById(
            id = contactsEntity.id, contactsEntity,
            UpdateOptions().upsert(true)
        )
        return upd.wasAcknowledged()
    }
}