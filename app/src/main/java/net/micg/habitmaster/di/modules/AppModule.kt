package net.micg.habitmaster.di.modules

import net.micg.habitmaster.feature.authorization.di.AuthorizationModule.authorizationModules

object AppModule {
    val appModule = authorizationModules
}
