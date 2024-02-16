package com.example.androidappincubator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.androidappincubator.businesslayers.MovieBusinessLogicLayer
import com.example.androidappincubator.databinding.ActivityMainBinding
import com.example.androidappincubator.models.Movie
import com.example.androidappincubator.models.MoviesAdapter
import com.example.androidappincubator.network.RetrofitClientInstance
import com.example.androidappincubator.repositories.MoviesRepository
import com.example.androidappincubator.views.MoviesView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity() : AppCompatActivity(), MoviesView {
    private lateinit var moviesBusinessLayer: MovieBusinessLogicLayer
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toggleSpinningProgressBarViewTo(View.VISIBLE)
        setMovieBusinessLayer()
        getDisplayData()
    }

    private fun getDisplayData() = CoroutineScope(Dispatchers.IO).launch {
        withContext(Dispatchers.Main) {
            render(moviesBusinessLayer.getMovies())
            toggleSpinningProgressBarViewTo(View.GONE)
        }
    }

    private fun toggleSpinningProgressBarViewTo(visibility: Int) {
        binding.progressBar.visibility = visibility
    }

    override fun render(movies: List<Movie>?) {
        with(binding) {
            movieRecyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
            movieRecyclerview.setHasFixedSize(true)
            movieRecyclerview.adapter = movies?.let { MoviesAdapter(it) }
            movieRecyclerview.visibility = View.VISIBLE
        }
    }

    override fun setMovieBusinessLayer() {
        moviesBusinessLayer = MovieBusinessLogicLayer()
    }
}