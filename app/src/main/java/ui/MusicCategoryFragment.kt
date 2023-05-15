package ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import data.adapter.MusicCategoryAdapter
import com.nazlicanterliksiz.deezerapp.databinding.FragmentMusicCategoryBinding
import com.nazlicanterliksiz.deezerapp.service.MusicCategoryApi
import data.adapter.ArtistAdapter
import data.model.Categories
import data.model.MusicCategoryModel
import java.util.Locale.Category


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
            binding.musicCategoryRV.adapter = MusicCategoryAdapter(it, onItemClickListener ={} )

                /*
                 fun navigateToArtist( category: Categories) {
                    findNavController().navigate(
                        MusicCategoryFragmentDirections.actionMusicCategoryFragmentToArtistFragment2(
                            categoryId = category.id,
                        )
                    )
                }

            })
            */
            }
        }
    }
