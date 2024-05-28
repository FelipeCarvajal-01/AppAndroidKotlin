package com.example.calculadora.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camilo.calcu.data.dto.LoginDTO
import com.example.calculadora.data.model.DataResponse
import com.example.calculadora.data.model.UserModel
import com.example.calculadora.domain.PostSignInUseCase
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    private val dataResponse = MutableLiveData<DataResponse>()
    val userModel =  MutableLiveData<UserModel>()
    val message =  MutableLiveData<String?>()
    val isLoading =  MutableLiveData<Boolean>()

    var logiginUseCase = PostSignInUseCase()

    fun signIn(loginDTO: LoginDTO){
        viewModelScope.launch {
            isLoading.postValue(true)

            val resultado:DataResponse = logiginUseCase(loginDTO)
            dataResponse.postValue(resultado)

            when(resultado.status){
                "success" ->{
                    userModel.postValue(resultado.data!!)
                    Log.e("Model User", userModel.toString())
                    isLoading.postValue(false)
                }
                "invalid" ->{
                    message.postValue(resultado.message)
                    isLoading.postValue(false)
                }
                "error" ->{
                    message.postValue("Username no registrado!")
                    isLoading.postValue(false)
                }
            }
        }
    }
}