package me.slaheddine.domain.usecases

import me.slaheddine.domain.models.Album
import me.slaheddine.domain.repository.AlbumsRepository

class GetAlbumsUseCase (private val albumRepo: AlbumsRepository) : UseCase<Unit, List<Album>>() {

    override suspend fun invoke(x: Unit): List<Album> = albumRepo.getAlbums();
}