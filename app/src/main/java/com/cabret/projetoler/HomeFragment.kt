package com.cabret.projetoler

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
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

        listaLivros = listaLivros + GridViewModal(1, "Teste1","teste1")
        listaLivros = listaLivros + GridViewModal(1, "Teste2","teste2")
        listaLivros = listaLivros + GridViewModal(1, "Teste3","teste3")
        listaLivros = listaLivros + GridViewModal(1, "Teste4","teste4")

        val gridViewAdapter = GridViewAdapter(listaLivros, homeFragmentContext)
        gridViewLivros.adapter = gridViewAdapter

        gridViewLivros.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // inside on click method we are simply displaying
            // a toast message with course name.
            Toast.makeText(
                context, listaLivros[position].titulo + " selected",
                Toast.LENGTH_SHORT
            ).show()
        }

        return homeFragmentView;
    }




}