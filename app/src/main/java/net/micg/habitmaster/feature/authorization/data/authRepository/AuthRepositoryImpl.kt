package net.micg.habitmaster.feature.authorization.data.authRepository

import net.micg.habitmaster.data.api.HabitMasterApi
import net.micg.habitmaster.feature.authorization.data.model.FirebaseIdToken
import net.micg.habitmaster.feature.authorization.data.model.SignInData
import net.micg.habitmaster.feature.authorization.data.model.SignUpData
import net.micg.habitmaster.utils.HttpResponseExtensions.callApiCatching

class AuthRepositoryImpl(private val api: HabitMasterApi) : AuthRepository {
    override suspend fun signIn(request: SignInData): Result<Unit> = callApiCatching {
        api.signIn(request)
    }
    override suspend fun signIn(idToken: FirebaseIdToken): Result<Unit> = callApiCatching {
        api.signIn(idToken)
    }
    override suspend fun signUp(request: SignUpData): Result<Unit> = callApiCatching {
        api.signUp(request)
    }
}
