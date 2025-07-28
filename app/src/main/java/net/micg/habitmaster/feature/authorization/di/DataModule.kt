package net.micg.habitmaster.feature.authorization.di

import androidx.datastore.preferences.core.stringPreferencesKey
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepository
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepositoryImpl
import net.micg.habitmaster.feature.authorization.data.userRepository.UserRepository
import net.micg.habitmaster.feature.authorization.data.userRepository.UserRepositoryImpl
import org.koin.dsl.module

object DataModule {
    val dataModule = module {
        single<AuthRepository> {
            AuthRepositoryImpl(api = get())
        }

        single<UserRepository> {
            UserRepositoryImpl(get(), USERNAME, PASSWORD)
        }
    }

    private val USERNAME = stringPreferencesKey("username")
    private val PASSWORD = stringPreferencesKey("password")
}
