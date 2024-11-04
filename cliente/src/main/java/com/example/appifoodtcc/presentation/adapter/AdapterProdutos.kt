package com.example.appifoodtcc.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appifoodtcc.databinding.ItemProdutoBinding
import com.example.appifoodtcc.databinding.ItemProdutoDestaqueBinding
import com.example.appifoodtcc.databinding.ItemRvLojasBinding
import com.example.appifoodtcc.databinding.ItemRvUltimasLojasBinding
import com.example.appifoodtcc.domain.model.Loja
import com.example.appifoodtcc.domain.model.Produto
import com.squareup.picasso.Picasso

class AdapterProdutos(
    val orientacao: Int,
    private val onClick: () -> Unit
): RecyclerView.Adapter<ViewHolder>() {

    var produtos = mutableListOf<Produto>()

    inner class ViewHolderProdutos(val binding: ItemProdutoBinding ): ViewHolder(binding.root){
        fun bind(produto: Produto){
            binding.textTituloProduto.text = produto.titulo
            binding.textDescricaoProduto.text = produto.descricao
            binding.textValorProduto.text = produto.preco

            binding.itemViewProduto.setOnClickListener {
                  onClick()
            }

            if(produto.imagem!!.isNotEmpty()){
                  Picasso.get().load( produto.imagem ).into( binding.ivProduto )
            }
        }
    }

    inner class ViewHolderProdutosDestaque(val binding: ItemProdutoDestaqueBinding ): ViewHolder(binding.root){
        fun bind(produto: Produto){
            binding.textDescricaoProdutoDestaque.text = produto.titulo

            if(binding.textPrecoComDesconto.text.isNotEmpty()){
                 binding.textPrecoSemDesconto.text = produto.preco
                 binding.textPrecoSemDesconto.text = produto.precoDesconto
            }else{
                 binding.textPrecoSemDesconto.text = produto.preco
            }


            binding.itemViewProdutoDestaque.setOnClickListener {
                onClick()
            }

            if(produto.imagem!!.isNotEmpty()){
                Picasso.get().load( produto.imagem ).into( binding.ivProdutoDestaque )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val inflater = LayoutInflater.from( parent.context )

        val viewHolder = if(orientacao == RecyclerView.VERTICAL){
             val itemProdutoBinding = ItemProdutoBinding.inflate( inflater, parent, false )
             return ViewHolderProdutos( itemProdutoBinding )
         }else{
             val itemProdutoDestaqueBinding = ItemProdutoDestaqueBinding.inflate( inflater, parent, false )
             return ViewHolderProdutosDestaque( itemProdutoDestaqueBinding )
         }

        return viewHolder
    }

    override fun getItemCount() = produtos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val produto = produtos[position]
         when(holder){
             is ViewHolderProdutos ->{
                   holder.bind( produto )

             }
             is ViewHolderProdutosDestaque ->{
                  holder.bind( produto )

             }
         }
    }
}