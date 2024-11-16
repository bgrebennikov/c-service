package com.example.services.orders

import com.example.data.entity.OrderEntity
import com.example.data.sources.OrdersDataSource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class OrderServiceImpl : OrderService, KoinComponent {

    private val ordersDs : OrdersDataSource by inject()

    override suspend fun createOrder(orderEntity: OrderEntity): Boolean {
        return ordersDs.insert(orderEntity)
    }
}