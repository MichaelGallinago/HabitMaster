package net.micg.habitmaster.data.api

import io.ktor.client.statement.HttpResponse
import net.micg.habitmaster.feature.authorization.data.model.SignInRequest
import net.micg.habitmaster.feature.authorization.data.model.SignUpRequest

interface HabitMasterApi {
    suspend fun signUp(request: SignUpRequest): HttpResponse
    suspend fun signIn(request: SignInRequest): HttpResponse
}
