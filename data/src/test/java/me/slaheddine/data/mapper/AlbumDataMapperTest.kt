package me.slaheddine.data.mapper

import me.slaheddine.data.MockData
import me.slaheddine.data.models.AlbumData
import me.slaheddine.domain.models.Album
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class AlbumDataMapperTest {

    lateinit var sut : AlbumDataMapper

    @Before
    fun setUp() {
        sut = AlbumDataMapper()
    }

    fun albumAssert(dataAlbum : AlbumData?, domainAlbum : Album?) {
        assertEquals(dataAlbum?.albumId, domainAlbum?.albumId)
        assertEquals(dataAlbum?.id, domainAlbum?.id)
        assertEquals(dataAlbum?.thumbnailUrl, domainAlbum?.thumbnailUrl)
        assertEquals(dataAlbum?.title, domainAlbum?.title)
        assertEquals(dataAlbum?.url, domainAlbum?.url)
    }

    @Test
    fun dataMapper_dataAlbum_identicalDomainAlbumReturned() {

        var domainData = sut.transform(MockData().albumData1)
        albumAssert(MockData().albumData1, domainData)
    }

    @Test
    fun dataMapper_dataAlbumList_identicalDomainAlbumListReturned() {

        val listAlbumData = listOf(MockData().albumData1, MockData().albumData2, MockData().albumData3, MockData().albumData4)
        var domainDataList = sut.transform(listAlbumData)

        for(album in domainDataList) {
            albumAssert(listAlbumData.get(domainDataList.indexOf(album)), album)
        }

    }
}