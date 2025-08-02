package net.micg.habitmaster.feature.authorization.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChuckNorrisJoke(
    @SerialName("icon_url") val iconUrl: String,
    val id: String,
    val url: String,
    val value: String
)
