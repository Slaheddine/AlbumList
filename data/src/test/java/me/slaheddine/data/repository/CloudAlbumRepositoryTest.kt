package me.slaheddine.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import junit.framework.Assert
import kotlinx.coroutines.runBlocking
import me.slaheddine.data.MockData
import me.slaheddine.data.mapper.AlbumDataMapper
import me.slaheddine.data.models.AlbumData
import me.slaheddine.data.network.AlbumsRestApi
import me.slaheddine.data.network.RestApi
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

    @Mock
    private lateinit var albumsRestApi : RestApi

    @Mock
    private lateinit var albumDataMapper: AlbumDataMapper

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        cloudAlbumRepository = CloudAlbumRepository(albumsRestApi, albumDataMapper)
    }

    @Test
    fun cloudAlbumRepository_getAlbums_returnSuccess() {

        val lstAlbums = arrayListOf(MockData().albumData1, MockData().albumData1, MockData().albumData1, MockData().albumData1)
        runBlocking {

            `when`(albumsRestApi.getAlbums()).thenAnswer { return@thenAnswer lstAlbums }
             Assert.assertTrue(cloudAlbumRepository.getAlbums().size == 4)
        }
    }

    @Test
    fun cloudAlbumRepository_getAlbums_returnEmpty() {

        runBlocking {

            `when`(albumsRestApi.getAlbums()).thenAnswer { return@thenAnswer emptyList<AlbumData>() }
            Assert.assertTrue(cloudAlbumRepository.getAlbums().isEmpty())
        }

    }
}