package com.example.appifoodtcc.domain.repository

import com.example.appifoodtcc.domain.model.Usuario
import com.example.appifoodtcc.presentation.view.UIStatus

interface IRepositoryAutenticacao {
    suspend fun cadastrarUsuario(usuario: Usuario, status: (UIStatus<Boolean>)->Unit)
    suspend fun loginUsuario(usuario: Usuario, status: (UIStatus<Boolean>)->Unit)
    fun verificarUsuarioLogado(): Boolean

}