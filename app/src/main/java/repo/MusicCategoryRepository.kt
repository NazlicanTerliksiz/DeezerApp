package repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nazlicanterliksiz.deezerapp.service.MusicCategoryApi
import data.model.MusicCategoryModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MusicCategoryRepository {

    private var job: Job? = null

    private val _category = MutableLiveData<MusicCategoryModel>()
    val category: LiveData<MusicCategoryModel>
        get() = _category

    fun getMusicCategory() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = MusicCategoryApi.retrofitCategoryService.getCategory()
            if (response.isSuccessful) {
                response.body()?.let {musicCategoryModel ->
                    println("deneme $musicCategoryModel")
                    _category.postValue(musicCategoryModel)
                }
            }
        }
    }
    fun getCategory() : MutableLiveData<MusicCategoryModel> {
        return _category
    }
}
