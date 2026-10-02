package com.example.loadinggames.api

data class LoginResponse(
    val mensagem: String,
    val usuario: UsuarioResponse?
)

data class UsuarioResponse(
    val id: Int,
    val nome: String,
    val nomeUsuario: String,
    val email: String,
    val fotoPerfilUrl: String?,
    val tipoUsuario: String
)