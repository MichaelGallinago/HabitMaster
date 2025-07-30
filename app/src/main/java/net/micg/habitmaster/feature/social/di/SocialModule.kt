package net.micg.habitmaster.feature.social.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module([DomainModule::class])
@ComponentScan("net.micg.habitmaster.feature.social")
class SocialModule
