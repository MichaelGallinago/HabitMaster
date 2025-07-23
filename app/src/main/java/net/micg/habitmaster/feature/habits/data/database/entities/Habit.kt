package net.micg.habitmaster.feature.habits.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Habit(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)
