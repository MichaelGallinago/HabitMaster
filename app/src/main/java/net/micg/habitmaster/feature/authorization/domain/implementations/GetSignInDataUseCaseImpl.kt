package net.micg.habitmaster.feature.authorization.domain.implementations

import net.micg.habitmaster.feature.authorization.data.userRepository.UserRepository
import net.micg.habitmaster.feature.authorization.domain.interfaces.GetSignInDataUseCase
import net.micg.habitmaster.feature.authorization.presenter.model.SignInDataUi
import org.koin.core.annotation.Single

@Single
class GetSignInDataUseCaseImpl(
    private val userRepository: UserRepository
) : GetSignInDataUseCase {
    override suspend fun invoke() =
        userRepository.getUserData().run { SignInDataUi(username, password) }
}
