package me.slaheddine.leboncoin.domain.usecases

interface UseCaseCallBack<T> {
    fun onSuccess(t : T)
    fun onFailure(error : Throwable)
}

abstract class UseCase<X,T> {
    abstract fun execute(x:X, callBack: UseCaseCallBack<T>)
}