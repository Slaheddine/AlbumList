package me.slaheddine.leboncoin.domain.repository

import io.reactivex.Observable
import me.slaheddine.leboncoin.domain.models.Album


interface AlbumsRepository {
    fun getAlbums() : Observable<List<Album>>
}
