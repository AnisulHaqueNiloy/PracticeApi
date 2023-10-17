package com.example.practiceapi.views.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceapi.model.login.RequestLogin
import com.example.practiceapi.model.login.ResponseLogin
import com.example.practiceapi.repository.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: AuthRepo) : ViewModel(){

    private val _data = MutableLiveData<Response<ResponseLogin>>()
    val responsedata : LiveData<Response<ResponseLogin>> = _data

    fun login(request: RequestLogin){
        viewModelScope.launch {
            val data = repo.login(request)
            _data.postValue(data)


        }

    }

}