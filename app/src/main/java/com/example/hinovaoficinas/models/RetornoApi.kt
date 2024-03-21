package com.example.hinovaoficinas.models

data class RetornoApi(
    val RetornoErro: BaseRetornoErroApiModel,
    val Sucesso: String
)