package me.slaheddine.leboncoin.presentation.viewmodels

import androidx.lifecycle.ViewModel
import me.slaheddine.leboncoin.domain.usecases.GetAlbumsUseCase

class AlbumViewModel(var getAlbumUseCase : GetAlbumsUseCase) : ViewModel() {


    fun loadAlbums() {

    }
}
