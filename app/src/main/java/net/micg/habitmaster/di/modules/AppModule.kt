package net.micg.habitmaster.di.modules

import net.micg.habitmaster.feature.authorization.di.AuthorizationModule
import net.micg.habitmaster.feature.habits.di.HabitsModule
import net.micg.habitmaster.feature.social.di.SocialModule
import org.koin.core.annotation.Module

@Module([AuthorizationModule::class, HabitsModule::class, SocialModule::class])
class AppModule
