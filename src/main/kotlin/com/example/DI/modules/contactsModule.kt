package com.example.DI.modules

import com.example.data.sources.ContactDataSource
import com.example.data.sources.ContactDataSourceImpl
import com.example.services.contacts.ContactsService
import com.example.services.contacts.ContactsServiceImpl
import org.koin.dsl.module


val contactsModule = module {
    single<ContactDataSource> {
        ContactDataSourceImpl()
    }

    single<ContactsService> {
        ContactsServiceImpl()
    }
}