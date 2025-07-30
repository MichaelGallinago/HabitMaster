package net.micg.habitmaster.feature.habits.di

import net.micg.habitmaster.data.database.HabitDatabase
import net.micg.habitmaster.feature.habits.data.database.dao.HabitDao
import net.micg.habitmaster.feature.habits.data.habitRepository.HabitRepository
import net.micg.habitmaster.feature.habits.data.habitRepository.HabitRepositoryImpl
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.dsl.module

@Module
class DataModule {
    @Single
    fun provideHabitRepository(habitDao: HabitDao): HabitRepository = HabitRepositoryImpl(habitDao)

    @Single
    fun provideHabitDao(habitDatabase: HabitDatabase): HabitDao = habitDatabase.habitDao()
}
