package net.micg.habitmaster.di

import androidx.compose.runtime.Composable
import org.koin.compose.KoinApplicationPreview

@Composable
fun PreviewDI(content: @Composable (() -> Unit)) {
    KoinApplicationPreview(declareKoinApplication(), content)
}
