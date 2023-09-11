package com.cabret.projetoler.interfaces

import com.cabret.projetoler.Models.GetBooksResponse
import retrofit2.Call
import retrofit2.http.GET

internal interface IApiResponse {
    @GET("Books")
    fun getBooks(): Call<ArrayList<GetBooksResponse>>
}