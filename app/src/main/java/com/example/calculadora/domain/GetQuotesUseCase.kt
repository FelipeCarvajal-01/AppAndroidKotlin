package com.example.calculadora.domain

import com.example.calculadora.data.repositories.QuoteRepository
import com.example.calculadora.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}