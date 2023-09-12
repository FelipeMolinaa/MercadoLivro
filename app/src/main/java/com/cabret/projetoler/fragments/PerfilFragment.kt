package com.cabret.projetoler.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import com.cabret.projetoler.Models.GetBooksResponse
import com.cabret.projetoler.Models.UserLoginRequest
import com.cabret.projetoler.Models.UserLoginResponse
import com.cabret.projetoler.R
import com.cabret.projetoler.adapters.GridViewAdapter
import com.cabret.projetoler.interfaces.IApiResponse
import com.cabret.projetoler.modals.GridViewModal
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PerfilFragment : Fragment() {

    lateinit var perfilFragment: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        perfilFragment = inflater.inflate(R.layout.fragment_perfil, container, false)


        var email = perfilFragment.findViewById<EditText>(R.id.perfil_email_textInput).text.toString()
        var senha = perfilFragment.findViewById<EditText>(R.id.perfil_senha_textInput).text.toString()

        perfilFragment.findViewById<Button>(R.id.fragmentPerfilConnetButton).setOnClickListener{
//            LoginRequest(email, senha)
                UserPage()

        }

        return perfilFragment;
    }

    fun LoginRequest(email: String, senha: String){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://congenial-succotash-wgpxpx5p47qhgvx7-3000.app.github.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

//        BCrypt.withDefaults().hashToString(12, senha.toCharArray())
        val apiService = retrofit.create(IApiResponse::class.java)
        var call = apiService.Login(UserLoginRequest(email, senha))
        Log.d("api", "chegou call")

        call.enqueue(object : Callback<UserLoginResponse> {
            override fun onResponse(call: Call<UserLoginResponse>, response: Response<UserLoginResponse>) {
                if (response.isSuccessful) {
                    val dados = response.body()
                    UserPage()
                } else {
                    // Trate os erros aqui
                }
            }

            override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {

            }
        })
    }

    fun UserPage(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.container, UserFragment())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }
}