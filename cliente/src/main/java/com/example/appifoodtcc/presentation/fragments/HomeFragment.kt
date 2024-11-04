package com.example.appifoodtcc.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.ActionMenuView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.appifoodtcc.R
import com.example.appifoodtcc.databinding.FragmentHomeBinding
import com.example.appifoodtcc.domain.model.FiltroCategoria
import com.example.appifoodtcc.domain.model.Loja
import com.example.appifoodtcc.presentation.adapter.AdapterFiltroCategorias
import com.example.appifoodtcc.presentation.adapter.AdapterLojas
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class HomeFragment : Fragment() {

     lateinit var binding: FragmentHomeBinding

     val lojas = mutableListOf(
         Loja("chinaBox", "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg", "loja 01"),
         Loja("chinaBox 1", "https://static.vecteezy.com/ti/vetor-gratis/p3/9259370-simples-e-limpo-restaurante-logo-modelo-design-em-cor-marrom-adequado-para-restaurantes-cafe-lojas-barracas-comida-menus-etc-gratis-vetor.jpg", "loja 02"),
         Loja("chinaBox 2", "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg", "loja 03"),
         Loja("chinaBox 3", "hhttps://static.vecteezy.com/ti/vetor-gratis/p3/9259370-simples-e-limpo-restaurante-logo-modelo-design-em-cor-marrom-adequado-para-restaurantes-cafe-lojas-barracas-comida-menus-etc-gratis-vetor.jpg", "loja 04"),
         Loja("chinaBox 4", "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg", "loja 04"),
         Loja("chinaBox 5" , "https://static.vecteezy.com/ti/vetor-gratis/p3/9259370-simples-e-limpo-restaurante-logo-modelo-design-em-cor-marrom-adequado-para-restaurantes-cafe-lojas-barracas-comida-menus-etc-gratis-vetor.jpg", "loja 04"),
         Loja("chinaBox 6", "https://play-lh.googleusercontent.com/mHUaPq-EwnR74PaP7if9N5lEZzzNxvnXk1FFBaU5hE2mwgOzg7qkYGh4UjoOxBiQzg", "loja 04"),
     )

    private val listaFiltrosCategorias = listOf(
        FiltroCategoria("Restaurantes", "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Restaurantes3_vTNE.png?imwidth=256"),
        FiltroCategoria("Mercado", "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Mercados_SMx3.png?imwidth=256"),
        FiltroCategoria("Farmácia", "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Farmacia_4vdM.png?imwidth=256"),
        FiltroCategoria("Pet", "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Pet_NsoQ.png?imwidth=256"),
        FiltroCategoria("Express", "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Expressgrid1_8jHT.png?imwidth=256"),
        FiltroCategoria("Bebidas", "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Bebidas_X9kU.png?imwidth=256"),
        FiltroCategoria("Shopping", "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/floreseperfume_LOhx.png?imwidth=256"),
        FiltroCategoria("Gourmet", "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Gourmet_uke7.png?imwidth=256"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate( inflater, container, false )

        iniciarListagemFiltroCategorias()
        iniciarListagemLojas()
        iniciarListagemUltimasLojas()
        inicializarChipOrdencacap()
        inicializarSlider()

        val menu = binding.materialToolbar2.menu.findItem(R.id.menu_notificacao)
        val layout = menu.actionView!!.findViewById<ConstraintLayout>(R.id.layoutItemMenu)

        val textNotificacao = layout.getViewById(R.id.txtNotificacao) as TextView
        textNotificacao.text = "3+"

        return binding.root
    }


    private fun iniciarListagemLojas(){
        val orientation = RecyclerView.VERTICAL
        val adapterLojas = AdapterLojas(orientation){
              val navController = findNavController()
              navController.navigate( R.id.lojaFragment )
        }
        adapterLojas.lojas = lojas


        binding.rvLojas.adapter = adapterLojas
        binding.rvLojas.layoutManager = LinearLayoutManager(context, orientation, false)

    }

    private fun iniciarListagemUltimasLojas(){
        val orientation = RecyclerView.HORIZONTAL
        val adapterLojas = AdapterLojas(orientation){
            val navController = findNavController()
            navController.navigate( R.id.lojaFragment )
        }
        adapterLojas.lojas = lojas


        binding.rvUltimasLojas.adapter = adapterLojas
        binding.rvUltimasLojas.layoutManager = LinearLayoutManager(context, orientation, false)

    }

    private fun iniciarListagemFiltroCategorias(){
            val adapterFiltrocategoria = AdapterFiltroCategorias()
            adapterFiltrocategoria.categorias = listaFiltrosCategorias

            binding.rvFiltroCategoria.adapter = adapterFiltrocategoria
            binding.rvFiltroCategoria.layoutManager = GridLayoutManager(requireContext(), 4)

    }

    private fun inicializarSlider(){

          val imageList = arrayListOf<SlideModel>()

          imageList.add(
              SlideModel(imageUrl = "https://static.ifood-static.com.br/image/upload/t_high,q_100/webapp/landing/landing-banner-1.png", scaleType = ScaleTypes.CENTER_CROP )
          )

          imageList.add(
              SlideModel(imageUrl = "https://static.ifood-static.com.br/image/upload/t_high,q_100/webapp/landing/landing-banner-2.png", scaleType = ScaleTypes.CENTER_CROP )
          )

          imageList.add(
              SlideModel(imageUrl = "https://static.ifood-static.com.br/image/upload/t_high,q_100/webapp/landing/landing-banner-3.png", scaleType = ScaleTypes.CENTER_CROP )
          )

          binding.imageSlider.setImageList( imageList )

    }

    private fun inicializarChipOrdencacap(){

        val chipEntregaGratis = binding.chipEntregaGratis.isCheckable
        val chipParaRetirada = binding.chipParaRetirada.isCheckable

        binding.chipOrdenacao.setOnClickListener {

             val itens = arrayOf("Ordenção padrão", "Crescente", "Descrecente")

              MaterialAlertDialogBuilder(requireContext())
                  .setTitle("Ordenação")
                  .setItems(itens){ _, position->

                      val itemSelecionado = itens[position]

                      if(position == 0){
                           binding.chipOrdenacao.text = "Padrão"
                      }else{
                           binding.chipOrdenacao.text = itemSelecionado
                      }

                  }
                  .create()
                  .show()

        }

    }


}