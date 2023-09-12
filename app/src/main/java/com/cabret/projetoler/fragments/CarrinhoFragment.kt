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

        listaLivros = listaLivros + GridViewModal("https://m.media-amazon.com/images/I/61Fo3CitEGL._AC_UF1000,1000_QL80_.jpg", "A Menina que Roubava Livros","Markus Zusak")
        listaLivros = listaLivros + GridViewModal("https://lh3.googleusercontent.com/-Wsav6WffUaA/TYCmWTLxapI/AAAAAAAADfQ/V-6ZSLxrVl8/w1200-h675-p-k-no-nu/pc1.jpg", "Harry Potter e a Pedra Filosofal","J. K. Rowling")
        listaLivros = listaLivros + GridViewModal("https://cdn.awsli.com.br/600x450/2443/2443179/produto/163426249/f99dcad9c9.jpg", "A Arte da Guerra","Sun Tzu")

        val gridViewAdapter = GridViewAdapter(listaLivros, homeFragmentContext)
        gridViewLivros.adapter = gridViewAdapter
        return carrinhoFragmentView;
    }

}