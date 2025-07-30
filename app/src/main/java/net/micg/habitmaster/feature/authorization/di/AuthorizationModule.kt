package net.micg.habitmaster.feature.authorization.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module([DataModule::class, DomainModule::class])
@ComponentScan("net.micg.habitmaster.feature.authorization")
class AuthorizationModule
