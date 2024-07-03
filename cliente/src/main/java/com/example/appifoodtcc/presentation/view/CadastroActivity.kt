package com.example.appifoodtcc.presentation.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.appifoodtcc.R
import com.example.appifoodtcc.databinding.ActivityCadastroBinding
import com.example.appifoodtcc.domain.model.Usuario
import com.example.appifoodtcc.presentation.ViewModelAutenticacao
import com.example.core.ExibirAlertDialogCarregamento
import com.example.core.MostrarMensagem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CadastroActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCadastroBinding.inflate(layoutInflater)
    }
    private val viewModelAutenticacao: ViewModelAutenticacao by viewModels()

    private lateinit var exibirAlertDialogCarregamento : ExibirAlertDialogCarregamento

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        exibirAlertDialogCarregamento = ExibirAlertDialogCarregamento(this)

        inicializarToolbar()
        inicialiazarClicks()
        inicialiazarListernes()


    }

    private fun inicialiazarClicks() {

        with( binding ){
            btCadastrar.setOnClickListener {
                val nome = editNomeCadastro.text.toString()
                val email = editEmailCadastro.text.toString()
                val senha = editSenhaCadastro.text.toString()
                val fone = editFoneCadastro.text.toString()

                val usuario = Usuario( nome, email, senha, fone)
                viewModelAutenticacao.cadastrarUsuario( usuario )
            }

        }

    }

    private fun inicialiazarListernes() {

        viewModelAutenticacao.resultadoValidacao.observe(this){ resultadoValicao ->
                with(binding){
                    if (resultadoValicao.nome){   editNomeCadastro.error = null   }else{ editNomeCadastro.error =  getString(R.string.erro_nome)}
                    if (resultadoValicao.email){   editEmailCadastro.error = null   }else{ editEmailCadastro.error =  R.string.erro_email.toString()}
                    if (resultadoValicao.senha){   editSenhaCadastro.error = null   }else{ editSenhaCadastro.error =  R.string.erro_senha.toString()}
                    if (resultadoValicao.telefone){   editFoneCadastro.error = null   }else{ editFoneCadastro.error =  R.string.erro_fone.toString()}
                }
        }

        viewModelAutenticacao.sucesso.observe(this){sucesso->
            if(sucesso){
                  navegarTelaPrincipal()
            }else{
                  MostrarMensagem( "Erro ao tentar salvar" )
            }
        }

        viewModelAutenticacao.carregamento.observe(this){carregando->
            if(carregando){
                    exibirAlertDialogCarregamento.mostrarDialog()
            }else{
                    exibirAlertDialogCarregamento.fecharDialog()
                   //MostrarMensagem( "Erro ao tentar salvar" )
            }
        }

    }


    private fun navegarTelaPrincipal(){
        startActivity(Intent(this, HomeActivity::class.java))
    }



    private fun inicializarToolbar() {

        val toobar = binding.inlcudeToolbar.materialToolbar
        setSupportActionBar( toobar )

        supportActionBar?.apply {
              title = "Cadastro Usuário"
              setDisplayHomeAsUpEnabled(true)
        }


    }
}