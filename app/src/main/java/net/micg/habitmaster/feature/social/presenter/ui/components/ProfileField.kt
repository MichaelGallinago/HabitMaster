package net.micg.habitmaster.feature.social.presenter.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import net.micg.habitmaster.utils.StringUtils

@Composable
fun ProfileField(
    label: String = StringUtils.EMPTY_STRING,
    value: String = StringUtils.EMPTY_STRING,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    fontFamily: FontFamily = FontFamily.Default
) = Column(
    modifier = Modifier
        .padding(horizontal = 8.dp)
) {
    Text(
        text = label,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    BasicTextField(
        value = value,
        onValueChange = {},
        readOnly = true,
        visualTransformation = visualTransformation,
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            color = MaterialTheme.colorScheme.onSurface,
            fontFamily = fontFamily
        ),
        modifier = Modifier
            .padding(vertical = 4.dp)
    )
}
