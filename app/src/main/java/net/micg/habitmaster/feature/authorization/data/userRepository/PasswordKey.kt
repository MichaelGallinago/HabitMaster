package net.micg.habitmaster.feature.authorization.data.userRepository

import androidx.datastore.preferences.core.Preferences

@JvmInline
value class PasswordKey(val value: Preferences.Key<String>)
