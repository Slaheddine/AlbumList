package me.slaheddine.leboncoin.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.slaheddine.domain.models.Album
import me.slaheddine.domain.usecases.GetAlbumsUseCase
import me.slaheddine.domain.usecases.UseCaseCallBack
import me.slaheddine.leboncoin.presentation.mapper.AlbumMapper
import me.slaheddine.leboncoin.presentation.models.AlbumItem
import me.slaheddine.leboncoin.presentation.utils.DataResponse
import me.slaheddine.leboncoin.presentation.utils.Failure
import me.slaheddine.leboncoin.presentation.utils.Loading
import me.slaheddine.leboncoin.presentation.utils.Success

class AlbumViewModel(var getAlbumUseCase : GetAlbumsUseCase, var mapper : AlbumMapper) : ViewModel() {

    val albumListLiveData: MutableLiveData<DataResponse<List<AlbumItem>>> = MutableLiveData()

    fun loadAlbums() {

        albumListLiveData.postValue(Loading(true))

        getAlbumUseCase.execute(Unit, object: UseCaseCallBack<List<Album>> {
            override fun onSuccess(it: List<Album>) {
                albumListLiveData.postValue(Success(mapper.transform(it)))
            }

            override fun onFailure(error: Throwable) {
                albumListLiveData.postValue(Failure(error))
            }
        })
    }
}
