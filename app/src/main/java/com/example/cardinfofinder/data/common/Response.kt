package com.example.cardinfofinder.data.common

class Result<T>(

    val status: ResultStatus,

    val data: T? = null,

    val message: String = "",
) {

    companion object {
        fun <T> Loading(): Result<T> = Result(ResultStatus.LOADING)

        fun <T> Error(message: String): Result<T> = Result(ResultStatus.ERROR, message = message)

        fun <T> Success(data: T): Result<T> = Result(ResultStatus.SUCCESS, data)
    }

}

enum class ResultStatus {
    LOADING, ERROR, SUCCESS
}