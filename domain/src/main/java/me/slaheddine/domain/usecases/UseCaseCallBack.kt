package me.slaheddine.domain.usecases

interface UseCaseCallBack<T> {
    fun onSuccess(t : T)
    fun onFailure(error : Throwable)
}

abstract class UseCase<X,T> {
    abstract suspend operator fun invoke(x:X) : T
}