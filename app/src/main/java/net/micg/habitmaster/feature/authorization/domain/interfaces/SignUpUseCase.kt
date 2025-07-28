package net.micg.habitmaster.feature.authorization.domain.interfaces

import net.micg.habitmaster.data.state.DataState
import net.micg.habitmaster.feature.authorization.presenter.model.SignUpDataUi

fun interface SignUpUseCase {
    suspend operator fun invoke(data: SignUpDataUi): DataState<Unit>
}
