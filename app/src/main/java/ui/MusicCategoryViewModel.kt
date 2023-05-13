package ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import data.model.MusicCategoryModel
import repo.MusicCategoryRepository

class MusicCategoryViewModel : ViewModel() {

    private val musicCategoryRepo = MusicCategoryRepository()
    var musicCategoryModel = MutableLiveData<MusicCategoryModel>()

    init {
        getCategoryFromRepo()
        musicCategoryModel = musicCategoryRepo.getCategory()
    }

    private fun getCategoryFromRepo(){
        musicCategoryRepo.getMusicCategory()
    }

}

