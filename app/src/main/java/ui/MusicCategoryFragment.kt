package ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import data.adapter.MusicCategoryAdapter
import com.nazlicanterliksiz.deezerapp.databinding.FragmentMusicCategoryBinding


class MusicCategoryFragment : Fragment() {

    private lateinit var binding:FragmentMusicCategoryBinding

    private val viewModel : MusicCategoryViewModel by lazy { MusicCategoryViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicCategoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.musicCategoryModel
        observe()
    }

    private fun observe(){
        viewModel.musicCategoryModel.observe(viewLifecycleOwner){
            binding.movieRV.adapter = MusicCategoryAdapter(it){

            }

        }
    }
}