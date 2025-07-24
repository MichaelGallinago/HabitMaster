package net.micg.habitmaster.feature.authorization.presenter.ui.screenSignIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.R
import net.micg.habitmaster.feature.authorization.presenter.ui.components.AppLogo
import net.micg.habitmaster.feature.authorization.presenter.ui.components.ExternalAuthorizations
import org.koin.compose.koinInject

@Composable
@Preview
fun SignInScreen(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = koinInject()
) = Column(
    modifier = modifier
        .fillMaxSize()
        .padding(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    AppLogo()

    OutlinedTextField(
        value = viewModel.login,
        onValueChange = viewModel::onLoginChange,
        label = { Text(stringResource(R.string.login)) },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(Modifier.height(16.dp))

    OutlinedTextField(
        value = viewModel.password,
        onValueChange = viewModel::onPasswordChange,
        label = { Text(stringResource(R.string.password)) },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(Modifier.height(24.dp))

    Button(
        onClick = viewModel::onSignInClick,
        enabled = viewModel.isSignInEnabled,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(stringResource(R.string.sign_in))
    }

    Spacer(Modifier.height(8.dp))

    Button(
        onClick = viewModel::onSignUpClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(stringResource(R.string.sign_up))
    }

    Spacer(Modifier.height(32.dp))

    ExternalAuthorizations(viewModel::onGoogleAuthClick, viewModel::onTelegramAuthClick)
}
