package com.example.appifoodtcc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appifoodtcc.databinding.FragmentLojaBinding
import com.example.appifoodtcc.domain.model.Produto
import com.example.appifoodtcc.presentation.adapter.AdapterProdutos


class LojaFragment : Fragment() {

    lateinit var binding : FragmentLojaBinding

    val produtosDestaque = listOf(
        Produto(
            "Lorem Ipsum",
            "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
            "24,90",
            "14,90",
            "https://renatacarbonero.com/wp-content/uploads/2021/09/hamburguer-ifood-1024x576.png"
        ),
        Produto(
         "Lorem Ipsum",
         "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
         "54,90",
         "44,90",
         "https://classic.exame.com/wp-content/uploads/2020/06/Cheese-Burger-Osso.jpg?quality=70&strip=info&w=1200"
       ),
        Produto(
            "Lorem Ipsum",
            "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
            "34,90",
            "24,90",
            "https://classic.exame.com/wp-content/uploads/2020/06/Cheese-Burger-Osso.jpg?quality=70&strip=info&w=1200"
        ),

        Produto(
            "Lorem Ipsum",
            "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
            "34,90",
            "24,90",
            "https://classic.exame.com/wp-content/uploads/2020/06/Cheese-Burger-Osso.jpg?quality=70&strip=info&w=1200"
        ),

        Produto(
            "Lorem Ipsum",
            "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
            "34,90",
            "24,90",
            "https://classic.exame.com/wp-content/uploads/2020/06/Cheese-Burger-Osso.jpg?quality=70&strip=info&w=1200"
        ),

    )


    val produtos = listOf(
        Produto(
            "Lorem Ipsum",
            "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
            "24,90",
            "",
            "https://classic.exame.com/wp-content/uploads/2020/06/Cheese-Burger-Osso.jpg?quality=70&strip=info&w=1200"
        ),
        Produto(
            "Lorem Ipsum",
            "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
            "54,90",
            "",
            "https://classic.exame.com/wp-content/uploads/2020/06/Cheese-Burger-Osso.jpg?quality=70&strip=info&w=1200"
        ),
        Produto(
            "Lorem Ipsum",
            "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
            "34,90",
            "24,90",
            "https://classic.exame.com/wp-content/uploads/2020/06/Cheese-Burger-Osso.jpg?quality=70&strip=info&w=1200"
        ),

        Produto(
            "Lorem Ipsum",
            "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
            "34,90",
            "",
            "https://classic.exame.com/wp-content/uploads/2020/06/Cheese-Burger-Osso.jpg?quality=70&strip=info&w=1200"
        ),

        Produto(
            "Lorem Ipsum",
            "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's",
            "",
            "24,90",
            "https://classic.exame.com/wp-content/uploads/2020/06/Cheese-Burger-Osso.jpg?quality=70&strip=info&w=1200"
        ),

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLojaBinding.inflate( inflater, container, false )

        inicializarEventosClique()
        inicializarRecyclerViewProdutos()
        inicializarRecyclerViewProdutosDestaque()

        return binding.root
    }

    private fun inicializarEventosClique() {
          binding.imageButtonVoltar.setOnClickListener {
                findNavController().navigate( R.id.homeFragment )
          }
    }

    private fun inicializarRecyclerViewProdutos(){
           val orientacao = RecyclerView.VERTICAL

           val adapterProduto = AdapterProdutos(orientacao){
                 findNavController().navigate( R.id.produtoFragment )
           }

           adapterProduto.produtos = produtos.toMutableList()

           binding.rvProdutos.adapter = adapterProduto
           binding.rvProdutos.layoutManager = LinearLayoutManager(requireContext(), orientacao, false)

    }

    private fun inicializarRecyclerViewProdutosDestaque(){

        val orientacao = RecyclerView.HORIZONTAL

        val adapterProduto = AdapterProdutos(orientacao){
            findNavController().navigate( R.id.produtoFragment )
        }

        adapterProduto.produtos = produtosDestaque.toMutableList()

        binding.rvProdutosDestaque.adapter = adapterProduto
        binding.rvProdutosDestaque.layoutManager = LinearLayoutManager(requireContext(), orientacao, false)

    }

}