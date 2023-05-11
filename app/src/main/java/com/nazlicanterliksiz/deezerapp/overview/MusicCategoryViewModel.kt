package com.nazlicanterliksiz.deezerapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nazlicanterliksiz.deezerapp.model.MusicCategoryModel
import com.nazlicanterliksiz.deezerapp.service.MusicApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MusicCategoryViewModel : ViewModel() {

    private var job: Job? = null

    private val _music = MutableLiveData<MusicCategoryModel>()
    val music: LiveData<MusicCategoryModel>
        get() = _music

     fun getMovies() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = MusicApi.retrofitService.getMusic()
            if (response.isSuccessful) {
                response.body()?.let {musicCategoryModel ->
                    println("deneme $musicCategoryModel")
                    _music.postValue(musicCategoryModel)
                }
            }
        }
    }

}

