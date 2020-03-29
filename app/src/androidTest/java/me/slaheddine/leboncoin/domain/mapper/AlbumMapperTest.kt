package me.slaheddine.leboncoin.domain.mapper

import me.slaheddine.leboncoin.domain.models.Album
import me.slaheddine.leboncoin.presentation.models.AlbumItem
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AlbumMapperTest {

    lateinit var sut : AlbumMapper

    @Before
    fun setUp() {
        sut = AlbumMapper()
    }

    fun albumAssert(domainAlbum : Album?, dataItem : AlbumItem?) {
        assertEquals(dataItem?.albumId, domainAlbum?.albumId)
        assertEquals(dataItem?.id, domainAlbum?.id)
        assertEquals(dataItem?.thumbnailUrl, domainAlbum?.thumbnailUrl)
        assertEquals(dataItem?.title, domainAlbum?.title)
        assertEquals(dataItem?.url, domainAlbum?.url)
    }

    @Test
    fun domainMapper_Album_identicalPresentationAlbumReturned() {
        var albumData = Album(1, 10, "https://domain.com/img.jpg","ttitle","https://domain.com/url1")
        var presentationData = sut.transform(albumData)

        albumAssert(albumData, presentationData)
    }

    @Test
    fun domainMapper_AlbumList_identicalPresentationAlbumListReturned() {
        var albumData1 = Album(1, 10, "https://domain.com/img.jpg","ttitle","https://domain.com/url1")
        var albumData2 = Album(2, 11, "https://domain.com/img1.jpg","ttitle1","https://domain.com/url2")
        var albumData3 = Album(3, 12, "https://domain.com/img2.jpg","ttitle2","https://domain.com/url3")
        var albumData4 = Album(4, 13, "https://domain.com/img3.jpg","ttitle3","https://domain.com/url4")

        val listAlbumData = listOf(albumData1, albumData2, albumData3, albumData4)
        var domainDataList = sut.transform(listAlbumData)

        for(album in domainDataList) {
            albumAssert(listAlbumData.get(domainDataList.indexOf(album)), album)
        }

    }
}