package net.micg.habitmaster.feature.authorization.domain.implementations

import android.content.Context
import net.micg.habitmaster.data.state.DataState.Companion.toDataState
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepository
import net.micg.habitmaster.feature.authorization.data.model.SignInData
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignInUseCase
import net.micg.habitmaster.feature.authorization.presenter.model.SignInDataUi

class SignInUseCaseImpl(
    private val repository: AuthRepository,
    private val context: Context
) : SignInUseCase {
    override suspend fun invoke(data: SignInDataUi) =
        repository.signIn(data.run { SignInData(username, password) } ).toDataState(context)
}
