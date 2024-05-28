package com.example.calculadora.data.network.clients

import com.camilo.calcu.data.dto.LoginDTO
import com.example.calculadora.data.model.DataResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiClient {
    @POST("sign_in")
    suspend fun signIn(@Body loginDTO: LoginDTO): Response<DataResponse>
    
}