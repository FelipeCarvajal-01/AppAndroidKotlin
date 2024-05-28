package com.example.calculadora.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculadora.data.model.QuoteModel
import com.example.calculadora.domain.GetQuotesUseCase
import com.example.calculadora.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
):ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel?>()
    // Para mostrar el loading de carga
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result:List<QuoteModel>? = getQuotesUseCase()

            if (!result.isNullOrEmpty()){
                isLoading.postValue(false)
                quoteModel.postValue(result[0])
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }
}
