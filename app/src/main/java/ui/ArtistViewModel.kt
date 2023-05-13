package ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nazlicanterliksiz.deezerapp.service.ArtistApi
import data.model.ArtistModel
import data.model.MusicCategoryModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import repo.ArtistRepository
import repo.MusicCategoryRepository

class ArtistViewModel {

    private val artistRepo = ArtistRepository()
    var musicArtistModel = MutableLiveData<ArtistModel>()

    init {
        getCategoryFromRepo()
        musicArtistModel = artistRepo.getArtist()
    }

    private fun getCategoryFromRepo(){
        artistRepo.getCategoryArtist()
    }
}
