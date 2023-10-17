package com.example.practiceapi.views.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceapi.model.categories.ResponseCategory
import com.example.practiceapi.model.products.Product
import com.example.practiceapi.model.products.ResponseProduct
import com.example.practiceapi.repository.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repo: ProductRepo) : ViewModel() {
    private val _data = MutableLiveData<Response<ResponseCategory>>()
    val responsedata : LiveData<Response<ResponseCategory>> = _data

    fun allCategory(){
        viewModelScope.launch {
            val data = repo.allCategory()
            _data.postValue(data)
        }
    }





}