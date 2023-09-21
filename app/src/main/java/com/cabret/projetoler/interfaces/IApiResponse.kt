package com.cabret.projetoler.interfaces

import com.cabret.projetoler.Models.GetBooksResponse
import com.cabret.projetoler.Models.UserLoginRequest
import com.cabret.projetoler.Models.UserLoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

internal interface IApiResponse {
    @GET("Books")
    fun getBooks(): Call<ArrayList<GetBooksResponse>>
    @GET("Books")
    fun getBook(@Query("id") id: Int,): Call<GetBooksResponse>

    @POST("Login")
    fun Login(credentials: UserLoginRequest): Call<UserLoginResponse>
}