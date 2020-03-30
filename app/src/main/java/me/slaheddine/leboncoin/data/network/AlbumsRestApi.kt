package me.slaheddine.leboncoin.data.network

import me.slaheddine.leboncoin.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AlbumsRestApi constructor() {

    private val service: RestApi

    init {
        service = createWebService<RestApi>(BuildConfig.BASE_URL)
    }

    private inline fun <reified T> createWebService(baseUrl: String): T {

        val httpClient = OkHttpClient.Builder()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(httpClient.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        var service = retrofit.create(T::class.java)

        return  service;
    }

    fun getService() : RestApi {
        return service;
    }
}