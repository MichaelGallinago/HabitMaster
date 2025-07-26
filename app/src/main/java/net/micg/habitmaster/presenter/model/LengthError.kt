package net.micg.habitmaster.presenter.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import net.micg.habitmaster.utils.StringUtils

data class LengthError(
    val isError: Boolean,
    @param:StringRes private val resId: Int = 0,
    private val limit: Int = 0
) {
    @Composable
    @ReadOnlyComposable
    fun asStringResource() =
        if (isError) stringResource(resId, limit) else StringUtils.EMPTY_STRING

    companion object {
        fun validate(
            value: String,
            min: Int,
            max: Int,
            shortResId: Int,
            longResId: Int
        ) = if (value.isEmpty()) LengthError(false) else when {
            value.length < min -> LengthError(true, shortResId, min)
            value.length > max -> LengthError(true, longResId, max)
            else -> LengthError(false)
        }
    }
}
