package me.slaheddine.data.repository

import io.reactivex.Observable
import me.slaheddine.data.mapper.AlbumDataMapper

import me.slaheddine.data.network.AlbumsRestApi
import me.slaheddine.domain.repository.AlbumsRepository


class CloudAlbumRepository(private var albumsRestApi : AlbumsRestApi, private var mapper : AlbumDataMapper) :
    AlbumsRepository {

    override fun getAlbums(): Observable<List<me.slaheddine.domain.models.Album>> {
        return albumsRestApi.getService().getAlbums().map { mapper.transform(it) }
    }
}
