package com.vivek.daggerwithpaging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ProductListAdapter : PagingDataAdapter<ProductList.Product, ProductListAdapter.ViewHolder>(COMPARATOR) {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val name: TextView = itemView.findViewById(R.id.name)
            val image: ImageView = itemView.findViewById(R.id.img)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = getItem(position)
            if (item != null) {
                holder.name.text = item.brand
                val phone =item.thumbnail
                Glide.with(holder.itemView.context).load(phone).centerCrop().into(holder.image)

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.containt_item, parent, false)
            return ViewHolder(view)
        }

        companion object {
            private val COMPARATOR = object : DiffUtil.ItemCallback<ProductList.Product>() {
                override fun areItemsTheSame(oldItem: ProductList.Product, newItem: ProductList.Product): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: ProductList.Product, newItem: ProductList.Product): Boolean {
                    return oldItem == newItem
                }
            }
        }
}