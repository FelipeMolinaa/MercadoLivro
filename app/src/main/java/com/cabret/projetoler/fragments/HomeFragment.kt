package com.cabret.projetoler.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import com.cabret.projetoler.Models.GetBooksResponse
import com.cabret.projetoler.R
import com.cabret.projetoler.adapters.GridViewAdapter
import com.cabret.projetoler.interfaces.IApiResponse
import com.cabret.projetoler.modals.GridViewModal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        val retrofit = Retrofit.Builder()
            .baseUrl("https://congenial-succotash-wgpxpx5p47qhgvx7-3000.app.github.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(IApiResponse::class.java)
        var call = apiService.getBooks()
        Log.d("api", "chegou call")

        call.enqueue(object : Callback<ArrayList<GetBooksResponse>> {
            override fun onResponse(call: Call<ArrayList<GetBooksResponse>>, response: Response<ArrayList<GetBooksResponse>>) {
                Log.d("api", "chegou onResponse")
                if (response.isSuccessful) {
                    Log.d("api", "chegou isSuccessful")
                    val dados = response.body()
                    for (livro in dados.orEmpty()){
                        Log.d("api", livro.titulo)
                        listaLivros = listaLivros + GridViewModal(livro.image, livro.titulo,livro.autor)
                        val gridViewAdapter = GridViewAdapter(listaLivros, homeFragmentContext)
                        gridViewLivros.adapter = gridViewAdapter

                        gridViewLivros.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                            val transaction = activity?.supportFragmentManager?.beginTransaction()
                            transaction?.replace(R.id.container, LivroDetailFragment())
                            transaction?.disallowAddToBackStack()
                            transaction?.commit()
                        }
                    }
                } else {
                    // Trate os erros aqui
                }
            }

            override fun onFailure(call: Call<ArrayList<GetBooksResponse>>, t: Throwable) {

            }
        })

        return homeFragmentView;
    }




}