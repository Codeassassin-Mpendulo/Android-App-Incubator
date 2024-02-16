package com.example.androidappincubator.views

import com.example.androidappincubator.models.Movie

interface MoviesView {
    fun render(movies: List<Movie>?)
    fun setMovieBusinessLayer()
}