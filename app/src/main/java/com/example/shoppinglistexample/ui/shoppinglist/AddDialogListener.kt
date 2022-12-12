package com.example.shoppinglistexample.ui.shoppinglist

import com.example.shoppinglistexample.data.database.entity.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClick(item: ShoppingItem)
}