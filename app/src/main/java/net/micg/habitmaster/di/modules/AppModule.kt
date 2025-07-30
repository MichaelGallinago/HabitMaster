package net.micg.habitmaster.di.modules

import net.micg.habitmaster.feature.authorization.AuthorizationModule
import net.micg.habitmaster.feature.habits.HabitsModule
import net.micg.habitmaster.feature.social.SocialModule
import org.koin.core.annotation.Module

@Module(includes = [AuthorizationModule::class, HabitsModule::class, SocialModule::class])
class AppModule
