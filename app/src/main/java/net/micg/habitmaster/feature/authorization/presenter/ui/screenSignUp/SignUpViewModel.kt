package net.micg.habitmaster.feature.authorization.presenter.ui.screenSignUp

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
import net.micg.habitmaster.presenter.model.FieldValidators.validateEmail
import net.micg.habitmaster.presenter.model.FieldValidators.validateLength
import net.micg.habitmaster.presenter.model.FieldValidators.validateMatch
import net.micg.habitmaster.presenter.model.ValidatedField
import net.micg.habitmaster.utils.StringUtils

class SignUpViewModel(
    private val singUpUseCase: SignUpUseCase
) : ViewModel() {
    var isPasswordsVisible by mutableStateOf(false)
    var signUpState by mutableStateOf<DataState<Unit>>(DataState.Loading)

    var username = ValidatedField(StringUtils.EMPTY_STRING,
        validateLength(3, 100, R.string.short_username_error, R.string.long_username_error)
    )
    var email = ValidatedField(StringUtils.EMPTY_STRING,
        validateEmail(R.string.incorrect_email_format)
    )
    var password = ValidatedField(StringUtils.EMPTY_STRING,
        validateLength(8, 100, R.string.short_password_error, R.string.long_password_error)
    )
    var confirmPassword = ValidatedField(StringUtils.EMPTY_STRING,
        validateMatch(R.string.passwords_do_not_match) { password.value },
        validateLength(8, 100, R.string.short_password_error, R.string.long_password_error)
    )

    val isFormValid by derivedStateOf {
        username.value.isNotBlank() && username.isValid &&
        email.value.isNotBlank() && email.isValid &&
        password.value.isNotBlank() && password.isValid &&
        confirmPassword.value.isNotBlank() && confirmPassword.isValid &&
        confirmPassword.value == password.value
    }

    fun signUp() = viewModelScope.launch(Dispatchers.IO) {
        if (!isFormValid) return@launch
        signUpState = singUpUseCase(username.value, password.value)
    }

    fun onGoogleAuthClick() {
        println("Google Auth Clicked")
    }

    fun onTelegramAuthClick() {
        println("Telegram Auth Clicked")
    }
}
