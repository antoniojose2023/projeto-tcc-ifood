package com.example.appifoodtcc.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appifoodtcc.R
import com.example.appifoodtcc.databinding.FragmentHomeBinding
import com.example.appifoodtcc.databinding.FragmentPedidosBinding
import com.example.appifoodtcc.domain.model.Pedido
import com.example.appifoodtcc.presentation.adapter.AdapterLojas
import com.example.appifoodtcc.presentation.adapter.AdapterPedidos


class PedidosFragment : Fragment() {

    lateinit var binding: FragmentPedidosBinding

    val pedidos = listOf(
        Pedido(
            "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg",
            "China Box",
            listOf("fanta", "pizza", "suco"),
            "sexta-feira 20 de outubro de 2024"
        ),

        Pedido(
            "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg",
            "China Box",
            listOf("suco", "pastel", "agua"),
            "segunda-feira 10 de outubro de 2024"
        ),

        Pedido(
            "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg",
            "China Box",
            listOf("suco", "pastel", "agua"),
            "segunda-feira 10 de outubro de 2024"
        ),

        Pedido(
            "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg",
            "China Box",
            listOf("suco", "pastel", "agua"),
            "segunda-feira 10 de outubro de 2024"
        ),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPedidosBinding.inflate( inflater, container, false )

        iniciarListagemUltimasLojas()

        return binding.root
    }


    private fun iniciarListagemUltimasLojas(){

        val adapterPedidos = AdapterPedidos()
        adapterPedidos.addListaPedido( pedidos )

        binding.rvPedido.adapter = adapterPedidos
        binding.rvPedido.layoutManager = LinearLayoutManager(requireContext())

    }

}