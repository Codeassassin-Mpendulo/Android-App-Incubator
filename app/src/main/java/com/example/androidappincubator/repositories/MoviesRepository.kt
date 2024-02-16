package com.example.androidappincubator.repositories

import android.util.Log
import android.widget.Toast
import com.example.androidappincubator.models.Movie
import com.example.androidappincubator.models.ResponseModel
import com.example.androidappincubator.network.MovieListServices
import com.example.androidappincubator.network.RetrofitClientInstance
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository(private val networkInstance: RetrofitClientInstance) {

    private var moviesCache: List<Movie>? = null
    suspend fun getMovies(): List<Movie>? {
        val moviesService = networkInstance.retrofitInstance?.create(MovieListServices::class.java)
        val res = moviesService?.getMoviesList()
        if (res != null && res.isSuccessful) {
            withContext(Dispatchers.Main) {
                moviesCache = res.body()?.results
                return@withContext moviesCache
            }
        }
        return moviesCache
    }
}