package com.example.practiceapi.views.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceapi.model.products.Product
import com.example.practiceapi.model.products.ResponseProduct
import com.example.practiceapi.repository.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repo: ProductRepo) : ViewModel() {
    private val _data = MutableLiveData<Response<ResponseProduct>>()
    val responsedata : LiveData<Response<ResponseProduct>> = _data

    fun allProduct(){
        viewModelScope.launch {
            val data = repo.allProduct()
            _data.postValue(data)
        }
    }

    private val _dt = MutableLiveData<Response<Product>>()
    val responsedt : LiveData<Response<Product>> = _dt

    fun product(id: Int) {
        viewModelScope.launch {
            val data = repo.product(id)
            _dt.postValue(data)
        }
    }



}