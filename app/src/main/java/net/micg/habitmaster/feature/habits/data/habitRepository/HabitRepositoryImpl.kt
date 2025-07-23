package net.micg.habitmaster.feature.habits.data.habitRepository

import net.micg.habitmaster.feature.habits.data.database.dao.HabitDao

class HabitRepositoryImpl(
    private val habitDao: HabitDao
) : HabitRepository {

}
