package com.example.appifoodtcc.domain.usecase

import com.example.appifoodtcc.domain.ResultadoValidacao
import com.example.appifoodtcc.domain.model.Usuario
import com.wajahatkarim3.easyvalidation.core.view_ktx.minLength
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import com.wajahatkarim3.easyvalidation.core.view_ktx.validNumber
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator

class UseCaseAutenticacao {

    fun validacaoCadastro(usuario: Usuario): ResultadoValidacao{

        var resultadoValidacao = ResultadoValidacao()

         val nome = usuario.nome
             .validator()
             .minLength(6)
             .check()

         val email = usuario.email.validEmail()
         val senha = usuario.senha.validator()
             .minLength(6)
             .atleastOneSpecialCharacters()
             .check()

         val telefone = usuario.telefone.nonEmpty()

         if(nome){
             resultadoValidacao.nome = true
         }

         if(email){
             resultadoValidacao.email = true
         }

         if(senha){
             resultadoValidacao.senha = true
         }

         if(telefone){
             resultadoValidacao.telefone = true
         }

         return resultadoValidacao

    }

    fun validarLogin(usuario: Usuario): ResultadoValidacao{

        var resultadoValidacao = ResultadoValidacao()

        val email = usuario.email.validEmail()
        val senha = usuario.senha.validator()
            .minLength(6)
            .atleastOneSpecialCharacters()
            .check()


        if(email){
            resultadoValidacao.email = true
        }

        if(senha){
            resultadoValidacao.senha = true
        }

         return resultadoValidacao

    }

}