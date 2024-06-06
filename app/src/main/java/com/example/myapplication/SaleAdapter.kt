package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SaleAdapter(private val sales: List<Sale>) : RecyclerView.Adapter<SaleAdapter.SaleViewHolder>() {

    inner class SaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTextView: TextView = itemView.findViewById(R.id.tvItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_sale, parent, false)
        return SaleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SaleViewHolder, position: Int) {
        val currentItem = sales[position]
        val saleDetails = "Продавец: ${currentItem.seller}, Наименование: ${currentItem.itemName}, " +
                "Количество: ${currentItem.quantity}, Цена: ${currentItem.price}, " +
                "Дата продажи: ${currentItem.saleDate}"
        holder.itemTextView.text = saleDetails
    }

    override fun getItemCount() = sales.size
}
