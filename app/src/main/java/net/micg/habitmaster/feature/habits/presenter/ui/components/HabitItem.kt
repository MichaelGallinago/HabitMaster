package net.micg.habitmaster.feature.habits.presenter.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.feature.habits.presenter.models.HabitUi

@Composable
fun HabitItem(
    habit: HabitUi,
    onCheckedChange: (Boolean) -> Unit,
) = Card(
    modifier = Modifier.fillMaxWidth(),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier
            .padding(12.dp)
            .weight(1f)
        ) {
            Text(
                text = habit.name,
                style = MaterialTheme.typography.titleLarge,
            )

            Spacer(Modifier.height(8.dp))

            HabitIconsRow(habit)
        }

        if (!habit.isRequiredToday) return@Row
        Checkbox(
            modifier = Modifier
                .scale(1.5f)
                .padding(horizontal = 8.dp),
            checked = habit.isDoneToday,
            onCheckedChange = onCheckedChange,
        )
    }
}
