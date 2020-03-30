package me.slaheddine.leboncoin.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.slaheddine.leboncoin.domain.usecases.GetAlbumsUseCase
import me.slaheddine.leboncoin.domain.usecases.UseCaseCallBack
import me.slaheddine.leboncoin.presentation.models.AlbumItem

class AlbumViewModel(var getAlbumUseCase : GetAlbumsUseCase) : ViewModel() {

    val albumListLiveData: MutableLiveData<List<AlbumItem>> = MutableLiveData()
    val failure : MutableLiveData<Unit> = MutableLiveData()

    fun loadAlbums() {
        getAlbumUseCase.execute(0, object: UseCaseCallBack<List<AlbumItem>> {
            override fun onSuccess(it: List<AlbumItem>) {
                albumListLiveData.value = it
            }

            override fun onFailure(error: Throwable) {
                failure.value = Unit;
            }
        })
    }
}
