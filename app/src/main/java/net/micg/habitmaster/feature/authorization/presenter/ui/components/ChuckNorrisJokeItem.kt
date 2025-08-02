package net.micg.habitmaster.feature.authorization.presenter.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import net.micg.habitmaster.R
import net.micg.habitmaster.feature.authorization.presenter.model.ChuckNorrisJokeUi

@Composable
@Preview
fun ChuckNorrisJokeItem(
    modifier: Modifier = Modifier,
    joke: ChuckNorrisJokeUi = ChuckNorrisJokeUi(),
    onRefresh: () -> Unit = {},
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)
) {
    AsyncImage(
        model = joke.iconUrl,
        contentDescription = stringResource(R.string.chuck_norris_icon),
        modifier = Modifier.size(64.dp)
    )

    Spacer(modifier = Modifier.height(12.dp))

    Button(
        onClick = onRefresh,
        modifier = Modifier.wrapContentWidth()
    ) {
        Text(stringResource(R.string.get_new_joke))
    }

    Spacer(modifier = Modifier.height(12.dp))

    if (joke.url.isNotBlank()) {
        val uriHandler = LocalUriHandler.current
        Text(
            text = joke.value,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline
            ),
            modifier = Modifier.clickable { uriHandler.openUri(joke.url) }
        )
    } else {
        Text(
            text = joke.value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
