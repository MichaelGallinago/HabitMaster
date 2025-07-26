package net.micg.habitmaster.presenter.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import net.micg.habitmaster.utils.StringUtils

@Stable
class ValidatedField(
    initialValue: String = StringUtils.EMPTY_STRING,
    vararg validators: (String) -> ValidationResult
) {
    var value by mutableStateOf(initialValue)
    val hasError get() = validationResult.isError
    val isValid get() = !validationResult.isError
    val isValidAndNotBlank get() = !validationResult.isError && value.isNotBlank()

    private val validationResult by derivedStateOf {
        validators.firstOrNull { it(value).isError }?.invoke(value) ?: ValidationResult(false)
    }

    @Composable
    @ReadOnlyComposable
    fun errorMessage() = validationResult.run {
        if (isError && errorResId != null) {
            if (formatArg != null)
                stringResource(errorResId, formatArg)
            else
                stringResource(errorResId)
        } else StringUtils.EMPTY_STRING
    }
}
