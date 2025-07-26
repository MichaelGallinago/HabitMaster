package net.micg.habitmaster.feature.authorization.di

import net.micg.habitmaster.feature.authorization.di.AuthorizationViewModelModule.viewModelModule
import net.micg.habitmaster.feature.authorization.di.DataModule.dataModule
import net.micg.habitmaster.feature.authorization.di.DomainModule.domainModule

object AuthorizationModule {
    val authorizationModules = viewModelModule + domainModule + dataModule
}
