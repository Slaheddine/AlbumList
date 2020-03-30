package me.slaheddine.leboncoin.presentation.utils

sealed class DataResponse<out T>

data class Loading<out T>(val loading: Boolean) : DataResponse<T>()
data class Success<out T>(val data: T) : DataResponse<T>()
data class Failure<out T>(val throwable: Throwable? = null) : DataResponse<T>()
