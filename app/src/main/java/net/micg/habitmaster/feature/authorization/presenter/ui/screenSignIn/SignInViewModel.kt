package net.micg.habitmaster.feature.authorization.presenter.ui.screenSignIn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignInUseCase
import net.micg.habitmaster.utils.StringUtils

class SignInViewModel(
    private val singInUseCase: SignInUseCase
) : ViewModel() {
    var login by mutableStateOf(StringUtils.EMPTY_STRING)
        private set

    var password by mutableStateOf(StringUtils.EMPTY_STRING)
        private set

    val isSignInEnabled: Boolean
        get() = login.isNotBlank() && password.isNotBlank()

    fun onLoginChange(newLogin: String) {
        login = newLogin
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
    }

    fun onSignInClick() {
        println("Sign In with login=$login, password=$password")
    }

    fun onGoogleAuthClick() {
        println("Google Auth Clicked")
    }

    fun onTelegramAuthClick() {
        println("Telegram Auth Clicked")
    }
}
