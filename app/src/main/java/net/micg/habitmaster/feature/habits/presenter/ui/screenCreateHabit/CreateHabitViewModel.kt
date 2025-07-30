package net.micg.habitmaster.feature.habits.presenter.ui.screenCreateHabit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import net.micg.habitmaster.utils.StringUtils
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class CreateHabitViewModel(

) : ViewModel() {
    var name by mutableStateOf(StringUtils.EMPTY_STRING)
    var frequencyDays by mutableIntStateOf(MIN_FREQUENCY)
        private set

    fun updateFrequencyDays(value: String) = value.toIntOrNull()?.let(this::updateFrequencyDays)
    fun updateFrequencyDays(value: Int) {
        frequencyDays = value.coerceIn(MIN_FREQUENCY, MAX_FREQUENCY)
    }

    fun createHabit() {

    }

    companion object {
        private const val MIN_FREQUENCY = 1
        private const val MAX_FREQUENCY = 365
    }
}
