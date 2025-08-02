package net.micg.habitmaster.feature.authorization.presenter.ui.screenJokes

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.micg.habitmaster.data.state.DataState
import net.micg.habitmaster.feature.authorization.presenter.model.ChuckNorrisJokeUi
import net.micg.habitmaster.feature.authorization.presenter.ui.components.ChuckNorrisJokeItem
import org.koin.androidx.compose.koinViewModel


@Composable
fun JokesScreen(
    modifier: Modifier = Modifier,
    viewModel: JokesViewModel = koinViewModel(),
) = Column(modifier = modifier) {
    val joke = when (val state = viewModel.joke) {
        is DataState.Success -> state.value
        else -> ChuckNorrisJokeUi()
    }

    ChuckNorrisJokeItem(joke = joke) { viewModel.updateJoke() }
}
