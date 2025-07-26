package net.micg.habitmaster.feature.authorization.data.authRepository

import net.micg.habitmaster.data.api.HabitMasterApi
import net.micg.habitmaster.feature.authorization.data.model.SignInRequest
import net.micg.habitmaster.feature.authorization.data.model.SignUpRequest
import net.micg.habitmaster.utils.HttpResponseUtils.toResult

class AuthRepositoryImpl(private val api: HabitMasterApi) : AuthRepository {
    override suspend fun signIn(request: SignInRequest) = runCatching {
        api.signIn(request)
    }.fold(
        onSuccess = { response -> response.toResult() },
        onFailure = { throwable -> Result.failure(throwable) }
    )

    override suspend fun signUp(request: SignUpRequest) = runCatching {
        api.signUp(request)
    }.fold(
        onSuccess = { response -> response.toResult() },
        onFailure = { throwable -> Result.failure(throwable) }
    )
}
