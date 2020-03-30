package me.slaheddine.leboncoin.data.repository

import io.reactivex.Observable
import me.slaheddine.leboncoin.data.mapper.AlbumDataMapper
import me.slaheddine.leboncoin.data.network.AlbumsRestApi
import me.slaheddine.leboncoin.domain.models.Album
import me.slaheddine.leboncoin.domain.repository.AlbumsRepository


class CloudAlbumRepository(var albumsRestApi : AlbumsRestApi, var mapper : AlbumDataMapper) : AlbumsRepository {

    override fun getAlbums(): Observable<List<Album>> {
        return albumsRestApi.getService().getAlbums().map { mapper.transform(it) }
    }
}
