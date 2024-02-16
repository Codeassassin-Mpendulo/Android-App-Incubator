package com.example.androidappincubator.network

import com.example.androidappincubator.models.MoviesList
import com.example.androidappincubator.models.ResponseModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieListServices {

    @Headers(
        "X-RapidAPI-Key: a6c81ef7b4mshc75f5c4f3777f74p15f981jsn3d4bf099cca7",
        "X-RapidAPI-Host: unogs-unogs-v1.p.rapidapi.com"
    )

    @GET("search/titles")
    suspend fun getMoviesList(): Response<ResponseModel>
}