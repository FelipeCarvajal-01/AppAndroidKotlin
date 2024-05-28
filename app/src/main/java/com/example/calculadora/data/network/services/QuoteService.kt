package com.example.calculadora.data.network.services

import com.example.calculadora.data.model.QuoteModel
import com.example.calculadora.data.network.clients.QuoteApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val api:QuoteApiClient
){

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response: Response<List<QuoteModel>> = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}