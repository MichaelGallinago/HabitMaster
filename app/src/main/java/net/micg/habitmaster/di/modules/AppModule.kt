package net.micg.habitmaster.di.modules

import net.micg.habitmaster.feature.authorization.di.AuthorizationModule.authorizationModules
import net.micg.habitmaster.feature.habits.di.HabitsModule.habitsModules
import net.micg.habitmaster.feature.social.di.SocialModule.socialModules

object AppModule {
    val appModule = authorizationModules + habitsModules + socialModules
}
