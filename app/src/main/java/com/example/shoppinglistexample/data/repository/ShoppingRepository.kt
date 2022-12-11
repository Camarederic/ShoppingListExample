package com.example.shoppinglistexample.data.repository

import com.example.shoppinglistexample.data.database.ShoppingDatabase
import com.example.shoppinglistexample.data.database.entity.ShoppingItem

class ShoppingRepository(private val database: ShoppingDatabase) {

    suspend fun upsert(item: ShoppingItem) = database.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = database.getShoppingDao().delete(item)

    fun getAllShoppingItems() = database.getShoppingDao().getAllShoppingItems()
}