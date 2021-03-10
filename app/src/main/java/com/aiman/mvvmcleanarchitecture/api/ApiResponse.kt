package com.aiman.mvvmcleanarchitecture.api

import io.reactivex.annotations.NonNull
import io.reactivex.annotations.Nullable

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}

class ApiResponse<T> private constructor(
    val status: Status, @param:Nullable @field:Nullable
    val data: T?, @param:Nullable @field:Nullable
    val error: Throwable?
) {
    companion object {

        fun <T> loading(): ApiResponse<T> {
            return ApiResponse(Status.LOADING, null, null)
        }

        fun <T> success(@NonNull data: T?): ApiResponse<T> {
            return ApiResponse(Status.SUCCESS, data, null)
        }

        fun <T> error(@NonNull error: Throwable): ApiResponse<T> {
            return ApiResponse(Status.ERROR, null, error)
        }

    }
}