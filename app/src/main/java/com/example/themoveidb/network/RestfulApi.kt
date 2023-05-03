package com.example.themoveidb.network

import com.example.themoveidb.model.MovieTopRated
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestfulApi {
    @GET("movie/toprated?")
    fun getmovietoprated(
        @Query("api_key") APIKEY: String,
        @Query("page") PAGE: Int
    ): Call<MovieTopRated<com.example.themoveidb.model.Result>>

}