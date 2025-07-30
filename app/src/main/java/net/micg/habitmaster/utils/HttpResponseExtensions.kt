package net.micg.habitmaster.utils

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

object HttpResponseExtensions {
    suspend inline fun <reified T> HttpResponse.toResult() =
        if (!isSuccessful) toFailure() else when (T::class) {
            Unit::class -> Result.success(Unit as T)
            else -> (body() as? T)?.let {
                Result.success(it)
            } ?: Result.failure(Throwable(INCORRECT_DATA_ERROR_MESSAGE))
        }

    suspend inline fun <reified T> callApiCatching(
        crossinline apiCall: suspend () -> HttpResponse
    ) = runCatching { apiCall() }.fold(
        onSuccess = { it.toResult<T>() },
        onFailure = { Result.failure(it) }
    )

    val HttpResponse.isSuccessful
        get() = status.value in 200..299

    fun <T> HttpResponse.toFailure() =
        Result.failure<T>(Throwable(status.description))

    const val INCORRECT_DATA_ERROR_MESSAGE = "Response body contains incorrect data."
}
