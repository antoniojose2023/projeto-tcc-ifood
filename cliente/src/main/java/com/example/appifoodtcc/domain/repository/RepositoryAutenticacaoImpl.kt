package com.example.appifoodtcc.domain.repository

import com.example.appifoodtcc.domain.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RepositoryAutenticacaoImpl @Inject constructor (
    private val firebaseAuth: FirebaseAuth
): IRepositoryAutenticacao {
    override suspend fun cadastrarUsuario(usuario: Usuario): Boolean {
        return firebaseAuth.createUserWithEmailAndPassword(
            usuario.email, usuario.senha
        ).await() != null
    }

    override suspend fun loginUsuario(usuario: Usuario): Boolean {
        return firebaseAuth.signInWithEmailAndPassword(
            usuario.email, usuario.senha
        ).await() != null
    }

    override suspend fun verificarUsuarioLogado(): Boolean {
        return firebaseAuth.currentUser != null
    }
}