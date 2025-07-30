package net.micg.habitmaster.feature.habits.data.habitRepository

import net.micg.habitmaster.feature.habits.data.database.dao.HabitDao
import org.koin.core.annotation.Single

@Single
class HabitRepositoryImpl(
    private val habitDao: HabitDao
) : HabitRepository {

}
