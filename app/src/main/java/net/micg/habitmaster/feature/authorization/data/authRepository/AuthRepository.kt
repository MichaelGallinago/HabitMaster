package net.micg.habitmaster.feature.authorization.data.authRepository

import net.micg.habitmaster.feature.authorization.data.model.ChuckNorrisJoke
import net.micg.habitmaster.feature.authorization.data.model.FirebaseIdToken
import net.micg.habitmaster.feature.authorization.data.model.SignInData
import net.micg.habitmaster.feature.authorization.data.model.SignUpData

interface AuthRepository {
    suspend fun signIn(request: SignInData): Result<Unit>
    suspend fun signIn(idToken: FirebaseIdToken): Result<Unit>
    suspend fun signUp(request: SignUpData): Result<Unit>
    suspend fun getRandomJoke(): Result<ChuckNorrisJoke>
}
