package me.slaheddine.domain.repository

import io.reactivex.Observable
import me.slaheddine.domain.models.Album


interface AlbumsRepository {
    fun getAlbums() : Observable<List<Album>>
}
