package net.micg.habitmaster.feature.authorization.domain.implementations

import android.content.Context
import net.micg.habitmaster.data.state.DataState
import net.micg.habitmaster.data.state.DataState.Companion.toDataState
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepository
import net.micg.habitmaster.feature.authorization.data.model.SignUpRequest
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignUpUseCase

class SignUpUseCaseImpl(
    private val repository: AuthRepository,
    private val context: Context
) : SignUpUseCase {
    override suspend fun invoke(username: String, password: String) =
        repository.signUp(SignUpRequest(username, password)).toDataState(context)
}
