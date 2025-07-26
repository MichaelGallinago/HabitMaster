package net.micg.habitmaster.data.model

import okhttp3.CacheControl
import okhttp3.Interceptor
import java.io.IOException
import java.util.concurrent.TimeUnit

class CacheInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain) = chain
        .proceed(chain.request())
        .newBuilder()
        .header(NAME, CacheControl.Builder().maxAge(MAX_AGE, AGE_TYPE).build().toString())
        .build()

    companion object {
        private const val NAME = "Cache-Control"
        private const val MAX_AGE = 30
        private val AGE_TYPE = TimeUnit.MINUTES
    }
}
