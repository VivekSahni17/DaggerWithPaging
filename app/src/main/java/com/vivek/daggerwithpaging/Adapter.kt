package com.vivek.daggerwithpaging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vivek.daggerwithpaging.databinding.ContaintItemBinding
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.withContext

class Adapter(private val mList:MutableList<ProductList.Product>) : PagingDataAdapter<ProductList.Product, Adapter.ViewHolder>(COMPARATOR) {
     //var mList:MutableList<ProductList.Product> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
         val mBinding = ContaintItemBinding.inflate(inflater)
        return ViewHolder(mBinding)
    }

    //override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(mList[position])

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        with(holder){
            with(mList[position]){
                mBinding.name.text = brand
                Glide.with(holder.itemView.context).load(thumbnail).into(mBinding.img)

            }
        }
    }



    override fun getItemCount() = mList.size

    inner class ViewHolder(val mBinding: ContaintItemBinding):RecyclerView.ViewHolder(mBinding.root){

//     class ViewHolder(private val mBinding:ContaintItemBinding):RecyclerView.ViewHolder(mBinding.root){
//      fun bind(item:ProductList.Product){
//        mBinding.name.text = item.brand
//          val img = item.thumbnail
//          Glide.with(itemView.context).load(img).centerCrop().into(mBinding.img)
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