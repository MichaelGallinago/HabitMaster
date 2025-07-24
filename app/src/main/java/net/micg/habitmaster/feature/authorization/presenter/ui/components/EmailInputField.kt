package net.micg.habitmaster.feature.authorization.presenter.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.R

@Composable
fun EmailInputField(
    email: String,
    errorMessage: String?,
    onEmailChange: (String) -> Unit
) {
    val isError = errorMessage != null

    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        label = { Text(stringResource(R.string.email)) },
        isError = isError,
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )

    if (!isError) return

    Text(
        text = errorMessage,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier.padding(start = 16.dp, top = 4.dp)
    )
}
