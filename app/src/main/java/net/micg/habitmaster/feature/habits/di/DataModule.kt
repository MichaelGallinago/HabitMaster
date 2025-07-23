package net.micg.habitmaster.feature.habits.di

import net.micg.habitmaster.feature.habits.data.habitRepository.HabitRepository
import net.micg.habitmaster.feature.habits.data.habitRepository.HabitRepositoryImpl
import org.koin.dsl.module

object DataModule {
    val dataModule = module {
        single<HabitRepository> {
            HabitRepositoryImpl(
                habitDao = get()
            )
        }
    }
}
