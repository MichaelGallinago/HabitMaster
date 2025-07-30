package net.micg.habitmaster.feature.authorization.di

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import net.micg.habitmaster.data.api.HabitMasterApi
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepository
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepositoryImpl
import net.micg.habitmaster.feature.authorization.data.userRepository.UserRepository
import net.micg.habitmaster.feature.authorization.data.userRepository.UserRepositoryImpl
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class DataModule {
    @Single
    fun provideAuthRepository(api: HabitMasterApi): AuthRepository = AuthRepositoryImpl(api)

    @Single
    fun provideUserRepository(context: Context): UserRepository =
        UserRepositoryImpl(context, usernameKey, passwordKey)

    companion object {
        private val usernameKey = stringPreferencesKey("username")
        private val passwordKey = stringPreferencesKey("password")
    }
}
