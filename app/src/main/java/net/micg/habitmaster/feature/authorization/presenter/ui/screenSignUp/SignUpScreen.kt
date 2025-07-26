package net.micg.habitmaster.feature.authorization.presenter.ui.screenSignUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.R
import net.micg.habitmaster.data.state.DataState
import net.micg.habitmaster.feature.authorization.presenter.ui.components.ExternalAuthorizations
import net.micg.habitmaster.feature.authorization.presenter.ui.components.ValidatingOutlinedPasswordField
import net.micg.habitmaster.feature.authorization.presenter.ui.components.ValidatingOutlinedTextField
import net.micg.habitmaster.feature.authorization.presenter.ui.components.VisibilityButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = koinViewModel(),
    onSignUp: () -> Unit = {},
) = Column(
    modifier = modifier
        .fillMaxSize()
        .padding(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    ValidatingOutlinedTextField(
        value = viewModel.username,
        keyboardType = KeyboardType.Unspecified,
        label = stringResource(R.string.username),
        errorMessage = viewModel.usernameError.asStringResource(),
        validatorHasErrors = viewModel.usernameError.isError,
        updateState = { viewModel.username = it },
        icon = Icons.Rounded.Person
    )

    Spacer(Modifier.height(4.dp))

    ValidatingOutlinedTextField(
        value = viewModel.email,
        keyboardType = KeyboardType.Email,
        label = stringResource(R.string.email),
        errorMessage = stringResource(R.string.incorrect_email_format),
        validatorHasErrors = viewModel.emailHasErrors,
        updateState = { viewModel.email = it },
        icon = Icons.Rounded.Email
    )

    Spacer(Modifier.height(4.dp))

    ValidatingOutlinedPasswordField(
        value = viewModel.password,
        label = stringResource(R.string.password),
        isVisible = viewModel.isPasswordsVisible,
        lengthError = viewModel.passwordError,
        updateState = { viewModel.password = it },
        onPasswordVisibilityChanged = { viewModel.isPasswordsVisible = it }
    )

    Spacer(Modifier.height(4.dp))

    ValidatingOutlinedPasswordField(
        value = viewModel.confirmPassword,
        label = stringResource(R.string.confirm_password),
        isVisible = viewModel.isPasswordsVisible,
        lengthError = viewModel.confirmPasswordError,
        updateState = { viewModel.confirmPassword = it },
        onPasswordVisibilityChanged = { viewModel.isPasswordsVisible = it }
    )

    Spacer(Modifier.height(12.dp))

    Button(
        onClick = viewModel::signUp,
        enabled = viewModel.isFormValid,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(stringResource(R.string.sign_up))
    }

    when (val state = viewModel.signUpState) {
        is DataState.Success -> onSignUp()
        is DataState.Failure -> Text(state.message, color = Color.Red)
        else -> {}
    }

    Spacer(Modifier.height(32.dp))

    ExternalAuthorizations(viewModel::onGoogleAuthClick, viewModel::onTelegramAuthClick)
}
