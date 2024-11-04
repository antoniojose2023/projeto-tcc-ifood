package com.example.appifoodtcc.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appifoodtcc.databinding.ItemRvLojasBinding
import com.example.appifoodtcc.databinding.ItemRvUltimasLojasBinding
import com.example.appifoodtcc.domain.model.Loja
import com.squareup.picasso.Picasso

class AdapterLojas(val orientacao: Int, private val onClick: () -> Unit): RecyclerView.Adapter<ViewHolder>() {

    var lojas = mutableListOf<Loja>()


    inner class ViewHolderLojas(val binding: ItemRvLojasBinding ): ViewHolder(binding.root){
        fun bind(loja: Loja){
            binding.textTituloLojas.text = loja.nome
            binding.textLancheLojas.text = loja.descricao

            binding.itemLayoutLojas.setOnClickListener {
                  onClick()
            }

            if(loja.logo!!.isNotEmpty()){
                  Picasso.get().load( loja.logo ).into( binding.imageLojas )
            }
        }
    }

    inner class ViewHolderUltimasLojas(val binding: ItemRvUltimasLojasBinding ): ViewHolder(binding.root){
        fun bind(loja: Loja){
            binding.textTituloUltimaLoja.text = loja.nome

            binding.itemLayoutUltimasLojas.setOnClickListener {
                onClick()
            }

            if(loja.logo!!.isNotEmpty()){
                Picasso.get().load( loja.logo ).into( binding.imageUltimaLoja )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val inflater = LayoutInflater.from( parent.context )

        val viewHolder = if(orientacao == RecyclerView.VERTICAL){
             val itemRvLojasBinding = ItemRvLojasBinding.inflate( inflater, parent, false )
             return ViewHolderLojas( itemRvLojasBinding )
         }else{
             val itemRvUltimasLojasBinding = ItemRvUltimasLojasBinding.inflate( inflater, parent, false )
             return ViewHolderUltimasLojas( itemRvUltimasLojasBinding )
         }

        return viewHolder
    }

    override fun getItemCount() = lojas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val loja = lojas[position]
         when(holder){
             is ViewHolderLojas ->{
                   holder.bind( loja )

             }
             is ViewHolderUltimasLojas ->{
                  holder.bind( loja )

             }
         }
    }
}