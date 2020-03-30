package me.slaheddine.data.network


import io.reactivex.Observable
import me.slaheddine.data.models.AlbumData
import retrofit2.http.GET

interface RestApi {

    @GET("img/shared/technical-test.json")
    fun getAlbums(): Observable<List<AlbumData>>
}