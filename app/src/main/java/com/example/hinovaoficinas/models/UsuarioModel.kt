package com.example.hinovaoficinas.models

data class UsuarioModel(
    val Id: String,
    val Nome: String,
    val Codigo_mobile: String,
    val Cpf: String,
    val Email: String,
    val Situacao: String,
    val Telefone: String,
)

//{
//    "Id": "3555",
//    "Nome": "Marcelo Teste",
//    "Codigo_mobile": "555",
//    "Cpf": "788.859.830-73",
//    "Email": "marcelo.teste@hinovamobile.com.br",
//    "Situacao": "ATIVO",
//    "Telefone": "31-9999-5551"
//}