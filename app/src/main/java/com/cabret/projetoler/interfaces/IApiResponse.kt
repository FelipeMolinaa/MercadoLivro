package com.cabret.projetoler.interfaces

import com.cabret.projetoler.Models.GetBooksResponse
import com.cabret.projetoler.Models.UserLoginRequest
import com.cabret.projetoler.Models.UserLoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

internal interface IApiResponse {
    @GET("Books")
    fun getBooks(): Call<ArrayList<GetBooksResponse>>

    @POST("Login")
    fun Login(credentials: UserLoginRequest): Call<UserLoginResponse>
}