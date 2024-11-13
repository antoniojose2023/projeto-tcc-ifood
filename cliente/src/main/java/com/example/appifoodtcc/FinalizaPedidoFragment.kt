package com.example.appifoodtcc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appifoodtcc.databinding.FragmentFinalizaPedidoBinding
import com.example.appifoodtcc.databinding.FragmentHomeBinding
import com.example.appifoodtcc.databinding.FragmentProdutoBinding
import com.example.appifoodtcc.domain.model.Opcionais
import com.example.appifoodtcc.presentation.adapter.AdapterOpcionais


class FinalizaPedidoFragment : Fragment() {

    private lateinit var binding: FragmentFinalizaPedidoBinding

    val listaOpcionais = listOf(
        Opcionais(
            "item 1","trary to popular belief, Lorem Ipsum is not simply random", "40,90", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjUnCJl_eMFk29zbGdU1F5xiz768YltBzhtA&s"
        ),
        Opcionais(
            "item 2","trary to popular belief, Lorem Ipsum is not simply random", "20,90", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjUnCJl_eMFk29zbGdU1F5xiz768YltBzhtA&s"
        ),
        Opcionais(
            "item 3","trary to popular belief, Lorem Ipsum is not simply random", "50,90", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjUnCJl_eMFk29zbGdU1F5xiz768YltBzhtA&s"
        ),
        Opcionais(
            "item 4","trary to popular belief, Lorem Ipsum is not simply random", "40,90", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjUnCJl_eMFk29zbGdU1F5xiz768YltBzhtA&s"
        ),
        Opcionais(
            "item 5","trary to popular belief, Lorem Ipsum is not simply random", "10,90", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjUnCJl_eMFk29zbGdU1F5xiz768YltBzhtA&s"
        ),
        Opcionais(
            "item 6","trary to popular belief, Lorem Ipsum is not simply random", "10,90", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjUnCJl_eMFk29zbGdU1F5xiz768YltBzhtA&s"
        ),
        Opcionais(
            "item 7","trary to popular belief, Lorem Ipsum is not simply random", "10,90", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjUnCJl_eMFk29zbGdU1F5xiz768YltBzhtA&s"
        ),
        Opcionais(
            "item 8","trary to popular belief, Lorem Ipsum is not simply random", "10,90", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjUnCJl_eMFk29zbGdU1F5xiz768YltBzhtA&s"
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
        binding = FragmentFinalizaPedidoBinding.inflate( inflater, container, false )

        inicializarEventosClique()
        inicializarRecyclerViewOpcionais()

        return binding.root
    }
    private fun inicializarRecyclerViewOpcionais(){

        val adapterOpcionais = AdapterOpcionais()
        adapterOpcionais.listaOpcionais = listaOpcionais


        binding.rvProdutoFinalizaPedido.adapter = adapterOpcionais
        binding.rvProdutoFinalizaPedido.layoutManager = LinearLayoutManager(binding.root.context)


    }

    private fun inicializarEventosClique() {

        binding.imageButtonVoltarFinalizaPedido.setOnClickListener {
            findNavController().navigate( R.id.produtoFragment )
        }
    }


}