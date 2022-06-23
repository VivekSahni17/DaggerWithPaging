package com.vivek.daggerwithpaging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.lang.Exception

class ProductPagingSource(private val apiService: APIService):PagingSource<Int,ProductList.Product>() {
    override fun getRefreshKey(state: PagingState<Int, ProductList.Product>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductList.Product> {
        return try {
            val position = params.key ?: 1
            val response = apiService.getProductList(position)

            return LoadResult.Page(
                data = response.products,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.total) null else position + 1)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    }
