package com.example.data.sources

import com.example.data.entity.OrderEntity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.litote.kmongo.coroutine.CoroutineDatabase

class OrdersDataSourceImpl : OrdersDataSource, KoinComponent {

    private val db : CoroutineDatabase by inject()
    private val orders = db.getCollection<OrderEntity>()

    override suspend fun get(id: String): OrderEntity? {
        return orders.findOneById(id)
    }

    override suspend fun insert(orderEntity: OrderEntity): Boolean {
        val insert = orders.insertOne(orderEntity)
        return insert.wasAcknowledged()
    }
}