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
import okhttp3.Interceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module

object NetworkModule {
    private const val REQUEST_TIME_OUT = 10000L
    private const val CACHE_INTERCEPTOR = "CacheInterceptor"

    val networkModule = module {
        single<Interceptor>(named(CACHE_INTERCEPTOR)) {
            CacheInterceptor()
        }

        single<HabitMasterApi> {
            HabitMasterApiImpl(
                HttpClient(OkHttp) {
                    engine {
                        addInterceptor(get<Interceptor>(named(CACHE_INTERCEPTOR)))
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
                                Log.d("HttpLogging:", message)
                            }
                        }
                        level = LogLevel.ALL
                    }

                    install(ResponseObserver) {
                        onResponse { response ->
                            Log.d("HTTP status:", response.status.value.toString())
                        }
                    }

                    defaultRequest {
                        contentType(ContentType.Application.Json)
                        accept(ContentType.Application.Json)
                    }
                }
            )
        }
    }
}
