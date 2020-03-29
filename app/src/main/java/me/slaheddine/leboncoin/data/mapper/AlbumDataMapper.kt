package me.slaheddine.leboncoin.data.mapper

import me.slaheddine.leboncoin.data.models.AlbumData
import me.slaheddine.leboncoin.domain.models.Album


class AlbumDataMapper constructor() {

    fun transform(data: AlbumData?): Album? {
        if (data != null) {
            return Album(
                data.albumId,
                data.id,
                data.thumbnailUrl,
                data.title,
                data.url
            )
        }
        return null
    }


    fun transform(list : List<AlbumData>?) : List<Album> {
        val result : MutableList<Album> = ArrayList()
        if (list != null) {
            for (movieEntity : AlbumData in list) {
                var station = transform(movieEntity)
                if (station!=null) {
                    result.add(station)
                }
            }
        }
        return result
    }


}