package net.micg.habitmaster.feature.authorization.presenter.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.R

@Composable
@Preview(showBackground = true)
fun AppLogo() = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.padding(bottom = 32.dp)
) {
    Box {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.logo_shadow),
            contentDescription = stringResource(R.string.logo),
            tint = Color.Unspecified,
            modifier = Modifier.size(200.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.logo_star),
            contentDescription = stringResource(R.string.logo),
            tint = Color.Unspecified,
            modifier = Modifier.size(200.dp)
        )
    }

    Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold
    )
}
