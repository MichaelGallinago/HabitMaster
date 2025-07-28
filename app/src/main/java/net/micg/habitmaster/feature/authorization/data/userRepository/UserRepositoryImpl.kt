package net.micg.habitmaster.feature.authorization.data.userRepository

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import net.micg.habitmaster.feature.authorization.data.model.SignInData
import net.micg.habitmaster.utils.StringUtils

class UserRepositoryImpl(
    private val context: Context,
    private val usernamePreferencesKey: Preferences.Key<String>,
    private val passwordPreferencesKey: Preferences.Key<String>,
) : UserRepository {
    private val Context.dataStore by preferencesDataStore(name = REPOSITORY_NAME)

    override suspend fun setUserData(data: SignInData) {
        setPreferences(usernamePreferencesKey, data.username)
        setPreferences(passwordPreferencesKey, data.password)
    }

    override suspend fun getUserData() = SignInData(
        getPreferences(usernamePreferencesKey) ?: StringUtils.EMPTY_STRING,
        getPreferences(passwordPreferencesKey) ?: StringUtils.EMPTY_STRING
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
