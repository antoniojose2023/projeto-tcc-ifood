package com.example.appifoodtcc.presentation.view

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.appifoodtcc.R
import com.example.appifoodtcc.databinding.ActivityLoginBinding
import com.example.appifoodtcc.domain.model.Usuario
import com.example.appifoodtcc.presentation.ViewModelAutenticacao
import com.example.core.ExibirAlertDialogCarregamento
import com.example.core.MostrarMensagem
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    private val viewModelAutenticacao: ViewModelAutenticacao by viewModels()
    private lateinit var exibirAlertDialogCarregamento: ExibirAlertDialogCarregamento

    override fun onCreate(savedInstanceState: Bundle?) {
        val splash = installSplashScreen()
        splash.setKeepOnScreenCondition{
             false
        }

        //Thread.sleep(3000)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        exibirAlertDialogCarregamento = ExibirAlertDialogCarregamento(this)


        //FirebaseAuth.getInstance().signOut()

        clicks()
        listerners()

    }

    override fun onStart() {
        super.onStart()
        viewModelAutenticacao.verificarUsuarioLogado()
    }

    private fun listerners() {

        viewModelAutenticacao.resultadoValidacao.observe(this){ resultadoValicao ->
            with(binding){
                if (resultadoValicao.email){   editEmailLogin.error = null   }else{ editEmailLogin.error =  getString(R.string.erro_email)}
                if (resultadoValicao.senha){   editSenhaLogin.error = null   }else{ editSenhaLogin.error =  getString(R.string.erro_senha)}
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

        viewModelAutenticacao.verificarUsuarioLogado.observe(this){ logado->
            if(logado){
                navegarTelaPrincipal()
            }
        }

    }

    private fun navegarTelaPrincipal(){
        startActivity(Intent(this, HomeActivity::class.java))
    }

    private fun clicks() {

        with(binding){
            btEntrarLogin.setOnClickListener {
                val email = editEmailLogin.text.toString()
                val senha = editSenhaLogin.text.toString()

                val usuario = Usuario(email = email, senha = senha)
                viewModelAutenticacao.logarUsuario(usuario)
            }

            txtCadastrarLogin.setOnClickListener {
                startActivity(Intent(applicationContext, CadastroActivity::class.java))
            }
        }

    }
}