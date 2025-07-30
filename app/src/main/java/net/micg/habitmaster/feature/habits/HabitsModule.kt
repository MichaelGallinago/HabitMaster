package net.micg.habitmaster.feature.habits

import net.micg.habitmaster.feature.habits.data.DataModule
import net.micg.habitmaster.feature.habits.domain.DomainModule
import net.micg.habitmaster.feature.habits.presenter.ui.ViewModelModule
import org.koin.core.annotation.Module

@Module(includes = [DataModule::class, DomainModule::class, ViewModelModule::class])
class HabitsModule
