package net.micg.habitmaster.presenter.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.micg.habitmaster.data.state.DataState
import net.micg.habitmaster.feature.authorization.domain.interfaces.GetSignInDataUseCase
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignInUseCase
import net.micg.habitmaster.presenter.navigation.Destinations
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainViewModel(
    private val getSignInDataUseCase: GetSignInDataUseCase,
    private val signInUseCase: SignInUseCase
) : ViewModel() {
    var startDestination by mutableStateOf<String?>(null)
        private set

    fun updateStartDestination() = viewModelScope.launch(Dispatchers.IO) {
        startDestination = getSignInDataUseCase().run {
            if (password.isEmpty() || username.isEmpty()) {
                Destinations.SIGN_IN
            } else when(signInUseCase(this)) {
                is DataState.Success<Unit> -> Destinations.HABIT_LIST
                is DataState.Failure -> Destinations.SIGN_IN
                else -> null
            }
        }
    }
}
