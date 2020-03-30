package me.slaheddine.domain.usecases

abstract class UseCase<X,T> {
    abstract suspend operator fun invoke(x:X) : T
}