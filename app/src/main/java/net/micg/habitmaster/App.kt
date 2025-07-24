package net.micg.habitmaster

import android.app.Application
import net.micg.habitmaster.di.modules.AppModule.appModule
import net.micg.habitmaster.di.modules.DataBaseModule.dataBaseModule
import net.micg.habitmaster.di.modules.DataModule.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(
                dataModule,
                dataBaseModule,
                *appModule.toTypedArray(),
            )
        }
    }
}
