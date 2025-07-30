package net.micg.habitmaster.di.modules

import android.content.Context
import androidx.room.Room
import net.micg.habitmaster.data.database.HabitDatabase
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class DataBaseModule {
    @Single
    fun provideHabitDatabase(context: Context) = Room.databaseBuilder(
        context = context,
        klass = HabitDatabase::class.java,
        HabitDatabase.NAME,
    ).build()
}
