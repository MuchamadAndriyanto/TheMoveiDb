package com.example.themoveidb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoveidb.databinding.ItemFilmBinding
import com.example.themoveidb.model.Result

class MovieAdapter(var listfilm:List<Result>): RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    class ViewHolder(var binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.binding.tvNamafilm.text = listfilm[position].originalTitle
        holder.binding.tvRatingfilm.text = listfilm[position].voteAverage.toString()
        holder.binding.tvReleasefilm.text=listfilm[position].releaseDate
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500${listfilm[position].posterPath}").into(holder.binding.ivFilmimage)
    }

    override fun getItemCount(): Int {
        return listfilm.size
    }
}