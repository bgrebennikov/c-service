package com.example.data.sources

import com.example.data.entity.OrderEntity

interface OrdersDataSource {

    suspend fun get(id: String): OrderEntity?

    suspend fun insert(orderEntity: OrderEntity) : Boolean

}