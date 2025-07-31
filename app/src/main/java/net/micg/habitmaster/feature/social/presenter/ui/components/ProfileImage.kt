package net.micg.habitmaster.feature.social.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import net.micg.habitmaster.R

@Composable
fun ProfileImage(
    url: String?,
    onClick: () -> Unit,
) = Box(
    modifier = Modifier
        .size(256.dp)
        .clip(CircleShape)
        .clickable(onClick = onClick)
) {
    if (url != null) {
        AsyncImage(
            model = url,
            contentDescription = stringResource(R.string.avatar),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    } else {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = stringResource(R.string.no_avatar),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray.copy(alpha = 0.2f))
                .padding(16.dp)
        )
    }
}
