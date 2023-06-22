package com.example.data.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class ContactsEntity(
    @BsonId
    val id: String = ObjectId().toString(),
    val phone: String? = null,
    val whatsapp: String? = null,
    val viber: String? = null,
    val telegram: String? = null,
    val email: String? = null,
)