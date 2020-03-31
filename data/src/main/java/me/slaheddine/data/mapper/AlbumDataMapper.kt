package me.slaheddine.data.mapper

import me.slaheddine.data.models.AlbumData
import me.slaheddine.domain.models.Album


class AlbumDataMapper constructor() {

    fun transform(data: AlbumData): Album {

            return Album(
                data.albumId,
                data.id,
                data.thumbnailUrl,
                data.title,
                data.url
            )

    }


    fun transform(list : List<AlbumData>) : List<Album> {
        val result : MutableList<Album> = ArrayList()
        if (list != null) {
            for (entity : AlbumData in list) {
                var album = transform(entity)
                if (album!=null) {
                    result.add(album)
                }
            }
        }
        return result
    }


}