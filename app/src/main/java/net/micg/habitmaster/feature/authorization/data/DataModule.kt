package net.micg.habitmaster.feature.authorization.data

import androidx.datastore.preferences.core.stringPreferencesKey
import net.micg.habitmaster.feature.authorization.data.userRepository.PasswordKey
import net.micg.habitmaster.feature.authorization.data.userRepository.UsernameKey
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class DataModule {
    @Single
    fun providePasswordKey() = PasswordKey(stringPreferencesKey(PasswordKey::class.java.simpleName))

    @Single
    fun provideUsernameKey() = UsernameKey(stringPreferencesKey(UsernameKey::class.java.simpleName))
}
