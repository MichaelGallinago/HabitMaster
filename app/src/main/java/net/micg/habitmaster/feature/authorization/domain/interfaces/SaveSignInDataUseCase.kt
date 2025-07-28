package net.micg.habitmaster.feature.authorization.domain.interfaces

import net.micg.habitmaster.feature.authorization.presenter.model.SignInDataUi

fun interface SaveSignInDataUseCase {
    suspend operator fun invoke(data: SignInDataUi)
}
