package net.micg.habitmaster.di.modules

import androidx.datastore.preferences.core.stringPreferencesKey
import net.micg.habitmaster.data.profileImageRepository.ProfileImageRepository
import net.micg.habitmaster.data.profileImageRepository.ProfileImageRepositoryImpl
import org.koin.dsl.module

object DataModule {
    val dataModule = module {
        single<ProfileImageRepository> {
            ProfileImageRepositoryImpl(context = get(), PROFILE_IMAGE)
        }
    }

    private val PROFILE_IMAGE = stringPreferencesKey("profile_image")
}
