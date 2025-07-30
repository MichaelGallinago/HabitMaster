package net.micg.habitmaster.feature.social

import net.micg.habitmaster.feature.social.domain.DomainModule
import net.micg.habitmaster.feature.social.presenter.ui.ViewModelModule
import org.koin.core.annotation.Module

@Module([DomainModule::class, ViewModelModule::class])
class SocialModule
