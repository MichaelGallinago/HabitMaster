package net.micg.habitmaster.feature.habits.di

import net.micg.habitmaster.feature.habits.presenter.ui.screenCreateHabit.CreateHabitViewModel
import net.micg.habitmaster.feature.habits.presenter.ui.screenHabitList.HabitListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

object HabitsViewModelModule {
    val viewModelModule = module {
        viewModel<HabitListViewModel> {
            HabitListViewModel()
        }

        viewModel<CreateHabitViewModel> {
            CreateHabitViewModel()
        }
    }
}
