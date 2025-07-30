package net.micg.habitmaster.feature.authorization.domain.implementations

import net.micg.habitmaster.feature.authorization.data.model.SignInData
import net.micg.habitmaster.feature.authorization.data.userRepository.UserRepository
import net.micg.habitmaster.feature.authorization.domain.interfaces.SaveSignInDataUseCase
import net.micg.habitmaster.feature.authorization.presenter.model.SignInDataUi
import org.koin.core.annotation.Single

@Single
class SaveSignInDataUseCaseImpl(
    private val userRepository: UserRepository
) : SaveSignInDataUseCase {
    override suspend fun invoke(data: SignInDataUi) =
        userRepository.setUserData(data.run { SignInData(username, password) })
}
