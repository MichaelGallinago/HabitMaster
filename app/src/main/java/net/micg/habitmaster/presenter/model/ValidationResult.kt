package net.micg.habitmaster.presenter.model

import androidx.annotation.StringRes

data class ValidationResult(
    val isError: Boolean,
    @field:StringRes val errorResId: Int? = null,
    val formatArg: Any? = null
)
