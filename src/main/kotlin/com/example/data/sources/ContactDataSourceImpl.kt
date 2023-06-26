package com.example.data.sources

import com.example.data.entity.ContactsEntity
import com.mongodb.client.model.UpdateOptions
import org.bson.types.ObjectId
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.litote.kmongo.*
import org.litote.kmongo.coroutine.CoroutineDatabase
import kotlin.reflect.KProperty1

class ContactDataSourceImpl : ContactDataSource, KoinComponent {

    private val db : CoroutineDatabase by inject()
    private val contacts = db.getCollection<ContactsEntity>()

    override suspend fun get(): ContactsEntity {
        return contacts.find().first() ?: ContactsEntity(
            phone = "79991710011",
            whatsapp = "79991710011",
            viber = "79991710011",
            email = "bgrebennikovv@gmail.com",
            telegram = "mrx2000"
        )
    }

    override suspend fun updateOne(field: KProperty1<ContactsEntity, String?>, value: String): Boolean {

        val uid = get().id

        val upd = contacts.updateOne(
            ContactsEntity::id eq ObjectId(uid).toString(),
            set(
                field setTo value
            ),
            upsert()
        )

        return upd.wasAcknowledged()
    }

    override suspend fun update(contactsEntity: ContactsEntity): Boolean {
        val upd = contacts.updateOneById(
            id = contactsEntity.id, contactsEntity,
            UpdateOptions().upsert(true)
        )
        return upd.wasAcknowledged()
    }
}