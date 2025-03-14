package com.example.animationtask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemText: TextView = itemView.findViewById(R.id.itemText)
        private val arrowButton: ImageButton = itemView.findViewById(R.id.arrowButton)
        private val itemContainer: LinearLayout = itemView.findViewById(R.id.itemContainer)

        fun bind(item: Item) {
            itemText.text = item.text
            arrowButton.setOnClickListener {
                item.isArrowRotated = !item.isArrowRotated
                rotateArrow(arrowButton, item.isArrowRotated)
            }
            itemContainer.setOnClickListener {
                item.isExpanded = !item.isExpanded
                expandItem(itemContainer, item.isExpanded)
            }
            rotateArrow(arrowButton, item.isArrowRotated)
            expandItem(itemContainer, item.isExpanded)
        }

        private fun rotateArrow(view: View, isRotated: Boolean) {
            val rotation = if (isRotated) 180f else 0f
            view.animate().rotation(rotation).setDuration(300).start()
        }

        private fun expandItem(view: View, isExpanded: Boolean) {
            val scale = if (isExpanded) 0.8f else 1f
            view.animate().scaleX(scale).scaleY(scale).setDuration(300).start()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

data class Item(
    val text: String,
    var isExpanded: Boolean = false,
    var isArrowRotated: Boolean = false
)