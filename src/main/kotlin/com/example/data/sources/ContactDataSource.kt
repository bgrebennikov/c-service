package com.example.data.sources

import com.example.data.entity.ContactsEntity

interface ContactDataSource {

    suspend fun get(): ContactsEntity?

    suspend fun update(contactsEntity: ContactsEntity) : Boolean

}