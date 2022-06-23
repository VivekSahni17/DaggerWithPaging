package com.vivek.daggerwithpaging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repositery: ProductRepositery):ViewModel() {
    val list = repositery.getProductList().cachedIn(viewModelScope)
}