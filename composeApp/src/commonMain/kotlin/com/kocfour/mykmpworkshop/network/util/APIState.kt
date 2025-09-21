package com.kocfour.mykmpworkshop.network.util

sealed class APIState<out T> {
    data object Idle : APIState<Nothing>()

    data class Loading(val isLoading: Boolean) : APIState<Nothing>()
    data class Success<out T>(val data: T) : APIState<T>()
    data class Error(val message: String) : APIState<Nothing>()
}