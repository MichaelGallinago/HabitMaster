package net.micg.habitmaster.feature.habits.presenter.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun IconWithText(
    icon: ImageVector,
    text: String,
    iconTint: Color = MaterialTheme.colorScheme.primary,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    onIconClick: (() -> Unit)? = null
) = Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp)
) {
    val modifier = if (onIconClick == null) Modifier else Modifier.clickable(
        onClick = onIconClick,
        role = Role.Button,
        interactionSource = null,
        indication = ripple(radius = 16.dp)
    )

    Icon(
        modifier = modifier
            .padding(4.dp)
            .scale(1.25f),
        imageVector = icon,
        contentDescription = null,
        tint = iconTint,
    )

    Text(
        text = text,
        style = textStyle,
    )
}
