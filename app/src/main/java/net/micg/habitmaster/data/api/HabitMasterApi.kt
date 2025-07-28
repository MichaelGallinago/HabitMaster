package net.micg.habitmaster.data.api

import io.ktor.client.statement.HttpResponse
import net.micg.habitmaster.feature.authorization.data.model.SignInData
import net.micg.habitmaster.feature.authorization.data.model.SignUpData

interface HabitMasterApi {
    suspend fun signUp(request: SignUpData): HttpResponse
    suspend fun signIn(request: SignInData): HttpResponse
}
