package net.micg.habitmaster.feature.authorization.di

import net.micg.habitmaster.feature.authorization.domain.implementations.GetSignInDataUseCaseImpl
import net.micg.habitmaster.feature.authorization.domain.implementations.SaveSignInDataUseCaseImpl
import net.micg.habitmaster.feature.authorization.domain.implementations.SignInUseCaseImpl
import net.micg.habitmaster.feature.authorization.domain.implementations.SignInViaGoogleUseCaseImpl
import net.micg.habitmaster.feature.authorization.domain.implementations.SignUpUseCaseImpl
import net.micg.habitmaster.feature.authorization.domain.interfaces.GetSignInDataUseCase
import net.micg.habitmaster.feature.authorization.domain.interfaces.SaveSignInDataUseCase
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignInUseCase
import net.micg.habitmaster.feature.authorization.domain.interfaces.SignInViaGoogleUseCase
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
        single<SignInViaGoogleUseCase> {
            SignInViaGoogleUseCaseImpl(
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
        single<SaveSignInDataUseCase> {
            SaveSignInDataUseCaseImpl(userRepository = get())
        }
        single<GetSignInDataUseCase> {
            GetSignInDataUseCaseImpl(userRepository = get())
        }
    }
}
