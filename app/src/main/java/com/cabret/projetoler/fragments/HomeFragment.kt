package com.cabret.projetoler.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.cabret.projetoler.R
import com.cabret.projetoler.adapters.GridViewAdapter
import com.cabret.projetoler.modals.GridViewModal

class HomeFragment : Fragment() {

    lateinit var gridViewLivros: GridView
    lateinit var listaLivros: List<GridViewModal>
    lateinit var homeFragmentView: View
    lateinit var homeFragmentContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentView = inflater.inflate(R.layout.fragment_home, container, false)
        homeFragmentContext = container!!.getContext();
        gridViewLivros = homeFragmentView.findViewById(R.id.livros_gridView)
        listaLivros = ArrayList<GridViewModal>()

        listaLivros = listaLivros + GridViewModal(R.mipmap.ic_milk_and_honey, "milk and honey","rupi kaur")
        listaLivros = listaLivros + GridViewModal(R.mipmap.ic_harry_potter, "Harry potter","J. K. Rowling")
        listaLivros = listaLivros + GridViewModal(R.mipmap.ic_homem_rico, "O Homem mais Rico","George Samuel Clason")
        listaLivros = listaLivros + GridViewModal(R.mipmap.ic_milk_and_honey, "milk and honey","rupi kaur")
        listaLivros = listaLivros + GridViewModal(R.mipmap.ic_harry_potter, "Harry potter","J. K. Rowling")
        listaLivros = listaLivros + GridViewModal(R.mipmap.ic_homem_rico, "O Homem mais Rico","George Samuel Clason")

        val gridViewAdapter = GridViewAdapter(listaLivros, homeFragmentContext)
        gridViewLivros.adapter = gridViewAdapter

        gridViewLivros.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, LivroDetailFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }

        return homeFragmentView;
    }




}