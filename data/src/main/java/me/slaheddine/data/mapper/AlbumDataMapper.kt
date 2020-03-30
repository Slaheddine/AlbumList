package me.slaheddine.data.mapper

import me.slaheddine.data.models.AlbumData
import me.slaheddine.domain.models.Album


class AlbumDataMapper constructor() {

    fun transform(data: AlbumData?): Album? {
        if (data != null) {
            return me.slaheddine.domain.models.Album(
                data.albumId,
                data.id,
                data.thumbnailUrl,
                data.title,
                data.url
            )
        }
        return null
    }


    fun transform(list : List<AlbumData>?) : List<me.slaheddine.domain.models.Album> {
        val result : MutableList<me.slaheddine.domain.models.Album> = ArrayList()
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