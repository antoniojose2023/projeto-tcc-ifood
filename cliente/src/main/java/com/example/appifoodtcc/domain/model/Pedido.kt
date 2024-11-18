package com.example.appifoodtcc.domain.model

data class Pedido(
     val imagemLoja: String,
     val nomeLoja: String,
     val itensPedido: List<String>,
     val dataPedido: String,
)