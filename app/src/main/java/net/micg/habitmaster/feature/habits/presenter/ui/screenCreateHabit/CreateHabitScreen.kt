package net.micg.habitmaster.feature.habits.presenter.ui.screenCreateHabit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.R
import net.micg.habitmaster.feature.habits.presenter.ui.components.SquareOutlinedIconButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateHabitScreen(
    modifier: Modifier = Modifier,
    viewModel: CreateHabitViewModel = koinViewModel()
) = Column(
    modifier = modifier
        .fillMaxSize()
        .padding(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    OutlinedTextField(
        value = viewModel.name,
        onValueChange = { viewModel.name = it },
        label = { Text(stringResource(R.string.name)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )

    Spacer(Modifier.height(16.dp))

    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        SquareOutlinedIconButton(
            imageVector = ImageVector.vectorResource(R.drawable.ic_remove),
            onClick = { viewModel.updateFrequencyDays(viewModel.frequencyDays - 1) }
        )

        OutlinedTextField(
            value = viewModel.frequencyDays.toString(),
            onValueChange = viewModel::updateFrequencyDays,
            label = { Text(stringResource(R.string.interval_in_days)) },
            modifier = Modifier.weight(1f).height(64.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        SquareOutlinedIconButton(
            imageVector = Icons.Default.Add,
            onClick = { viewModel.updateFrequencyDays(viewModel.frequencyDays + 1) }
        )
    }

    Spacer(Modifier.height(24.dp))

    Button(
        onClick = viewModel::createHabit,
        shape = RoundedCornerShape(12.dp),
        enabled = viewModel.name.isNotEmpty(),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text(stringResource(R.string.add_habit))
    }
}
