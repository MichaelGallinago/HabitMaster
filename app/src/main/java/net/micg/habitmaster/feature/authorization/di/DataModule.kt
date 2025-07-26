package net.micg.habitmaster.feature.authorization.di

import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepository
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepositoryImpl
import org.koin.dsl.module

object DataModule {
    val dataModule = module {
        single<AuthRepository> {
            AuthRepositoryImpl(api = get())
        }
    }
}
