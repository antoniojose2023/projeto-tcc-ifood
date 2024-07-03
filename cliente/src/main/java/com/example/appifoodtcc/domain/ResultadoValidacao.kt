package com.example.appifoodtcc.domain

data class ResultadoValidacao(
    var nome: Boolean = false,
    var email: Boolean = false,
    var senha: Boolean = false,
    var telefone: Boolean = false
){

    val sucessoValicacaoCadastro : Boolean
        get() = nome  && email  && senha  && telefone

    val sucessoValicacaoLogin : Boolean
        get() =  email  && senha
}