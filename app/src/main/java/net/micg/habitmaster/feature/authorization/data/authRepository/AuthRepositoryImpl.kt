package net.micg.habitmaster.feature.authorization.data.authRepository

import net.micg.habitmaster.data.api.HabitMasterApi
import net.micg.habitmaster.feature.authorization.data.model.SignInData
import net.micg.habitmaster.feature.authorization.data.model.SignUpData
import net.micg.habitmaster.utils.HttpResponseExtensions.toResult

class AuthRepositoryImpl(private val api: HabitMasterApi) : AuthRepository {
    override suspend fun signIn(request: SignInData) = runCatching {
        api.signIn(request)
    }.fold(
        onSuccess = { response -> response.toResult() },
        onFailure = { throwable -> Result.failure(throwable) }
    )

    override suspend fun signUp(request: SignUpData) = runCatching {
        api.signUp(request)
    }.fold(
        onSuccess = { response -> response.toResult() },
        onFailure = { throwable -> Result.failure(throwable) }
    )
}
