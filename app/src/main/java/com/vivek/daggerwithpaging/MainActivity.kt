package com.vivek.daggerwithpaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vivek.daggerwithpaging.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mBinding:ActivityMainBinding
    lateinit var productViewModel: ProductViewModel
    //lateinit var adapter: Adapter
    lateinit var adapter:ProductListAdapter
    //lateinit var mProductList:MutableList<ProductList.Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        //mProductList = mutableListOf()
        adapter = ProductListAdapter()

        mBinding.ProductListRecylerView.layoutManager = LinearLayoutManager(this)
        mBinding.ProductListRecylerView.setHasFixedSize(true)
        mBinding.ProductListRecylerView.adapter = adapter

        productViewModel.list.observe(this, Observer {
            adapter.submitData(lifecycle, it)
        })

    }
}