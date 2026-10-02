package com.example.loadinggames.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    // LOGIN
    @POST("api/auth/login")
    fun login(
        @Body request: LoginRequest
    ): Call<LoginResponse>


    // CADASTRO
    @POST("api/auth/cadastro")
    fun cadastrar(
        @Body request: CadastroRequest
    ): Call<CadastroResponse>
}