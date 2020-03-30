package me.slaheddine.leboncoin.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.slaheddine.domain.models.Album
import me.slaheddine.domain.usecases.GetAlbumsUseCase
import me.slaheddine.domain.usecases.UseCaseCallBack
import me.slaheddine.leboncoin.presentation.mapper.AlbumMapper
import me.slaheddine.leboncoin.presentation.models.AlbumItem

class AlbumViewModel(var getAlbumUseCase : GetAlbumsUseCase, var mapper : AlbumMapper) : ViewModel() {

    val albumListLiveData: MutableLiveData<List<AlbumItem>> = MutableLiveData()
    val failure : MutableLiveData<Unit> = MutableLiveData()

    fun loadAlbums() {
        getAlbumUseCase.execute(0, object: UseCaseCallBack<List<Album>> {
            override fun onSuccess(it: List<Album>) {
                albumListLiveData.value = mapper.transform(it)
            }

            override fun onFailure(error: Throwable) {
                failure.value = Unit;
            }
        })
    }
}
