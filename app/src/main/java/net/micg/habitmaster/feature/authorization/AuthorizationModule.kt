package net.micg.habitmaster.feature.authorization

import net.micg.habitmaster.feature.authorization.data.DataModule
import net.micg.habitmaster.feature.authorization.domain.DomainModule
import net.micg.habitmaster.feature.authorization.presenter.ui.ViewModelModule
import org.koin.core.annotation.Module

@Module([DataModule::class, DomainModule::class, ViewModelModule::class])
class AuthorizationModule
