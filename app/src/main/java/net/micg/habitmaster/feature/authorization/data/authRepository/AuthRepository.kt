package net.micg.habitmaster.feature.authorization.data.authRepository

import net.micg.habitmaster.feature.authorization.data.model.SignInRequest
import net.micg.habitmaster.feature.authorization.data.model.SignUpRequest

interface AuthRepository {
    suspend fun signIn(request: SignInRequest): Result<Unit>
    suspend fun signUp(request: SignUpRequest): Result<Unit>
}
