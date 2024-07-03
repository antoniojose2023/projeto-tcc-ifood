package com.example.appifoodtcc.domain.repository

import com.example.appifoodtcc.domain.model.Usuario

interface IRepositoryAutenticacao {
    suspend fun cadastrarUsuario(usuario: Usuario): Boolean
    suspend fun loginUsuario(usuario: Usuario): Boolean
    suspend fun verificarUsuarioLogado(): Boolean

}