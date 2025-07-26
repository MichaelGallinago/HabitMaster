package net.micg.habitmaster.feature.authorization.presenter.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import net.micg.habitmaster.utils.StringUtils

@Composable
fun ValidatingOutlinedTextField(
    value: String,
    keyboardType: KeyboardType,
    label: String,
    errorMessage: String,
    validatorHasErrors: Boolean,
    icon: ImageVector,
    textStyle: TextStyle = LocalTextStyle.current,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    updateState: (String) -> Unit
) = OutlinedTextField(
    leadingIcon = { Icon(icon, contentDescription = StringUtils.EMPTY_STRING) },
    modifier = Modifier.fillMaxWidth(),
    keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
    value = value,
    onValueChange = updateState,
    isError = validatorHasErrors,
    visualTransformation = visualTransformation,
    singleLine = true,
    textStyle = textStyle,
    trailingIcon = trailingIcon,
    label = { Text(label) },
    supportingText = {
        if (validatorHasErrors)
            Text(errorMessage)
    },
)
