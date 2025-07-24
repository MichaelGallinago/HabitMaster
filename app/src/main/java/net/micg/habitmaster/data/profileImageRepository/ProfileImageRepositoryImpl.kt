package net.micg.habitmaster.data.profileImageRepository

import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import androidx.core.net.toUri
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

class ProfileImageRepositoryImpl(
    private val context: Context,
    private val profileImagePreferencesKey: Preferences.Key<String>,
) : ProfileImageRepository {
    private val Context.dataStore by preferencesDataStore(REPOSITORY_NAME)

    override suspend fun get() =
        getPreferences(profileImagePreferencesKey)?.toUri()

    override suspend fun set(uri: Uri) = withContext(Dispatchers.IO) {
        copyFileToFilesDir(uri)?.let { copyUri ->
            setPreferences(profileImagePreferencesKey, copyUri.toString())
            copyUri
        }
    }

    private fun copyFileToFilesDir(uri: Uri) = try {
        val contentResolver = context.contentResolver

        val mimeType = contentResolver.getType(uri)
        val extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType) ?: return null

        val inputStream = contentResolver.openInputStream(uri) ?: return null

        val fileName = "profile.$extension"
        val file = File(context.filesDir, fileName)
        val outputStream = FileOutputStream(file)

        inputStream.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }

        file.toUri()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

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
        private const val REPOSITORY_NAME = "profileImageRepository"
    }
}
