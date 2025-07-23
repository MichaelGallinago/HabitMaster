package net.micg.habitmaster.feature.habits.di

import net.micg.habitmaster.feature.habits.di.HabitsViewModelModule.viewModelModule
import net.micg.habitmaster.feature.habits.di.DataModule.dataModule
import net.micg.habitmaster.feature.habits.di.DomainModule.domainModule

object HabitsModule {
    val habitsModules = viewModelModule + dataModule + domainModule
}
