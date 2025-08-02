package net.micg.habitmaster.feature.authorization.presenter.model

import net.micg.habitmaster.utils.StringUtils

data class ChuckNorrisJokeUi(
    val iconUrl: String = StringUtils.EMPTY_STRING,
    val id: String = StringUtils.EMPTY_STRING,
    val url: String = StringUtils.EMPTY_STRING,
    val value: String = StringUtils.EMPTY_STRING,
)
