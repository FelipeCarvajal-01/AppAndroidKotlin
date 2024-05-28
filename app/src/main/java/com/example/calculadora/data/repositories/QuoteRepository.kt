package com.example.calculadora.data.repositories

import com.example.calculadora.data.model.QuoteModel
import com.example.calculadora.data.model.QuoteProvider
import com.example.calculadora.data.network.services.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
){
    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}