package me.slaheddine.leboncoin.mapper

import me.slaheddine.leboncoin.MockData
import me.slaheddine.leboncoin.presentation.mapper.AlbumMapper
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

    fun albumAssert(domainAlbum : me.slaheddine.domain.models.Album?, dataItem : AlbumItem?) {
        assertEquals(dataItem?.albumId, domainAlbum?.albumId)
        assertEquals(dataItem?.id, domainAlbum?.id)
        assertEquals(dataItem?.thumbnailUrl, domainAlbum?.thumbnailUrl)
        assertEquals(dataItem?.title, domainAlbum?.title)
        assertEquals(dataItem?.url, domainAlbum?.url)
    }

    @Test
    fun domainMapper_Album_identicalPresentationAlbumReturned() {

        var presentationData = sut.transform(MockData().albumData1)

        albumAssert(MockData().albumData1, presentationData)
    }

    @Test
    fun domainMapper_AlbumList_identicalPresentationAlbumListReturned() {
        val listAlbumData = listOf(MockData().albumData1, MockData().albumData2, MockData().albumData3, MockData().albumData4)
        var domainDataList = sut.transform(listAlbumData)

        for(album in domainDataList) {
            albumAssert(listAlbumData.get(domainDataList.indexOf(album)), album)
        }

    }
}