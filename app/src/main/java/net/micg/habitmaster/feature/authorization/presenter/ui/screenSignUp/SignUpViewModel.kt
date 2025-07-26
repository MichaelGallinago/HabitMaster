package net.micg.habitmaster.feature.authorization.presenter.ui.screenSignUp

import android.util.Patterns
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.micg.habitmaster.R
import net.micg.habitmaster.data.state.DataState
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignUpUseCase
import net.micg.habitmaster.presenter.model.LengthError
import net.micg.habitmaster.utils.StringUtils

class SignUpViewModel(
    private val singUpUseCase: SignUpUseCase
) : ViewModel() {
    var isPasswordsVisible by mutableStateOf(false)
    var signUpState by mutableStateOf<DataState<Unit>>(DataState.Loading)

    var username by mutableStateOf(StringUtils.EMPTY_STRING)
    val usernameError by derivedStateOf {
        LengthError.validate(
            username, 3, 100, R.string.short_username_error, R.string.long_username_error
        )
    }

    var email by mutableStateOf(StringUtils.EMPTY_STRING)
    val emailHasErrors by derivedStateOf {
        email.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    var password by mutableStateOf(StringUtils.EMPTY_STRING)
    val passwordError by derivedStateOf {
        LengthError.validate(
            password, 8, 100, R.string.short_password_error, R.string.long_password_error
        )
    }

    var confirmPassword by mutableStateOf(StringUtils.EMPTY_STRING)
    val confirmPasswordError by derivedStateOf {
        LengthError.validate(
            confirmPassword, 8, 100, R.string.short_password_error, R.string.long_password_error
        )
    }

    val isFormValid by derivedStateOf {
        username.isNotBlank() && !usernameError.isError &&
        email.isNotBlank() && !emailHasErrors &&
        password.isNotBlank() && !passwordError.isError &&
        confirmPassword.isNotBlank() && !confirmPasswordError.isError &&
        confirmPassword == password
    }

    fun signUp() = viewModelScope.launch(Dispatchers.IO) {
        if (!isFormValid) return@launch
        signUpState = singUpUseCase(username, password)
    }

    fun onGoogleAuthClick() {
        println("Google Auth Clicked")
    }

    fun onTelegramAuthClick() {
        println("Telegram Auth Clicked")
    }
}
