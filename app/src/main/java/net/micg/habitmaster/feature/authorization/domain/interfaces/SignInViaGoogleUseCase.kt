package net.micg.habitmaster.feature.authorization.domain.interfaces

import net.micg.habitmaster.data.state.DataState

interface SignInViaGoogleUseCase {
    suspend operator fun invoke(): DataState<Unit>
}
