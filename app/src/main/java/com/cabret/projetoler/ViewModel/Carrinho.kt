package com.cabret.projetoler.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cabret.projetoler.Models.ItemCarrinho

object Carrinho {
    private val itensCarrinho = mutableListOf<ItemCarrinho>()

    fun adicionarAoCarrinho(item: ItemCarrinho) {
        itensCarrinho.add(item)
    }

    fun removerDoCarrinho(item: ItemCarrinho) {
        itensCarrinho.remove(item)
    }

    fun limparCarrinho() {
        itensCarrinho.clear()
    }

    fun obterItensCarrinho(): List<ItemCarrinho> {
        return itensCarrinho.toList()
    }
}