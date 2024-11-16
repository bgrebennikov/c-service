package com.example.data.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.Date

data class OrderEntity(
    @BsonId
    val id: String = ObjectId().toString(),
    val phone: String,
    val completed: Boolean = false,
    val created: Long = System.currentTimeMillis()
)
