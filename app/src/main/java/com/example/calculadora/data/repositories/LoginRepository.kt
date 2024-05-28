package com.example.calculadora.data.repositories

import com.camilo.calcu.data.dto.LoginDTO
import com.example.calculadora.data.model.DataResponse
import com.example.calculadora.data.network.services.LoginService
import com.example.calculadora.data.providers.UserProvider

class LoginRepository {
    val loginService = LoginService()

    suspend fun signIn(loginDTO: LoginDTO):DataResponse{
        val response: DataResponse = loginService.signIn(loginDTO)
        if (response.status == "success"){
            if(response.data != null){
                UserProvider.userModel = response.data
            }
        }
        return response
    }
}