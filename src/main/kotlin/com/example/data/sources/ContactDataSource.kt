package com.example.data.sources

import com.example.data.entity.ContactsEntity
import kotlin.reflect.KProperty1

interface ContactDataSource {

    suspend fun get(): ContactsEntity?

    suspend fun updateOne(field: KProperty1<ContactsEntity, String?>, value: String) : Boolean
    suspend fun update(contactsEntity: ContactsEntity) : Boolean

}