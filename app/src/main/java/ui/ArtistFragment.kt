package ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nazlicanterliksiz.deezerapp.R
import com.nazlicanterliksiz.deezerapp.databinding.FragmentArtistBinding
import com.nazlicanterliksiz.deezerapp.databinding.FragmentMusicCategoryBinding
import data.adapter.ArtistAdapter
import data.adapter.MusicCategoryAdapter

class ArtistFragment : Fragment() {

    private lateinit var binding: FragmentArtistBinding

    private val viewModel : ArtistViewModel by lazy { ArtistViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtistBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.musicArtistModel
        observe()
    }

    private fun observe(){
        viewModel.musicArtistModel.observe(viewLifecycleOwner){
            binding.artistRV.adapter = ArtistAdapter(it){

            }

        }
    }

}