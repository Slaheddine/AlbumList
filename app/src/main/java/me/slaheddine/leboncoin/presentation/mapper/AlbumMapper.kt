package me.slaheddine.leboncoin.presentation.mapper

import me.slaheddine.domain.models.Album
import me.slaheddine.leboncoin.presentation.models.AlbumItem

class AlbumMapper constructor() {

    fun transform(data: Album): AlbumItem {

        return AlbumItem(
                data.albumId,
                data.id,
                data.thumbnailUrl,
                data.title,
                data.url
            )
    }

    fun transform(list : List<Album>) : List<AlbumItem> {
        val result : MutableList<AlbumItem> = ArrayList()
        if (list != null) {
            for (entity : Album in list) {
                var albumsItem = transform(entity)
                if (albumsItem!=null) {
                    result.add(albumsItem)
                }
            }
        }
        return result
    }


}