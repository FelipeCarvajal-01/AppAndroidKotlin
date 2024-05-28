package com.example.calculadora.domain

import com.camilo.calcu.data.dto.LoginDTO
import com.example.calculadora.data.model.DataResponse
import com.example.calculadora.data.repositories.LoginRepository

class PostSignInUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(loginDTO: LoginDTO): DataResponse{
        return repository.signIn(loginDTO)
    }
}