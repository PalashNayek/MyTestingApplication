package com.palash.mytestingapplication.utils

sealed class NetworkResult<T>(val data: T? = null, val message: String? = null) {

    class Loading<T> : NetworkResult<T>()
    class Success<T>(data: T?) : NetworkResult<T>(data)
    class Error<T>(error_smg: String?) : NetworkResult<T>(null, error_smg)
}