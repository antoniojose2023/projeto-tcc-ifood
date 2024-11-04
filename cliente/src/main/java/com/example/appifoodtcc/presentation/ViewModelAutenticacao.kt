package com.example.appifoodtcc.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.appifoodtcc.domain.ResultadoValidacao
import com.example.appifoodtcc.domain.model.Usuario
import com.example.appifoodtcc.domain.repository.RepositoryAutenticacaoImpl
import com.example.appifoodtcc.presentation.view.UIStatus
import com.example.appifoodtcc.domain.usecase.UseCaseAutenticacao
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelAutenticacao @Inject constructor(
        private val repositoryAutenticacaoImpl: RepositoryAutenticacaoImpl,
        private val useCaseAutenticacao: UseCaseAutenticacao
): ViewModel() {

     private val _resultadoValidacao = MutableLiveData<ResultadoValidacao>()
     var resultadoValidacao: LiveData<ResultadoValidacao> = _resultadoValidacao

     private val _sucesso = MutableLiveData<Boolean>()
     var sucesso: LiveData<Boolean> = _sucesso

     private val _carregamento = MutableLiveData<Boolean>()
     var carregamento: LiveData<Boolean> = _carregamento

     private val _verificarUsuarioLogado = MutableLiveData<Boolean>()
     var verificarUsuarioLogado: LiveData<Boolean> = _verificarUsuarioLogado

    fun cadastrarUsuario(usuario: Usuario, status: (UIStatus<Boolean>)-> Unit){
        val resultadoValidacao = useCaseAutenticacao.validacaoCadastro(usuario)
        _resultadoValidacao.value = resultadoValidacao
        if(resultadoValidacao.sucessoValicacaoCadastro){
            _carregamento.value = true
            viewModelScope.launch {
                 repositoryAutenticacaoImpl.cadastrarUsuario( usuario, status )
                 _carregamento.postValue( false )
            }

        }
    }

    fun logarUsuario(usuario: Usuario, states: (UIStatus<Boolean>)-> Unit){
        val resultadoValidacao = useCaseAutenticacao.validarLogin( usuario )
        _resultadoValidacao.value = resultadoValidacao
        if(resultadoValidacao.sucessoValicacaoLogin){
            _carregamento.value = true
            viewModelScope.launch {
                 repositoryAutenticacaoImpl.loginUsuario( usuario, states )
                _carregamento.postValue( false )
            }

        }
    }

    fun verificarUsuarioLogado(){
        _carregamento.value = true
             val logado = repositoryAutenticacaoImpl.verificarUsuarioLogado()
            if(logado){
                _carregamento.postValue( false )
                _verificarUsuarioLogado.postValue( logado )
            }else{
                _carregamento.postValue( false )
            }
    }

}