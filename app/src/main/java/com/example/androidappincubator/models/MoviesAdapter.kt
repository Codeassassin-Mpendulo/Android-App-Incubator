package com.example.androidappincubator.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidappincubator.R
import com.example.androidappincubator.databinding.MovieViewLayoutBinding
import com.squareup.picasso.Picasso

class MoviesAdapter(private val moviesList: List<Movie>):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemGymRate: MovieViewLayoutBinding = MovieViewLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemGymRate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = moviesList[position]
        holder.movieTitle.text = currentMovie.title
        holder.movieDescription.text = currentMovie.synopsis
        Picasso.get()
            .load(currentMovie.img)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.thumbnailImage);
    }

    override fun getItemCount(): Int {
        return moviesList.count()
    }

    class ViewHolder(movieItem: MovieViewLayoutBinding): RecyclerView.ViewHolder(movieItem.root){
        val thumbnailImage = movieItem.movieThumbnailImageView
        val movieTitle = movieItem.movieTitle
        val movieDescription = movieItem.movieDescription
    }
}