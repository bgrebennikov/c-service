package com.example.services.contacts

import com.example.data.entity.ContactsEntity

interface ContactsService {

    suspend fun get(): ContactsEntity?

}