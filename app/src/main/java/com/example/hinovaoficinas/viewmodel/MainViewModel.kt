package com.example.hinovaoficinas.viewmodel

import android.icu.util.Calendar
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hinovaoficinas.models.Indicacao
import com.example.hinovaoficinas.models.IndicacaoApiModel
import com.example.hinovaoficinas.models.ListaOfinasApiModel
import com.example.hinovaoficinas.models.OficinaApiModel
import com.example.hinovaoficinas.models.mock.UsuarioMockado
import com.example.hinovaoficinas.servicoapi.consumirServico
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {

    var listaOficinasCarregado = MutableLiveData<ListaOfinasApiModel>()
    var status = MutableLiveData<Boolean>()


    fun checarDadosLogin( cpf: String, senha:String): Boolean {
        return (cpf == UsuarioMockado.usuarioMockado.Cpf && senha == UsuarioMockado.Senha)
    }

    fun enviarDados( nome: String, email: String, telefone: String) {

        val dadosCompletos = IndicacaoApiModel(
            Indicacao = Indicacao(
                CodigoAssociacao = "601",
                DataCriacao = Calendar.DATE.toString(),
                CpfAssociado= UsuarioMockado.usuarioMockado.Cpf,
                EmailAssociado = UsuarioMockado.usuarioMockado.Email,
                NomeAssociado = UsuarioMockado.usuarioMockado.Nome,
                TelefoneAssociado = UsuarioMockado.usuarioMockado.Telefone,
                PlacaVeiculoAssociado = "",
                NomeAmigo = nome,
                TelefoneAmigo = email,
                EmailAmigo = telefone
            ),
            Remetente = UsuarioMockado.usuarioMockado.Email,
            Copias = listOf(1)
        )

        viewModelScope.launch {
            val respostaEnviar = consumirServico.EnviarIndicacao(dadosCompletos)
            status.postValue((respostaEnviar.Sucesso == "Indicacao enviada com sucesso!"))
        }

    }


    fun receberOficinas(){
        try {
            viewModelScope.launch {
                val resposta = consumirServico.buscarOficinas()
                listaOficinasCarregado.postValue(resposta)
            }
        }catch (e: Exception){
           var error = e
        }
    }
}
