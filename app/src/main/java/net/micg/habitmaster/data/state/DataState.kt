package net.micg.habitmaster.data.state

import android.content.Context
import android.widget.Toast
import net.micg.habitmaster.R

sealed class DataState<out T> {
    data class Success<out T>(val value: T) : DataState<T>()
    data class Failure(val message: String) : DataState<Nothing>() {
        fun showFailureMessage(context: Context?) =
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    data object Loading : DataState<Nothing>()

    companion object {
        fun <T> Result<T>.toDataState(context: Context): DataState<T> = if (this.isSuccess) {
            this.getOrNull()?.let { Success(it) }
                ?: Failure(context.getString(R.string.data_was_null))
        } else this.exceptionOrNull()?.let {
            Failure(it.message ?: context.getString(R.string.unknown_error))
        } ?: Failure(context.getString(R.string.unknown_error))
    }
}
