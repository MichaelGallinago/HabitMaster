package net.micg.habitmaster.feature.authorization.presenter.ui.screenSignIn

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import net.micg.habitmaster.R
import net.micg.habitmaster.data.state.DataState
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignInUseCase
import net.micg.habitmaster.presenter.model.FieldValidators.validateLength
import net.micg.habitmaster.presenter.model.ValidatedField
import net.micg.habitmaster.utils.StringUtils

class SignInViewModel(
    private val singInUseCase: SignInUseCase
) : ViewModel() {
    var isPasswordVisible by mutableStateOf(false)
    var signInState by mutableStateOf<DataState<Unit>>(DataState.Loading)

    var username = ValidatedField(StringUtils.EMPTY_STRING,
        validateLength(3, 100, R.string.short_username_error, R.string.long_username_error)
    )
    var password = ValidatedField(StringUtils.EMPTY_STRING,
        validateLength(8, 100, R.string.short_password_error, R.string.long_password_error)
    )

    val isFormValid by derivedStateOf {
        username.value.isNotBlank() && username.isValid &&
        password.value.isNotBlank() && password.isValid
    }

    fun onSignInClick() {
        println("Sign In with login=${username.value}, password=${password.value}")
    }

    fun onGoogleAuthClick() {
        println("Google Auth Clicked")
    }

    fun onTelegramAuthClick() {
        println("Telegram Auth Clicked")
    }
}
