package com.example.androidappincubator.businesslayers

import com.example.androidappincubator.models.Movie
import com.example.androidappincubator.network.RetrofitClientInstance
import com.example.androidappincubator.repositories.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieBusinessLogicLayer {
    private val moviesRepository = MoviesRepository(RetrofitClientInstance)
    suspend fun getMovies(): List<Movie>? {
        return moviesRepository.getMovies()
    }

}
