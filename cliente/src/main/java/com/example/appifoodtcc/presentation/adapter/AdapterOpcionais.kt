package com.example.appifoodtcc.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appifoodtcc.databinding.FragmentProdutoBinding
import com.example.appifoodtcc.databinding.ItemFiltroCategoriaBinding
import com.example.appifoodtcc.databinding.ItemRvOpcionaisProdutoBinding
import com.example.appifoodtcc.domain.model.Opcionais
import com.squareup.picasso.Picasso

class AdapterOpcionais: RecyclerView.Adapter<AdapterOpcionais.ViewHolderOpcionais>() {

    var listaOpcionais = listOf<Opcionais>()

    inner class ViewHolderOpcionais(val binding: ItemRvOpcionaisProdutoBinding): ViewHolder(binding.root){
            fun bind(opcionais: Opcionais){
                binding.tvTituloProdutoOpcionais.text = opcionais.titulo
                binding.tvDescricaoProdutoOpcionais.text = opcionais.descricao
                binding.tvPrecoProdutoOpcionais.text = opcionais.preco


                if (opcionais.imagemProduto.isNotEmpty()){
                    Picasso.get().load( opcionais.imagemProduto ).into( binding.ivProdutoOpcionais )
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOpcionais {
        val inflate = LayoutInflater.from( parent.context )
        val binding = ItemRvOpcionaisProdutoBinding.inflate( inflate, parent, false )
        return ViewHolderOpcionais( binding )
    }

    override fun getItemCount(): Int {
        return listaOpcionais.size
    }

    override fun onBindViewHolder(holder: ViewHolderOpcionais, position: Int) {
          val opcionais = listaOpcionais[position]
          holder.bind( opcionais )
    }

}