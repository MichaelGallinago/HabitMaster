package net.micg.habitmaster.feature.authorization.di

import net.micg.habitmaster.feature.authorization.domain.implementations.SignInUseCaseImpl
import net.micg.habitmaster.feature.authorization.domain.implementations.SignUpUseCaseImpl
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignInUseCase
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignUpUseCase
import org.koin.dsl.module

object DomainModule {
    val domainModule = module {
        single<SignInUseCase> {
            SignInUseCaseImpl(
                repository = get(),
                context = get()
            )
        }

        single<SignUpUseCase> {
            SignUpUseCaseImpl(
                repository = get(),
                context = get()
            )
        }
    }
}
