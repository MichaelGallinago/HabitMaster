package net.micg.habitmaster.feature.authorization.data.userRepository

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import net.micg.habitmaster.feature.authorization.data.model.SignInData
import net.micg.habitmaster.utils.StringUtils
import org.koin.core.annotation.Single

@Single
class UserRepositoryImpl(
    private val context: Context,
    private val usernameKey: UsernameKey,
    private val passwordKey: PasswordKey,
) : UserRepository {
    private val Context.dataStore by preferencesDataStore(UserRepository::class.java.simpleName)

    override suspend fun setUserData(data: SignInData) {
        setPreferences(usernameKey.value, data.username)
        setPreferences(passwordKey.value, data.password)
    }

    override suspend fun getUserData() = SignInData(
        getPreferences(usernameKey.value) ?: StringUtils.EMPTY_STRING,
        getPreferences(passwordKey.value) ?: StringUtils.EMPTY_STRING
    )

    override suspend fun clearUserData() =
        setUserData(SignInData(StringUtils.EMPTY_STRING, StringUtils.EMPTY_STRING))

    private suspend fun <T> getPreferences(key: Preferences.Key<T>) =
        (context.dataStore.data.map { preferences ->
            preferences[key]
        }).first()

    private suspend fun <T> setPreferences(key: Preferences.Key<T>, value: T) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    companion object {
        private const val REPOSITORY_NAME = "userRepository"
    }
}
