package net.micg.habitmaster.feature.authorization.presenter.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.R

@Composable
fun ExternalAuthorizations(
    onGoogleAuthClick: () -> Unit,
    onTelegramAuthClick: () -> Unit
) = Row(
    horizontalArrangement = Arrangement.spacedBy(24.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    ExternalAuthorizationButton(
        R.drawable.ic_google,
        R.string.sign_in_via_google,
        onGoogleAuthClick
    )
    ExternalAuthorizationButton(
        R.drawable.ic_telegram,
        R.string.sign_in_via_telegram,
        onTelegramAuthClick
    )
}
