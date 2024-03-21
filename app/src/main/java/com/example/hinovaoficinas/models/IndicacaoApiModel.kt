package com.example.hinovaoficinas.models

data class IndicacaoApiModel(
    val Indicacao: Indicacao,
    val Remetente: String,
    val Copias: List<Int>
)

data class Indicacao(
    val CodigoAssociacao: String,
    val DataCriacao: String,
    val CpfAssociado: String,
    val EmailAssociado: String,
    val NomeAssociado: String,
    val TelefoneAssociado: String,
    val PlacaVeiculoAssociado: String,
    val NomeAmigo: String,
    val TelefoneAmigo: String,
    val EmailAmigo: String,
)
