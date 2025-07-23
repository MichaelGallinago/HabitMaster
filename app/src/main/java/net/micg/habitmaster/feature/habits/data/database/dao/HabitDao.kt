package net.micg.habitmaster.feature.habits.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import net.micg.habitmaster.feature.habits.data.database.entities.Habit

@Dao
interface HabitDao {
    @Query("SELECT * FROM Habit ORDER BY name COLLATE NOCASE ASC")
    fun getAll(): Flow<List<Habit>>

    @Upsert
    suspend fun upsert(habit: Habit)

    @Query("DELETE FROM Habit WHERE id = :id")
    suspend fun delete(id: Int)
}
