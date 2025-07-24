package net.micg.habitmaster.data.profileImageRepository

import android.net.Uri

interface ProfileImageRepository {
    suspend fun get(): Uri?
    suspend fun set(uri: Uri): Uri?
}
