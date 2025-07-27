package net.micg.habitmaster.di.modules

import net.micg.habitmaster.feature.authorization.di.AuthorizationModule.authorizationModules
import net.micg.habitmaster.feature.habits.di.HabitsModule.habitsModules

object AppModule {
    val appModule = authorizationModules + habitsModules
}
