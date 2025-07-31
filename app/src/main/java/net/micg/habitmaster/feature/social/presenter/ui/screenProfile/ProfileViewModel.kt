package net.micg.habitmaster.feature.social.presenter.ui.screenProfile

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import net.micg.habitmaster.utils.StringUtils
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ProfileViewModel(

) : ViewModel() {
    val avatarUrl by mutableStateOf<String?>(null)
    val username by mutableStateOf(StringUtils.EMPTY_STRING)
    val email by mutableStateOf(StringUtils.EMPTY_STRING)
    val password by mutableStateOf(StringUtils.EMPTY_STRING)
    var isPasswordVisible by mutableStateOf(false)

    fun onLogout() {
    }

    fun onProfileImageSelected(imageUrl: Uri) {
    }
}
