package me.slaheddine.data

import me.slaheddine.data.models.AlbumData
import me.slaheddine.domain.models.Album

class  MockData {
    val albumData1 = AlbumData(
        1,
        10,
        "https://domain.com/img.jpg",
        "ttitle",
        "https://domain.com/url1"
    )
    val albumData2 = AlbumData(
        2,
        11,
        "https://domain.com/img1.jpg",
        "ttitle1",
        "https://domain.com/url2"
    )
    val albumData3 = AlbumData(
        3,
        12,
        "https://domain.com/img2.jpg",
        "ttitle2",
        "https://domain.com/url3"
    )
    val albumData4 = AlbumData(
        4,
        13,
        "https://domain.com/img3.jpg",
        "ttitle3",
        "https://domain.com/url4"
    )

    val album1 = Album(
        3,
        12,
        "https://domain.com/img2.jpg",
        "ttitle2",
        "https://domain.com/url3"
    )
    val album2 = Album(
        4,
        13,
        "https://domain.com/img3.jpg",
        "ttitle3",
        "https://domain.com/url4"
    )
    val album3 = Album(
        4,
        13,
        "https://domain.com/img3.jpg",
        "ttitle3",
        "https://domain.com/url4"
    )
    val album4 = Album(
        4,
        13,
        "https://domain.com/img3.jpg",
        "ttitle3",
        "https://domain.com/url4"
    )
}

