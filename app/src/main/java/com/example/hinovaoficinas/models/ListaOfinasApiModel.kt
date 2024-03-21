package com.example.hinovaoficinas.models

data class ListaOfinasApiModel(
        val ListaOficinas: List<OficinaApiModel>,
        val RetornoErro: BaseRetornoErroApiModel,
        val Token: String?,
)

data class OficinaApiModel(
        val Id: Long,
        val Nome: String,
        val Descricao: String,
        val DescricaoCurta: String,
        val Endereco: String,
        val Latitude: String,
        val Longitude: String,
        val Foto: String,
        val AvaliacaoUsuario: Long,
        val CodigoAssociacao: Long,
        val Email: String,
        val Telefone1: String,
        val Telefone2: String?,
        val Ativo: Boolean,
)

data class BaseRetornoErroApiModel(
        val retornoErro: String?,
)

