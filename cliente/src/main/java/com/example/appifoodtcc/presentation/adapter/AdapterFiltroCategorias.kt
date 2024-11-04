package com.example.appifoodtcc.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appifoodtcc.databinding.ItemFiltroCategoriaBinding
import com.example.appifoodtcc.domain.model.FiltroCategoria
import com.squareup.picasso.Picasso

class AdapterFiltroCategorias: RecyclerView.Adapter<AdapterFiltroCategorias.ViewHolderFiltroCategoias>() {

    var categorias = listOf<FiltroCategoria>()

    inner class ViewHolderFiltroCategoias(val binding: ItemFiltroCategoriaBinding): ViewHolder(binding.root){
            fun bind(categoria: FiltroCategoria){
                   binding.textTituloLojaFiltroCategoria.text = categoria.nome

                   val imageLojaFiltro = categoria.imagemLojas
                   if (imageLojaFiltro!!.isNotEmpty()){
                          Picasso.get().load( imageLojaFiltro ).into( binding.imageLojaFiltro )
                   }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFiltroCategoias {
           val inflate = LayoutInflater.from( parent.context )
           val binding = ItemFiltroCategoriaBinding.inflate( inflate, parent, false )
           return ViewHolderFiltroCategoias( binding )
    }

    override fun getItemCount(): Int {
       return categorias.size
    }

    override fun onBindViewHolder(holder: ViewHolderFiltroCategoias, position: Int) {
         val categoria = categorias[position]
         holder.bind( categoria )
    }

}



