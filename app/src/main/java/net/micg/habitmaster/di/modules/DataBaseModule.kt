package net.micg.habitmaster.di.modules

import androidx.room.Room
import net.micg.habitmaster.data.database.HabitDatabase
import org.koin.dsl.module

object DataBaseModule {
    val dataBaseModule = module {
        single<HabitDatabase> {
            Room.databaseBuilder(
                context = get(),
                klass = HabitDatabase::class.java,
                HabitDatabase.NAME,
            ).build()
        }
    }
}
