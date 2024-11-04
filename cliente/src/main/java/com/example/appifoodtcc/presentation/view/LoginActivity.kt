package com.example.appifoodtcc.presentation.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.appifoodtcc.R
import com.example.appifoodtcc.databinding.ActivityLoginBinding
import com.example.appifoodtcc.domain.model.Usuario
import com.example.appifoodtcc.domain.usecase.EsconderTeclado
import com.example.appifoodtcc.presentation.ViewModelAutenticacao
import com.example.core.ExibirAlertDialogCarregamento
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    private val viewModelAutenticacao: ViewModelAutenticacao by viewModels()
    private lateinit var exibirAlertDialogCarregamento: ExibirAlertDialogCarregamento

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        val splash = installSplashScreen()
        splash.setKeepOnScreenCondition{
            viewModelAutenticacao.verificarUsuarioLogado.observe(this){ logado->
                if(logado){
                    navegarTelaPrincipal()
                }
            }

            false
        }

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

//        viewModelAutenticacao.sucesso.observe(this){sucesso->
//            if(sucesso){
//                navegarTelaPrincipal()
//            }else{
//                MostrarMensagem( "Erro ao tentar salvar" )
//            }
//        }

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
        startActivity(Intent(this, MainActivity::class.java))
    }

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    private fun clicks() {
        with(binding){
            btEntrarLogin.setOnClickListener {

                EsconderTeclado()

                editEmailLogin.clearFocus()
                editSenhaLogin.clearFocus()

                val email = editEmailLogin.text.toString()
                val senha = editSenhaLogin.text.toString()

                val usuario = Usuario(email = email, senha = senha)
                viewModelAutenticacao.logarUsuario(usuario){  uiStatus ->  
                      when(uiStatus){
                          is UIStatus.Sucesso -> {
                              val retorno = uiStatus.parametro
                              if(retorno){
                                    Toast.makeText(applicationContext, "Logado com sucesso.", Toast.LENGTH_LONG).show()
                                    navegarTelaPrincipal()
                              }
                          }
                          is UIStatus.Erro ->{
                                   val erro = uiStatus.mensagem
                                   Toast.makeText(applicationContext, "$erro", Toast.LENGTH_LONG).show()
                          }

                      }
                }
            }

            txtCadastrarLogin.setOnClickListener {
                startActivity(Intent(applicationContext, CadastroActivity::class.java))
            }
        }

    }
}