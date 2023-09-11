package com.cabret.projetoler.Models

data class GetBooksResponse (
    val id: String,
    val titulo: String,
    val autor: String,
    val resumo: String,
    val estadoFisico: String,
    val preco: String,
    val image: String,
){}