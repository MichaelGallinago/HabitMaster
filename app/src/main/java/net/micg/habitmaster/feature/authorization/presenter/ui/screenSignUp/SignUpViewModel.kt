package net.micg.habitmaster.feature.authorization.presenter.ui.screenSignUp

import android.net.Uri
import android.util.Patterns
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import net.micg.habitmaster.utils.StringUtils

class SignUpViewModel() : ViewModel() {
    var username by mutableStateOf(StringUtils.EMPTY_STRING)
        private set

    var email by mutableStateOf(StringUtils.EMPTY_STRING)
        private set
    val emailHasErrors by derivedStateOf {
        email.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    var password by mutableStateOf(StringUtils.EMPTY_STRING)
        private set

    private val _profileImageUri = MutableStateFlow<Uri?>(null)
    val profileImageUri: StateFlow<Uri?> = _profileImageUri.asStateFlow()

    val isFormValid: Boolean
        get() = username.isNotBlank() && email.isNotBlank() && password.isNotBlank()

    fun updateUsername(newUsername: String) {
        username = newUsername
    }

    fun updateEmail(newEmail: String) {
        email = newEmail
    }

    fun updatePassword(newPassword: String) {
        password = newPassword
    }

    fun updateProfileImage(uri: Uri?) {
        if (uri == null) return

    }

    fun signUp() {
        if (!isFormValid) return

    }

    private fun validateEmail(email: String) =
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) "Incorrect email format" else null
}
