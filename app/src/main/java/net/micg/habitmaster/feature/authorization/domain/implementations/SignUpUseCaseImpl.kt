package net.micg.habitmaster.feature.authorization.domain.implementations

import android.content.Context
import net.micg.habitmaster.data.state.DataState.Companion.toDataState
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepository
import net.micg.habitmaster.feature.authorization.data.model.SignUpData
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignUpUseCase
import net.micg.habitmaster.feature.authorization.presenter.model.SignUpDataUi

class SignUpUseCaseImpl(
    private val repository: AuthRepository,
    private val context: Context
) : SignUpUseCase {
    override suspend fun invoke(data: SignUpDataUi) =
        repository.signUp(data.run { SignUpData(username, password) }).toDataState(context)
}
