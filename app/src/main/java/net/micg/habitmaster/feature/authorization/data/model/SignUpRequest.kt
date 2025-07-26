package net.micg.habitmaster.feature.authorization.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(val username: String, val password: String)
