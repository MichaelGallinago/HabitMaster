package net.micg.habitmaster.feature.habits.presenter.ui.screenHabitList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import net.micg.habitmaster.feature.habits.presenter.models.HabitUi
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HabitListViewModel(

) : ViewModel() {
    val habits by mutableStateOf<List<HabitUi>>(emptyList())

    fun onHabitChecked(habit: HabitUi, isChecked: Boolean) {

    }
}
