package data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlicanterliksiz.deezerapp.databinding.ArtistCardBinding
import com.squareup.picasso.Picasso
import data.model.ArtistModel
import data.model.Artists

class ArtistAdapter (private val artistList: ArtistModel, val onItemClickListener: (() -> Unit)) :
    RecyclerView.Adapter<ArtistAdapter.ArtistRowHolder>() {

    inner class ArtistRowHolder(private val binding: ArtistCardBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onItemClickListener.invoke()
            }
        }
        fun bind(artist: Artists) {
            binding.apply {
                movieNameText.text = artist.name
                Picasso.get().load(artist.picture).into(movieImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistRowHolder {
        val binding =  ArtistCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistRowHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistRowHolder, position: Int) {
        val artist = artistList.data[position]
        holder.bind(artist)
    }

    override fun getItemCount(): Int {
        return artistList.data.count()
    }
}