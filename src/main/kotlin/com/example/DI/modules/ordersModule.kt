package com.example.DI.modules

import com.example.data.sources.OrdersDataSource
import com.example.data.sources.OrdersDataSourceImpl
import com.example.services.orders.OrderService
import com.example.services.orders.OrderServiceImpl
import org.koin.dsl.module

val ordersModule = module {
    single<OrdersDataSource> {
        OrdersDataSourceImpl()
    }

    single<OrderService> {
        OrderServiceImpl()
    }
}