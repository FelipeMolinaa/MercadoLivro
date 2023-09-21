package com.cabret.projetoler.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.cabret.projetoler.Models.GetBooksResponse
import com.cabret.projetoler.Models.ItemCarrinho
import com.cabret.projetoler.R
import com.cabret.projetoler.ViewModel.Carrinho
import com.cabret.projetoler.adapters.GridViewAdapter
import com.cabret.projetoler.interfaces.IApiResponse
import com.cabret.projetoler.modals.GridViewModal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LivroDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var livroDetailFragment =  inflater.inflate(R.layout.fragment_livro_detail, container, false)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://congenial-succotash-wgpxpx5p47qhgvx7-3000.app.github.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(IApiResponse::class.java)
        var call = apiService.getBook(1)

        call.enqueue(object : Callback<GetBooksResponse> {
            override fun onResponse(call: Call<GetBooksResponse>, response: Response<GetBooksResponse>) {
                if (response.isSuccessful) {
                    val dados = response.body()
                    Glide.with(livroDetailFragment)
                        .load(dados?.image)
                        .into(livroDetailFragment.findViewById<ImageView>(R.id.imageDetailAnunciante))
                    livroDetailFragment.findViewById<TextView>(R.id.livroDetailFragment_titulo).text = dados?.titulo
                    livroDetailFragment.findViewById<TextView>(R.id.livroDetailFragment_autor).text = dados?.autor
                    livroDetailFragment.findViewById<TextView>(R.id.descricaoLivro).text = dados?.estadoFisico
                } else {
                    // Trate os erros aqui
                }
            }

            override fun onFailure(call: Call<GetBooksResponse>, t: Throwable) {

            }
        })

        livroDetailFragment.findViewById<Button>(R.id.carrinhoButton).setOnClickListener{
            val item = ItemCarrinho(id = 1, nome = "Produto 1", preco = 10.0)
            Carrinho.adicionarAoCarrinho(item)
            Carrinho.removerDoCarrinho(item)
        }

        return livroDetailFragment;
    }
}