package net.micg.habitmaster.feature.authorization.presenter.ui.screenJokes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.micg.habitmaster.data.state.DataState
import net.micg.habitmaster.feature.authorization.domain.interfaces.GetRandomJokeUseCase
import net.micg.habitmaster.feature.authorization.presenter.model.ChuckNorrisJokeUi
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class JokesViewModel(
    private val getRandomJokeUseCase: GetRandomJokeUseCase
): ViewModel() {
    var joke by mutableStateOf<DataState<ChuckNorrisJokeUi>>(DataState.Loading)

    fun updateJoke() = viewModelScope.launch(Dispatchers.IO) {
        joke = getRandomJokeUseCase()
    }
}
