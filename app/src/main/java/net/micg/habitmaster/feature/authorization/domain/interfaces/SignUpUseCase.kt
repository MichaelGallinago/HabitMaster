package net.micg.habitmaster.feature.authorization.domain.interfaces

import net.micg.habitmaster.data.state.DataState

fun interface SignUpUseCase {
    suspend operator fun invoke(username: String, password: String): DataState<Unit>
}
