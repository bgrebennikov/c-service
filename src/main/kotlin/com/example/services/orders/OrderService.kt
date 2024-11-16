package com.example.services.orders

import com.example.data.entity.OrderEntity

interface OrderService {

    suspend fun createOrder(orderEntity: OrderEntity) : Boolean

}