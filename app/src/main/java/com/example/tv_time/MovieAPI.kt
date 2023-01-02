package com.example.sadistesting

import com.example.tv_timedata.MoviesTest
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : Call<MoviesTest>
}

object RetrofitInstance {
    val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .build()
            //.create(MovieApi::class.java)
    }

    val movieService : MovieAPI by lazy {
        retrofit.create(MovieAPI::class.java)
    }
}