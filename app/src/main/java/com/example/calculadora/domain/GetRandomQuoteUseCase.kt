package com.example.calculadora.domain

import com.example.calculadora.data.model.QuoteModel
import com.example.calculadora.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteProvider: QuoteProvider
){
    operator fun invoke(): QuoteModel?{
        val quotes:List<QuoteModel> = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}