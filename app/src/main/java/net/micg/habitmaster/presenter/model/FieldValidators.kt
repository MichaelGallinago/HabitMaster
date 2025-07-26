package net.micg.habitmaster.presenter.model

import android.util.Patterns
import androidx.annotation.StringRes

object FieldValidators {
    fun validateLength(
        min: Int,
        max: Int,
        @StringRes tooShort: Int,
        @StringRes tooLong: Int,
        validateIfEmpty: Boolean = false
    ) = { string: String ->
        if (!validateIfEmpty && string.isEmpty())
            ValidationResult(false)
        else when {
            string.length < min -> ValidationResult(true, tooShort, min)
            string.length > max -> ValidationResult(true, tooLong, max)
            else -> ValidationResult(false)
        }
    }

    fun validateEmail(@StringRes invalidEmail: Int) = { string: String ->
        if (string.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(string).matches()) {
            ValidationResult(true, invalidEmail)
        } else ValidationResult(false)
    }

    fun validateMatch(
        @StringRes mismatchError: Int,
        otherValueProvider: () -> String,
    ) = { string: String ->
        if (string.isNotEmpty() && string != otherValueProvider())
            ValidationResult(true, mismatchError)
        else
            ValidationResult(false)
    }
}
