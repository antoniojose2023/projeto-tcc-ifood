package com.example.appifoodtcc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appifoodtcc.databinding.ActivityCadastroBinding
import com.example.appifoodtcc.databinding.ActivityLoginBinding

class CadastroActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCadastroBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        inicializarComponentes()

    }

    private fun inicializarComponentes() {

        val toobar = binding.inlcudeToolbar.materialToolbar
        setSupportActionBar( toobar )

        supportActionBar?.apply {
              title = "Cadastro Usuário"
              setDisplayHomeAsUpEnabled(true)
        }


    }
}