package net.micg.habitmaster.di

import net.micg.habitmaster.di.modules.AppModule
import net.micg.habitmaster.di.modules.DataBaseModule.dataBaseModule
import net.micg.habitmaster.di.modules.MainViewModelModule.viewModelModule
import net.micg.habitmaster.di.modules.NetworkModule.networkModule
import org.koin.core.KoinApplication
import org.koin.dsl.KoinAppDeclaration

fun declareKoinApplication(
    config: KoinAppDeclaration? = null
): KoinApplication.() -> Unit = {
    config?.invoke(this)
    modules(
        networkModule,
        dataBaseModule,
        viewModelModule,
        *AppModule.appModule.toTypedArray(),
    )
}
