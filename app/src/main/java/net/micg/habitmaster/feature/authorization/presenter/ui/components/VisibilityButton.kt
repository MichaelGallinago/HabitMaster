package net.micg.habitmaster.feature.authorization.presenter.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.R

@Composable
@Preview
fun VisibilityButton(
    isVisible: Boolean = false,
    onVisibilityChanged: (isVisible: Boolean) -> Unit = {}
) = Icon(
    imageVector = ImageVector.vectorResource(
        if (isVisible) R.drawable.ic_visible else R.drawable.ic_invisible
    ),
    contentDescription = stringResource(R.string.switch_visibility),
    modifier = Modifier.clickable(
        onClick = { onVisibilityChanged(!isVisible) },
        indication = ripple(radius = 8.dp),
        interactionSource = null,
        role = Role.Button
    )
)
