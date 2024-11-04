package com.example.appifoodtcc.domain.repository

import com.example.appifoodtcc.domain.model.Usuario
import com.example.appifoodtcc.presentation.view.UIStatus
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RepositoryAutenticacaoImpl @Inject constructor (
    private val firebaseAuth: FirebaseAuth
): IRepositoryAutenticacao {
    override suspend fun cadastrarUsuario(usuario: Usuario, status: (UIStatus<Boolean>) -> Unit) {
        try {
            val retorno = firebaseAuth.createUserWithEmailAndPassword(
                usuario.email, usuario.senha
            ).await() != null

            if(retorno){
                 status.invoke(UIStatus.Sucesso(true))
            }

        }catch (ex: FirebaseAuthWeakPasswordException){
                status.invoke(UIStatus.Erro("Senha fraca"))
        }catch (ex: FirebaseAuthInvalidCredentialsException){
                status.invoke(UIStatus.Erro("Email não é valido"))
        }catch (ex: FirebaseAuthUserCollisionException){
               status.invoke(UIStatus.Erro("Este usuário já existe"))
        }catch (ex: Exception){
               status.invoke(UIStatus.Erro("Tente novamente."))
        }

    }

    override suspend fun loginUsuario(usuario: Usuario, status: (UIStatus<Boolean>) -> Unit) {
        try {
            val retorno = firebaseAuth.signInWithEmailAndPassword(
                usuario.email, usuario.senha
            ).await() != null

            if(retorno){
                status.invoke(UIStatus.Sucesso( parametro = true))
            }
        }catch (ex: FirebaseAuthInvalidUserException){
              status.invoke( UIStatus.Erro("Usuário inválido") )
        }catch (ex: FirebaseAuthInvalidCredentialsException){
              status.invoke(UIStatus.Erro("Senha inválida"))
        }catch (ex: Exception){
             status.invoke(UIStatus.Erro("Tente novamente."))
        }
    }

    override fun verificarUsuarioLogado(): Boolean {
        return firebaseAuth.currentUser != null
    }
}