package net.micg.habitmaster.feature.authorization.presenter.ui.screenSignIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.R
import net.micg.habitmaster.data.state.DataState
import net.micg.habitmaster.feature.authorization.presenter.ui.components.AppLogo
import net.micg.habitmaster.feature.authorization.presenter.ui.components.ExternalAuthorizations
import net.micg.habitmaster.feature.authorization.presenter.ui.components.ValidatingOutlinedPasswordField
import net.micg.habitmaster.feature.authorization.presenter.ui.components.ValidatingOutlinedTextField
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = koinViewModel(),
    onSignIn: () -> Unit = {},
    onSignUpClicked: () -> Unit = {},
) = Column(
    modifier = modifier
        .fillMaxSize()
        .padding(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    AppLogo()

    ValidatingOutlinedTextField(
        value = viewModel.username.value,
        keyboardType = KeyboardType.Unspecified,
        label = stringResource(R.string.username),
        errorMessage = viewModel.username.errorMessage(),
        validatorHasErrors = viewModel.username.hasError,
        updateState = { viewModel.username.value = it },
        icon = Icons.Rounded.Person
    )

    Spacer(Modifier.height(4.dp))

    ValidatingOutlinedPasswordField(
        value = viewModel.password.value,
        label = stringResource(R.string.password),
        isVisible = viewModel.isPasswordVisible,
        errorMessage = viewModel.password.errorMessage(),
        validatorHasErrors = viewModel.password.hasError,
        updateState = { viewModel.password.value = it },
        onPasswordVisibilityChanged = { viewModel.isPasswordVisible = it }
    )

    Spacer(Modifier.height(24.dp))

    Button(
        onClick = viewModel::signIn,
        enabled = viewModel.isFormValid,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(stringResource(R.string.sign_in))
    }

    Spacer(Modifier.height(8.dp))

    Button(
        onClick = onSignUpClicked,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(stringResource(R.string.sign_up))
    }

    when (val state = viewModel.signInState) {
        is DataState.Success -> onSignIn()
        is DataState.Failure -> Text(state.message, color = Color.Red)
        else -> {}
    }

    Spacer(Modifier.height(32.dp))

    ExternalAuthorizations(viewModel::authViaGoogle, viewModel::authViaTelegram)
}
