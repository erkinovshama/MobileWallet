package com.itacademy.mobilewallet.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.mobilewallet.R
import com.itacademy.mobilewallet.ui.entities.Category
import com.itacademy.mobilewallet.ui.fragments.HomeFragmentDirections

class CategoryAdapter(private val array: Array<Category>, val context: FragmentActivity): RecyclerView.Adapter<CategoryAdapter.ViewHolder> (){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = item.nameCategory
        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToServicesFragment(item.idCategory!!))
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}