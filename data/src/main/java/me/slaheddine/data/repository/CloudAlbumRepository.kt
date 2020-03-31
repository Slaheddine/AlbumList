package me.slaheddine.data.repository
import me.slaheddine.data.mapper.AlbumDataMapper

import me.slaheddine.data.network.AlbumsRestApi
import me.slaheddine.data.network.RestApi
import me.slaheddine.domain.models.Album
import me.slaheddine.domain.repository.AlbumsRepository


class CloudAlbumRepository(private var albumsRestApi : RestApi, private var mapper : AlbumDataMapper) :
    AlbumsRepository {

    override suspend fun getAlbums() : List<Album> {

        val listAlbum : MutableList<Album> = mutableListOf<Album>()

         albumsRestApi.getAlbums().forEach {
             mapper.transform(it)?.let { it1 -> listAlbum.add(it1) }
        }

        return listAlbum
    }
}
