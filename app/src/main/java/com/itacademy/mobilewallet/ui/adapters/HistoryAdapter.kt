package com.itacademy.mobilewallet.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.mobilewallet.R
import com.itacademy.mobilewallet.ui.entities.Payments

class HistoryAdapter(private val array: Array<Payments>, val context: FragmentActivity): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.text_history)
        val sum: TextView = view.findViewById(R.id.value_history)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history_payments, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = item.nameTransaction
        holder.sum.text = item.sumTransaction.toString()
    }

    override fun getItemCount(): Int {
        return array.size
    }
}