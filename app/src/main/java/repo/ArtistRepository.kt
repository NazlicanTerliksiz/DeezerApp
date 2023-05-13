package repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nazlicanterliksiz.deezerapp.service.ArtistApi
import data.model.ArtistModel
import data.model.MusicCategoryModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ArtistRepository {

    private var job: Job? = null

    private val _artist = MutableLiveData<ArtistModel>()
    val artist: LiveData<ArtistModel>
        get() = _artist

    fun getCategoryArtist() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = ArtistApi.retrofitArtistService.getArtist(id = 132)
            if (response.isSuccessful) {
                response.body()?.let {artistModel ->
                    println("deneme $artistModel")
                    _artist.postValue(artistModel)
                }
            }
        }
    }
    fun getArtist(): MutableLiveData<ArtistModel> {
        return _artist
    }
}