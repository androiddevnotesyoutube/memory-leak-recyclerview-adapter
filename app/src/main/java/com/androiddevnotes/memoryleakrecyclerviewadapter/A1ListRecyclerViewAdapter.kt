package com.androiddevnotes.memoryleakrecyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androiddevnotes.memoryleakrecyclerviewadapter.databinding.ItemListA1Binding

/**
 * Simple implementation of RecyclerView adapter with item click
 * listener
 *
 * @constructor Takes in a item click listener interface
 */
class A1ListRecyclerViewAdapter(
    private val listener: OnA1ListItemClickedListener
) :
    RecyclerView.Adapter<A1ListRecyclerViewAdapter.A1HolderViewHolder>() {

    // List of items to be shown in RecyclerView
    private val items = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): A1HolderViewHolder {
        val binding =
            ItemListA1Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return A1HolderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: A1HolderViewHolder, position: Int) {
        holder.bind(items[position])
    }

    /**
     * RecyclerView ViewHolder
     *
     * @property binding For ViewBinding
     */
    inner class A1HolderViewHolder(private val binding: ItemListA1Binding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onA1ListItemClicked()
                }
            }
        }

        /**
         * Binds views to data
         *
         * @param currentItem Current item in a list of items
         */
        fun bind(currentItem: String?) {
            binding.a1ItemTextView.text = currentItem
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * Item click listener interface by which clicks on items in a
     * RecyclerView would be recorded
     */
    interface OnA1ListItemClickedListener {
        fun onA1ListItemClicked()
    }
}