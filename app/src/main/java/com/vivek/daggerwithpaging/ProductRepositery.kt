package com.vivek.daggerwithpaging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import javax.inject.Inject

class ProductRepositery  @Inject constructor(private val apiService: APIService) {

    fun getProductList() = Pager(config = PagingConfig(pageSize = 20, maxSize = 100), pagingSourceFactory = { ProductPagingSource(apiService) }).liveData
}