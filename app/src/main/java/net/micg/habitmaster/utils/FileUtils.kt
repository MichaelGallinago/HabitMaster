package net.micg.habitmaster.utils

import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable

object FileUtils {
    private const val IMAGE_DIALOGUE_FILTER = "image/*"

    @Composable
    fun rememberImageDialogue(onImageSelected: (Uri) -> Unit) = ImageDialogueLauncher(
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            uri?.let { onImageSelected(it) }
        }
    )

    @JvmInline
    value class ImageDialogueLauncher(
        private val launcher: ManagedActivityResultLauncher<String, Uri?>
    ) {
        fun launch() = launcher.launch(IMAGE_DIALOGUE_FILTER)
    }
}
