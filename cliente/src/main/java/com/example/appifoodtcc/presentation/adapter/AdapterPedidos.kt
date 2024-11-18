package com.example.appifoodtcc.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appifoodtcc.databinding.ItemFiltroCategoriaBinding
import com.example.appifoodtcc.databinding.ItemPedidoBinding
import com.example.appifoodtcc.domain.model.FiltroCategoria
import com.example.appifoodtcc.domain.model.Pedido
import com.squareup.picasso.Picasso

class AdapterPedidos(): RecyclerView.Adapter<AdapterPedidos.ViewHolderPedido>(){

    var pedidos = listOf<Pedido>()

    fun addListaPedido(pedidos: List<Pedido>){
           this.pedidos = pedidos
    }

    inner class ViewHolderPedido(val binding: ItemPedidoBinding): ViewHolder(binding.root){
        fun bind(pedido: Pedido){
            binding.tvDataPedido.text = pedido.dataPedido
            binding.tvNomeLojaPedido.text = pedido.nomeLoja

            var resultado = ""

            pedido.itensPedido.forEach { pedido->
               resultado += "$pedido \n"
            }

            binding.tvItensPedido.text = resultado

            val imageLojaPedido = pedido.imagemLoja
            if (imageLojaPedido!!.isNotEmpty()){
                Picasso.get().load( imageLojaPedido ).into( binding.imageLojasPedido )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPedido {
        val inflate = LayoutInflater.from( parent.context )
        val binding = ItemPedidoBinding.inflate( inflate, parent, false )
        return ViewHolderPedido( binding )
    }

    override fun getItemCount() = pedidos.size

    override fun onBindViewHolder(holder: ViewHolderPedido, position: Int) {
          val pedido = pedidos[position]
          holder.bind( pedido )
    }

}