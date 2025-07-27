package net.micg.habitmaster.feature.habits.presenter.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.R
import net.micg.habitmaster.feature.habits.presenter.models.HabitUi

@Composable
fun HabitIconsRow(habit: HabitUi) = Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(16.dp)
) {
    IconWithText(
        icon = ImageVector.vectorResource(R.drawable.ic_whatshot),
        text = habit.streak.toString()
    )
    IconWithText(
        icon = Icons.Default.FavoriteBorder,
        text = habit.likes.toString()
    )
    IconWithText(
        icon = ImageVector.vectorResource(R.drawable.ic_chat),
        text = habit.comments.toString()
    )

    if (habit.isRequiredToday) return@Row
    IconWithText(
        icon = ImageVector.vectorResource(R.drawable.ic_days_to_mark),
        text = "${habit.daysUntilNextMark} ${stringResource(R.string.days_short)}",
    )
}
