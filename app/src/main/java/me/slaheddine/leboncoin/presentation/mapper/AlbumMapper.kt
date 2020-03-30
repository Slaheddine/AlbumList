package me.slaheddine.leboncoin.presentation.mapper

import me.slaheddine.domain.models.Album
import me.slaheddine.leboncoin.presentation.models.AlbumItem

class AlbumMapper constructor() {

    fun transform(data: Album?): AlbumItem? {
        if (data != null) {
            return AlbumItem(
                data.albumId,
                data.id,
                data.thumbnailUrl,
                data.title,
                data.url
            )
        }
        return null
    }

    fun transform(list : List<Album>?) : List<AlbumItem> {
        val result : MutableList<AlbumItem> = ArrayList()
        if (list != null) {
            for (movieEntity : Album in list) {
                var station = transform(movieEntity)
                if (station!=null) {
                    result.add(station)
                }
            }
        }
        return result
    }


}