package me.slaheddine.domain.usecases

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.slaheddine.domain.models.Album
import me.slaheddine.domain.repository.AlbumsRepository

class GetAlbumsUseCase (private val albumRepo: AlbumsRepository) : UseCase<Int, List<Album>>() {

    override fun execute(x: Int, callBack: UseCaseCallBack<List<Album>>) {

        var observable = albumRepo.getAlbums();
        var result = observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                callBack.onSuccess(it)
            }, { error ->
                callBack.onFailure(error)
            })
    }
}