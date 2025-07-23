package net.micg.habitmaster.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import net.micg.habitmaster.feature.habits.data.database.dao.HabitDao
import net.micg.habitmaster.feature.habits.data.database.entities.Habit

@Database(entities = [Habit::class], version = 1)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao

    companion object {
        const val NAME = "habit-database"
    }
}
