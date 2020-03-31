package me.slaheddine.leboncoin.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.slaheddine.domain.usecases.GetAlbumsUseCase
import me.slaheddine.leboncoin.presentation.mapper.AlbumMapper
import me.slaheddine.leboncoin.presentation.models.AlbumItem
import me.slaheddine.leboncoin.presentation.utils.DataResponse
import me.slaheddine.leboncoin.presentation.utils.Failure
import me.slaheddine.leboncoin.presentation.utils.Loading
import me.slaheddine.leboncoin.presentation.utils.Success
import java.lang.Exception

class AlbumViewModel(var getAlbumUseCase : GetAlbumsUseCase, var mapper : AlbumMapper) : ViewModel() {

    private final var PAGE_SIZE = 20;
    private lateinit var albumList: List<AlbumItem>
    val albumListLiveData: MutableLiveData<DataResponse<List<AlbumItem>>> = MutableLiveData()

    fun loadAlbums() {

        albumListLiveData.postValue(Loading(true))

        viewModelScope.launch {

            try {
                val result = getAlbumUseCase.invoke(Unit)
                if(!result.isNullOrEmpty()) {
                    albumList = mapper.transform(result);
                    albumListLiveData.postValue(Success(albumList.subList(0, PAGE_SIZE)))
                }
            }
            catch (e : Exception) {
                albumListLiveData.postValue(Failure(e))
            }
        }
    }

    fun loadMore(lastIndex : Int) {
       if(lastIndex<albumList.size) {
           albumListLiveData.postValue(Loading(true))
           viewModelScope.launch {
               albumListLiveData.postValue(Success(albumList.subList(lastIndex, lastIndex + PAGE_SIZE)))
           }
       }
    }
}
