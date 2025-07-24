package net.micg.habitmaster.feature.authorization.presenter.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun ValidatingOutlinedTextField(
    value: String,
    keyboardType: KeyboardType,
    @StringRes labelId: Int,
    @StringRes errorMessageId: Int,
    validatorHasErrors: Boolean,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    updateState: (String) -> Unit
) = OutlinedTextField(
    modifier = Modifier.fillMaxWidth(),
    keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
    value = value,
    onValueChange = updateState,
    isError = validatorHasErrors,
    visualTransformation = visualTransformation,
    singleLine = true,
    label = { Text(stringResource(labelId)) },
    supportingText = {
        if (validatorHasErrors)
            Text(stringResource(errorMessageId))
    }
)
