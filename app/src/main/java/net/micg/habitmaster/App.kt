package net.micg.habitmaster

import android.app.Application
import net.micg.habitmaster.di.declareKoinApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            declareKoinApplication {
                androidContext(this@App)
                androidLogger(Level.DEBUG)
            }
        )
    }
}
