package net.micg.habitmaster.di.modules

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import net.micg.habitmaster.data.api.HabitMasterApi
import net.micg.habitmaster.data.api.HabitMasterApiImpl
import net.micg.habitmaster.data.model.CacheInterceptor
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class NetworkModule {
    @Single
    fun provideHabitMasterApi(client: HttpClient): HabitMasterApi = HabitMasterApiImpl(client)

    @Single
    fun provideHttpClient(): HttpClient = HttpClient(OkHttp) {
        engine {
            addInterceptor(CacheInterceptor())
        }

        install(HttpTimeout) {
            requestTimeoutMillis = REQUEST_TIME_OUT
        }

        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    useAlternativeNames = true
                    ignoreUnknownKeys = true
                    encodeDefaults = false
                }
            )
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.d(HTTP_LOGGING_TAG, message)
                }
            }
            level = LogLevel.ALL
        }

        install(ResponseObserver) {
            onResponse { response ->
                Log.d(RESPONSE_OBSERVER_TAG, response.status.value.toString())
            }
        }

        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }

    companion object {
        private const val REQUEST_TIME_OUT = 10000L
        private const val RESPONSE_OBSERVER_TAG = "HTTP status"
        private const val HTTP_LOGGING_TAG = "HttpLogging"
    }
}
