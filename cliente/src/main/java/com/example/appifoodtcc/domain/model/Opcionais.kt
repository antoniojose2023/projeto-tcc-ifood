package com.example.appifoodtcc.domain.model

data class Opcionais(
    val titulo: String,
    val descricao: String,
    val preco: String,
    val imagemProduto: String = ""
)