package me.slaheddine.leboncoin

import me.slaheddine.data.models.AlbumData
import me.slaheddine.domain.models.Album

class  MockData {
    var albumData1 = Album(
        1,
        10,
        "https://domain.com/img.jpg",
        "ttitle",
        "https://domain.com/url1"
    )
    var albumData2 = Album(
        2,
        11,
        "https://domain.com/img1.jpg",
        "ttitle1",
        "https://domain.com/url2"
    )
    var albumData3 = Album(
        3,
        12,
        "https://domain.com/img2.jpg",
        "ttitle2",
        "https://domain.com/url3"
    )
    var albumData4 = Album(
        4,
        13,
        "https://domain.com/img3.jpg",
        "ttitle3",
        "https://domain.com/url4"
    )
}

