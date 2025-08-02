package net.micg.habitmaster.feature.authorization.data.authRepository

import net.micg.habitmaster.data.api.HabitMasterApi
import net.micg.habitmaster.feature.authorization.data.model.ChuckNorrisJoke
import net.micg.habitmaster.feature.authorization.data.model.FirebaseIdToken
import net.micg.habitmaster.feature.authorization.data.model.SignInData
import net.micg.habitmaster.feature.authorization.data.model.SignUpData
import net.micg.habitmaster.utils.HttpResponseExtensions.callApiCatching
import org.koin.core.annotation.Single

@Single
class AuthRepositoryImpl(private val api: HabitMasterApi) : AuthRepository {
    override suspend fun signIn(request: SignInData) = callApiCatching<Unit> {
        api.signIn(request)
    }

    override suspend fun signIn(idToken: FirebaseIdToken) = callApiCatching<Unit> {
        api.signIn(idToken)
    }

    override suspend fun signUp(request: SignUpData) = callApiCatching<Unit> {
        api.signUp(request)
    }

    override suspend fun getRandomJoke() = callApiCatching<ChuckNorrisJoke> {
        api.getRandomJoke()
    }
}
