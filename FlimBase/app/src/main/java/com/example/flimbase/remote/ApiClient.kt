package com.example.flimbase.remote

import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    //https://api.themoviedb.org/3/movie/popular?api_key=c786d51042a6a278e561a6b55e90ff21
    @GET("3/movie/popular?api_key=c786d51042a6a278e561a6b55e90ff21")
    fun getMovie(): Call<ResponseModel>
}