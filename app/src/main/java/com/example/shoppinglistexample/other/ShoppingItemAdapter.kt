package com.example.shoppinglistexample.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistexample.R
import com.example.shoppinglistexample.data.database.entity.ShoppingItem
import com.example.shoppinglistexample.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val shoppingItem = items[position]
        holder.itemView.textViewName.text = shoppingItem.name
        holder.itemView.textViewAmount.text = "${shoppingItem.amount}"

        holder.itemView.imageViewDelete.setOnClickListener {
            viewModel.delete(shoppingItem)
        }

        holder.itemView.imageViewPlus.setOnClickListener {
            shoppingItem.amount++
            viewModel.upsert(shoppingItem)
        }

        holder.itemView.imageViewMinus.setOnClickListener {
            if (shoppingItem.amount > 0){
                shoppingItem.amount--
                viewModel.upsert(shoppingItem)
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}