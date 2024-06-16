package com.example.appifoodtcc

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appifoodtcc.databinding.ActivityLoginBinding
import com.example.appifoodtcc.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        listeners()

    }

    private fun listeners() {

        binding.txtCadastrarLogin.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

    }
}