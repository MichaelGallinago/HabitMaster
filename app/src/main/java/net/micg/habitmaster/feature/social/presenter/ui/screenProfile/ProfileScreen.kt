package net.micg.habitmaster.feature.social.presenter.ui.screenProfile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.R
import net.micg.habitmaster.feature.authorization.presenter.ui.components.VisibilityButton
import net.micg.habitmaster.feature.social.presenter.ui.components.ProfileField
import net.micg.habitmaster.feature.social.presenter.ui.components.ProfileImage
import net.micg.habitmaster.utils.FileUtils.rememberImageDialogue
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = koinViewModel()
) {
    val launcher = rememberImageDialogue { viewModel.onProfileImageSelected(it) }
    ProfileScreenContent(modifier, viewModel, launcher::launch)
}

@Composable
private fun ProfileScreenContent(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = koinViewModel(),
    onProfileImageClick: () -> Unit
) = Column(
    modifier = modifier
        .fillMaxSize()
        .padding(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    ProfileImage(viewModel.avatarUrl, onProfileImageClick)

    Spacer(Modifier.height(64.dp))

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        ProfileField(stringResource(R.string.username), viewModel.username)
        ProfileField(stringResource(R.string.email), viewModel.email)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileField(
                label = stringResource(R.string.password),
                value = viewModel.password,
                fontFamily = FontFamily.Monospace,
                visualTransformation = if (viewModel.isPasswordVisible)
                    VisualTransformation.None else PasswordVisualTransformation(),
            )
            Spacer(Modifier.weight(1f))
            VisibilityButton(
                isVisible = viewModel.isPasswordVisible,
                onVisibilityChanged = { viewModel.isPasswordVisible = it }
            )
            Spacer(Modifier.width(4.dp))
        }
    }

    Spacer(Modifier.height(32.dp))

    OutlinedButton(
        onClick = viewModel::onLogout,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.error),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.log_out),
            color = MaterialTheme.colorScheme.error
        )
    }

    Spacer(Modifier.height(128.dp))
}
