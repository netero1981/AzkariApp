package com.azkari

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AzkarAdapter(private val azkarList: List<String>) :
    RecyclerView.Adapter<AzkarAdapter.AzkarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AzkarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_azkar, parent, false)
        return AzkarViewHolder(view)
    }

    override fun onBindViewHolder(holder: AzkarViewHolder, position: Int) {
        holder.text.text = azkarList[position]
    }

    override fun getItemCount(): Int = azkarList.size

    class AzkarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.azkarText)
    }
}
