package net.micg.habitmaster.feature.authorization.di

import android.content.Context
import net.micg.habitmaster.feature.authorization.data.authRepository.AuthRepository
import net.micg.habitmaster.feature.authorization.data.userRepository.UserRepository
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
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.dsl.module

@Module
class DomainModule {
    @Single
    fun provideSignInUseCase(
        repository: AuthRepository,
        context: Context
    ): SignInUseCase = SignInUseCaseImpl(repository, context)

    @Single
    fun provideSignInViaGoogleUseCase(
        repository: AuthRepository,
        context: Context
    ): SignInViaGoogleUseCase = SignInViaGoogleUseCaseImpl(repository, context)

    @Single
    fun provideSignUpUseCase(
        repository: AuthRepository,
        context: Context
    ): SignUpUseCase = SignUpUseCaseImpl(repository, context)

    @Single
    fun provideSaveSignInDataUseCase(
        userRepository: UserRepository
    ): SaveSignInDataUseCase = SaveSignInDataUseCaseImpl(userRepository)

    @Single
    fun provideGetSignInDataUseCase(
        userRepository: UserRepository
    ): GetSignInDataUseCase = GetSignInDataUseCaseImpl(userRepository)
}
