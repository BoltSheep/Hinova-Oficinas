package com.example.hinovaoficinas.servicoapi

import com.example.hinovaoficinas.constantes.URL_BASICA
//import com.example.hinovaoficinas.models.ClasseRetornoOficina
import com.example.hinovaoficinas.models.IndicacaoApiModel
import com.example.hinovaoficinas.models.ListaOfinasApiModel
import com.example.hinovaoficinas.models.RetornoApi
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


private val retrofit =
    Retrofit.Builder()
        .baseUrl(URL_BASICA)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val consumirServico = retrofit.create(GerenciadorApi::class.java)

interface GerenciadorApi {
    @GET("Api/Oficina?codigoAssociacao=601&cpfAssociado=78885983073")
    suspend fun buscarOficinas(): ListaOfinasApiModel

    @POST("Api/Indicacao")
    suspend fun EnviarIndicacao(@Body indicacaoApiModel: IndicacaoApiModel): RetornoApi
}