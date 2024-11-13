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
import com.example.appifoodtcc.databinding.FragmentBuscaBinding
import com.example.appifoodtcc.databinding.FragmentHomeBinding
import com.example.appifoodtcc.domain.model.Loja
import com.example.appifoodtcc.presentation.adapter.AdapterLojas


class BuscaFragment : Fragment() {
    private lateinit var binding: FragmentBuscaBinding

    val lojas = mutableListOf(
        Loja("chinaBox", "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg", "loja 01"),
        Loja("chinaBox 1", "https://static.vecteezy.com/ti/vetor-gratis/p3/9259370-simples-e-limpo-restaurante-logo-modelo-design-em-cor-marrom-adequado-para-restaurantes-cafe-lojas-barracas-comida-menus-etc-gratis-vetor.jpg", "loja 02"),
        Loja("chinaBox 2", "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg", "loja 03"),
        Loja("chinaBox 3", "hhttps://static.vecteezy.com/ti/vetor-gratis/p3/9259370-simples-e-limpo-restaurante-logo-modelo-design-em-cor-marrom-adequado-para-restaurantes-cafe-lojas-barracas-comida-menus-etc-gratis-vetor.jpg", "loja 04"),
        Loja("chinaBox 4", "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg", "loja 04"),
        Loja("chinaBox 5" , "https://static.vecteezy.com/ti/vetor-gratis/p3/9259370-simples-e-limpo-restaurante-logo-modelo-design-em-cor-marrom-adequado-para-restaurantes-cafe-lojas-barracas-comida-menus-etc-gratis-vetor.jpg", "loja 04"),
        Loja("chinaBox 6", "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg", "loja 04"),
        Loja("chinaBox 7", "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg", "loja 05"),
        Loja("chinaBox 8", "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg", "loja 06"),
        Loja("chinaBox 69", "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg", "loja 07"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentBuscaBinding.inflate( inflater, container, false )

        iniciarListagemLojas()


        return binding.root
    }

    private fun iniciarListagemLojas(){
        val orientation = RecyclerView.VERTICAL
        val adapterLojas = AdapterLojas(orientation){
            val navController = findNavController()
            navController.navigate( R.id.lojaFragment )
        }
        adapterLojas.lojas = lojas

        binding.rvLojaBusca.adapter = adapterLojas
        binding.rvLojaBusca.layoutManager = LinearLayoutManager(context, orientation, false)

    }


}