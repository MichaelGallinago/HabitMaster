package net.micg.habitmaster.feature.social.di

import net.micg.habitmaster.feature.social.di.DomainModule.domainModule
import net.micg.habitmaster.feature.social.di.SocialViewModelModule.viewModelModule

object SocialModule {
    val socialModules = viewModelModule + domainModule
}
