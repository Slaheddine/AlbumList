package me.slaheddine.leboncoin.domain.usecases

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.slaheddine.leboncoin.data.repository.CloudAlbumRepository
import me.slaheddine.leboncoin.domain.mapper.AlbumMapper
import me.slaheddine.leboncoin.presentation.models.AlbumItem

class GetAlbumsUseCase (
    private val albumRepo: CloudAlbumRepository,
    private val mapper : AlbumMapper ) : UseCase<Void, List<AlbumItem>>() {

    override fun execute(x: Void, callBack: UseCaseCallBack<List<AlbumItem>>) {

        var observable = albumRepo.getAlbums();
        var result = observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                callBack.onSuccess(mapper.transform(it))
            }, { error ->
                callBack.onFailure(error)
            })
    }
}