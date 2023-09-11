package com.cabret.projetoler.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.cabret.projetoler.R
import com.cabret.projetoler.adapters.GridViewAdapter
import com.cabret.projetoler.modals.GridViewModal

class CarrinhoFragment : Fragment() {

    lateinit var gridViewLivros: GridView
    lateinit var listaLivros: List<GridViewModal>
    lateinit var carrinhoFragmentView: View
    lateinit var homeFragmentContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        carrinhoFragmentView = inflater.inflate(R.layout.fragment_carrinho, container, false)
        homeFragmentContext = container!!.getContext();
        gridViewLivros = carrinhoFragmentView.findViewById(R.id.livros_gridView)
        listaLivros = ArrayList<GridViewModal>()

        listaLivros = listaLivros + GridViewModal("", "milk and honey","rupi kaur")
        listaLivros = listaLivros + GridViewModal("", "Harry potter","J. K. Rowling")
        listaLivros = listaLivros + GridViewModal("", "O Homem mais Rico","George Samuel Clason")

        val gridViewAdapter = GridViewAdapter(listaLivros, homeFragmentContext)
        gridViewLivros.adapter = gridViewAdapter
        return carrinhoFragmentView;
    }

}