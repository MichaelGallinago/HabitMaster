package net.micg.habitmaster.utils

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

object HttpResponseExtensions {
    suspend inline fun <reified T> HttpResponse.toResult(): Result<T> {
        if (!isSuccessful) return toFailure()

        val response = body() as? T
        if (response == null)
            return Result.failure(Throwable(INCORRECT_DATA_ERROR_MESSAGE))

        return Result.success(response)
    }

    fun HttpResponse.toResult() =
        if (isSuccessful) Result.success(Unit) else Result.failure(Throwable(status.description))

    val HttpResponse.isSuccessful
        get() = status.value in 200..299

    fun <T> HttpResponse.toFailure() =
        Result.failure<T>(Throwable(status.description))

    const val INCORRECT_DATA_ERROR_MESSAGE = "Response body contains incorrect data."
}
