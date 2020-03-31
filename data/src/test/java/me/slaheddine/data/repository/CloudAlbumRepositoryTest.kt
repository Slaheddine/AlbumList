package me.slaheddine.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import junit.framework.Assert
import kotlinx.coroutines.runBlocking
import me.slaheddine.data.MockData
import me.slaheddine.data.mapper.AlbumDataMapper
import me.slaheddine.data.network.AlbumsRestApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class CloudAlbumRepositoryTest {

    private lateinit var cloudAlbumRepository : CloudAlbumRepository
    private lateinit var albumsRestApi : AlbumsRestApi

    @Mock
    private lateinit var mockContext: Context

    @Mock
    private lateinit var albumDataMapper: AlbumDataMapper

    @Mock
    private lateinit var connectivityManager : ConnectivityManager

    @Mock
    private lateinit var networkInfo : NetworkInfo

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        albumsRestApi = AlbumsRestApi(mockContext, "https://static.leboncoin.fr/");
        cloudAlbumRepository = CloudAlbumRepository(albumsRestApi, albumDataMapper)
    }

    @Test
    fun readStringFromContext_LocalizedString() {

        val lstAlbums = arrayListOf(MockData().album1, MockData().album1, MockData().album3, MockData().album4)
        runBlocking {

            `when`(mockContext.getSystemService(Context.CONNECTIVITY_SERVICE)).thenAnswer { return@thenAnswer connectivityManager }
            `when`(connectivityManager.activeNetworkInfo).thenAnswer { return@thenAnswer networkInfo}
            `when`(networkInfo.isConnected).thenAnswer { return@thenAnswer true}
            `when`(albumsRestApi.getService().getAlbums()).thenAnswer { return@thenAnswer lstAlbums }
             Assert.assertTrue(cloudAlbumRepository.getAlbums().size == 2)


            /*
            val context = Mockito.mock(Context::class.java)
            val connManager = Mockito.mock(ConnectivityManager::class.java)
            val networkInfo = Mockito.mock(NetworkInfo::class.java)

            `when`(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connManager)
            `when`(connManager.activeNetworkInfo).thenReturn(networkInfo)
            `when`(networkInfo.isConnected).thenReturn(true)

            Assert.assertTrue(cloudAlbumRepository.getAlbums().size == 2)
             */
        }

    }
}