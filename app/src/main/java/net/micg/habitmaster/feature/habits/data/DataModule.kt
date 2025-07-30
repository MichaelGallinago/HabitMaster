package net.micg.habitmaster.feature.habits.data

import net.micg.habitmaster.data.database.HabitDatabase
import net.micg.habitmaster.feature.habits.data.database.dao.HabitDao
import net.micg.habitmaster.feature.habits.data.habitRepository.HabitRepository
import net.micg.habitmaster.feature.habits.data.habitRepository.HabitRepositoryImpl
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class DataModule {
    @Single
    fun provideHabitDao(habitDatabase: HabitDatabase): HabitDao = habitDatabase.habitDao()
}
