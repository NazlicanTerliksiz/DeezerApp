package com.nazlicanterliksiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.deezerapp.databinding.MusicCategoryCardBinding
import com.nazlicanterliksiz.deezerapp.model.Data
import com.nazlicanterliksiz.deezerapp.model.MusicCategoryModel
import com.squareup.picasso.Picasso


class MusicCategoryAdapter(private val musicCategoryList: MusicCategoryModel, val onItemClickListener: (() -> Unit)) :
    RecyclerView.Adapter<MusicCategoryAdapter.RowHolder>() {

    inner class RowHolder(private val binding: MusicCategoryCardBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onItemClickListener.invoke()
            }
        }
        fun bind(movie: Data) {
            binding.apply {
                movieNameText.text = movie.name
                Picasso.get().load(movie.picture).into(movieImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = MusicCategoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return musicCategoryList.data.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val music = musicCategoryList.data[position]
        holder.bind(music)
    }
}
