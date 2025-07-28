package net.micg.habitmaster.feature.authorization.domain.interfaces

import net.micg.habitmaster.feature.authorization.presenter.model.SignInDataUi

fun interface GetSignInDataUseCase {
    suspend operator fun invoke(): SignInDataUi
}
