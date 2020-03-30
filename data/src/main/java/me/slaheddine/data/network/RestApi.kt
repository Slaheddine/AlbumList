package me.slaheddine.data.network

import me.slaheddine.data.models.AlbumData
import retrofit2.http.GET

interface RestApi {

    @GET("img/shared/technical-test.json")
    suspend fun getAlbums(): List<AlbumData>
}