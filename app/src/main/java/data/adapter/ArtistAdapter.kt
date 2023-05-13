package data.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.deezerapp.databinding.MusicCategoryCardBinding
import com.squareup.picasso.Picasso
import data.model.ArtistModel
import data.model.Categories

class ArtistAdapter (private val artistList: ArtistModel, val onItemClickListener: (() -> Unit)) :
    RecyclerView.Adapter<MusicCategoryAdapter.RowHolder>() {

    inner class RowHolder(private val binding: MusicCategoryCardBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onItemClickListener.invoke()
            }
        }
        fun bind(category: Categories) {
            binding.apply {
                movieNameText.text = category.name
                Picasso.get().load(category.picture).into(movieImageView)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicCategoryAdapter.RowHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MusicCategoryAdapter.RowHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}