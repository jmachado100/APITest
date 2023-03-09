package com.example.apitest


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class ListAdapter<T> (
    @LayoutRes private val layoutRes: Int,
    private val items: List<T>,
    private val onBind: (View, T) -> Unit,
    private val onClick: (View, T) -> Unit
): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(layoutView: View) : RecyclerView.ViewHolder(layoutView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val view = holder.itemView

        onBind(view, item)

        view.setOnClickListener {
            onClick(it, item)
        }
    }

    override fun getItemCount() = items.size


}