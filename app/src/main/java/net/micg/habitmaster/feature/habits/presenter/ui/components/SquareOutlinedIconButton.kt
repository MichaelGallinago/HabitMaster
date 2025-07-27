package net.micg.habitmaster.feature.habits.presenter.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.utils.StringUtils

@Composable
fun SquareOutlinedIconButton(
    imageVector: ImageVector,
    onClick: () -> Unit = {}
) = OutlinedButton(
    shape = RoundedCornerShape(4.dp),
    modifier = Modifier.size(56.dp),
    onClick = onClick
) {
    Icon(
        modifier = Modifier.scale(2f),
        imageVector = imageVector,
        contentDescription = StringUtils.EMPTY_STRING
    )
}
