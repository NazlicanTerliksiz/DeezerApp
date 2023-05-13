package ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nazlicanterliksiz.deezerapp.service.ArtistApi
import data.model.ArtistModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ArtistViewModel {
    private var job: Job? = null

    private val _artist = MutableLiveData<ArtistModel>()
    val artist: LiveData<ArtistModel>
        get() = _artist

    fun getArtist() {
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

}
