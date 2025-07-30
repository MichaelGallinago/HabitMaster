package net.micg.habitmaster.feature.authorization.domain.implementations

import android.content.Context
import net.micg.habitmaster.data.state.DataState
import net.micg.habitmaster.data.state.DataState.Companion.toDataState
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepository
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignInViaGoogleUseCase
import org.koin.core.annotation.Single

@Single
class SignInViaGoogleUseCaseImpl(
    private val repository: AuthRepository,
    private val context: Context
) : SignInViaGoogleUseCase {
    /*override suspend fun invoke(account) =
        repository.signIn(idToken).toDataState(context)*/
    override suspend fun invoke(): DataState<Unit> {
        TODO("Not yet implemented")
    }
}
