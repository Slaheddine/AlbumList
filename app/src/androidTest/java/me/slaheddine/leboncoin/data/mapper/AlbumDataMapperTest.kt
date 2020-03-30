package me.slaheddine.leboncoin.data.mapper

import me.slaheddine.data.models.AlbumData
import me.slaheddine.domain.models.Album
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class AlbumDataMapperTest {

    lateinit var sut : me.slaheddine.data.mapper.AlbumDataMapper

    @Before
    fun setUp() {
        sut = me.slaheddine.data.mapper.AlbumDataMapper()
    }

    fun albumAssert(dataAlbum : me.slaheddine.data.models.AlbumData?, domainAlbum : me.slaheddine.domain.models.Album?) {
        assertEquals(dataAlbum?.albumId, domainAlbum?.albumId)
        assertEquals(dataAlbum?.id, domainAlbum?.id)
        assertEquals(dataAlbum?.thumbnailUrl, domainAlbum?.thumbnailUrl)
        assertEquals(dataAlbum?.title, domainAlbum?.title)
        assertEquals(dataAlbum?.url, domainAlbum?.url)
    }

    @Test
    fun dataMapper_dataAlbum_identicalDomainAlbumReturned() {
        var albumData = me.slaheddine.data.models.AlbumData(
            1,
            10,
            "https://domain.com/img.jpg",
            "ttitle",
            "https://domain.com/url1"
        )
        var domainData = sut.transform(albumData)

        albumAssert(albumData, domainData)
    }

    @Test
    fun dataMapper_dataAlbumList_identicalDomainAlbumListReturned() {
        var albumData1 = me.slaheddine.data.models.AlbumData(
            1,
            10,
            "https://domain.com/img.jpg",
            "ttitle",
            "https://domain.com/url1"
        )
        var albumData2 = me.slaheddine.data.models.AlbumData(
            2,
            11,
            "https://domain.com/img1.jpg",
            "ttitle1",
            "https://domain.com/url2"
        )
        var albumData3 = me.slaheddine.data.models.AlbumData(
            3,
            12,
            "https://domain.com/img2.jpg",
            "ttitle2",
            "https://domain.com/url3"
        )
        var albumData4 = me.slaheddine.data.models.AlbumData(
            4,
            13,
            "https://domain.com/img3.jpg",
            "ttitle3",
            "https://domain.com/url4"
        )

        val listAlbumData = listOf(albumData1, albumData2, albumData3, albumData4)
        var domainDataList = sut.transform(listAlbumData)

        for(album in domainDataList) {
            albumAssert(listAlbumData.get(domainDataList.indexOf(album)), album)
        }

    }
}