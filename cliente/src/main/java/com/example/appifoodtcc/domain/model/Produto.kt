package com.example.appifoodtcc.domain.model

data class Produto (
    val titulo: String,
    val descricao: String,
    val preco: String,
    val precoDesconto: String = "",
    val imagem: String,
){
}