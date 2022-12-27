package com.example.superdomarket.ui.products_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superdomarket.data.Product
import com.example.superdomarket.data.ProductsProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val provider: ProductsProvider) : ViewModel() {

    private val products = mutableListOf<Product>()
    private val _state =  MutableStateFlow<List<Product>>(products)
    val state get() = _state.asStateFlow()


    fun connect() {
        viewModelScope.launch {
            provider.connect().onEach { product ->
                _state.value = products.apply {
                    add(product)
                }


            }.flowOn(Dispatchers.Main)
        }

    }
}