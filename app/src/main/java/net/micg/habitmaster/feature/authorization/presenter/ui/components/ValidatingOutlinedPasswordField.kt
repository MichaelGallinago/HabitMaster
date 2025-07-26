package net.micg.habitmaster.feature.authorization.presenter.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import net.micg.habitmaster.utils.StringUtils

@Composable
@Preview
fun ValidatingOutlinedPasswordField(
    value: String = StringUtils.EMPTY_STRING,
    label: String = StringUtils.EMPTY_STRING,
    isVisible: Boolean = false,
    errorMessage: String = StringUtils.EMPTY_STRING,
    validatorHasErrors: Boolean = false,
    updateState: (String) -> Unit = {},
    onPasswordVisibilityChanged: (Boolean) -> Unit = {},
) = ValidatingOutlinedTextField(
    value = value,
    keyboardType = KeyboardType.Password,
    label = label,
    errorMessage = errorMessage,
    validatorHasErrors = validatorHasErrors,
    visualTransformation =
        if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
    textStyle = TextStyle(fontFamily = FontFamily.Monospace),
    updateState = updateState,
    icon = Icons.Rounded.Lock,
    trailingIcon = { VisibilityButton(isVisible, onPasswordVisibilityChanged) }
)
