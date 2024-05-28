package com.example.calculadora.domain

import com.example.calculadora.data.repositories.QuoteRepository
import com.example.calculadora.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository:QuoteRepository
){

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}