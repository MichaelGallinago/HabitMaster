package net.micg.habitmaster.feature.authorization.domain.implementations

import android.content.Context
import net.micg.habitmaster.data.state.DataState.Companion.toDataState
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepository
import net.micg.habitmaster.feature.authorization.data.model.SignInRequest
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignInUseCase

class SignInUseCaseImpl(
    private val repository: AuthRepository,
    private val context: Context
) : SignInUseCase {
    override suspend fun invoke(username: String, password: String) =
        repository.signIn(SignInRequest(username, password)).toDataState(context)
}
