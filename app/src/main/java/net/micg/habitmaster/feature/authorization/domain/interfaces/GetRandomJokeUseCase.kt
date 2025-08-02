package net.micg.habitmaster.feature.authorization.domain.interfaces

import net.micg.habitmaster.data.state.DataState
import net.micg.habitmaster.feature.authorization.presenter.model.ChuckNorrisJokeUi

interface GetRandomJokeUseCase {
    suspend operator fun invoke(): DataState<ChuckNorrisJokeUi>
}
