package com.example.appifoodtcc.presentation.view

sealed class UIStatus<out T>{
    class Sucesso<T>(val parametro: T): UIStatus<T>()
    class Erro(val mensagem: String): UIStatus<Nothing>()
}

