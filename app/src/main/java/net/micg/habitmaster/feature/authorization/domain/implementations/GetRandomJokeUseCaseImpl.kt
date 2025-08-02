package net.micg.habitmaster.feature.authorization.domain.implementations

import android.content.Context
import android.util.Log
import net.micg.habitmaster.data.state.DataState.Companion.mapInDataState
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepository
import net.micg.habitmaster.feature.authorization.domain.interfaces.GetRandomJokeUseCase
import net.micg.habitmaster.feature.authorization.presenter.model.ChuckNorrisJokeUi
import org.koin.core.annotation.Single

@Single
class GetRandomJokeUseCaseImpl(
    private val context: Context,
    private val repository: AuthRepository
): GetRandomJokeUseCase {
    override suspend fun invoke() = repository.getRandomJoke().mapInDataState(context) {
        Log.d("MYDEBUG", it.id)
        it.run { ChuckNorrisJokeUi(iconUrl, id, url, value) }
    }
}
