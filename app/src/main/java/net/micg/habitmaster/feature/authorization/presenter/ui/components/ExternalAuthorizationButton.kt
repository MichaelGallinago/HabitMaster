package net.micg.habitmaster.feature.authorization.presenter.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun ExternalAuthorizationButton(
    @DrawableRes iconId: Int,
    @StringRes descriptionId: Int,
    onClick: () -> Unit
) = Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier
        .size(64.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.surface)
        .clickable(
            onClick = onClick,
            indication = ripple(radius = 32.dp),
            interactionSource = null,
            role = Role.Button
        )
) {
    Icon(
        painter = painterResource(iconId),
        contentDescription = stringResource(descriptionId),
        tint = Color.Unspecified,
        modifier = Modifier.size(48.dp),
    )
}
