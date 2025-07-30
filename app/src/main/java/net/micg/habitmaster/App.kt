package net.micg.habitmaster

import android.app.Application
import net.micg.habitmaster.di.modules.AppModule
import net.micg.habitmaster.di.modules.DataBaseModule
import net.micg.habitmaster.presenter.ui.MainViewModelModule
import net.micg.habitmaster.di.modules.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import org.koin.ksp.generated.*

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(
                DataBaseModule().module,
                NetworkModule().module,
                MainViewModelModule().module,
                AppModule().module
            )
        }
    }
}
