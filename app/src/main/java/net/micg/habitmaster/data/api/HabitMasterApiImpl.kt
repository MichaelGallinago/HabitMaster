package net.micg.habitmaster.data.api

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import net.micg.habitmaster.BuildConfig
import net.micg.habitmaster.feature.authorization.data.model.SignInData
import net.micg.habitmaster.feature.authorization.data.model.SignUpData

class HabitMasterApiImpl(private val client: HttpClient) : HabitMasterApi {
    override suspend fun signIn(request: SignInData) =
        client.post(SIGN_IN) { setBody(request) }
    override suspend fun signUp(request: SignUpData) =
        client.post(SIGN_UP) { setBody(request) }

    companion object {
        private const val SIGN_IN = BuildConfig.API_URL + "signin"
        private const val SIGN_UP = BuildConfig.API_URL + "signup"
    }
}
