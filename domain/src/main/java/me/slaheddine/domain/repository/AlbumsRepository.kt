package me.slaheddine.domain.repository

import me.slaheddine.domain.models.Album


interface AlbumsRepository {
    suspend fun getAlbums() : List<Album>
}
