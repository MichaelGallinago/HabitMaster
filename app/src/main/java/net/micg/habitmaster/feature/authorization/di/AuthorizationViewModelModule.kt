package net.micg.habitmaster.feature.authorization.di

import net.micg.habitmaster.feature.authorization.presenter.ui.screenSignIn.SignInViewModel
import net.micg.habitmaster.feature.authorization.presenter.ui.screenSignUp.SignUpViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

object AuthorizationViewModelModule {
    val viewModelModule = module {
        viewModel<SignInViewModel> {
            SignInViewModel(
                signInUseCase = get(),
                signInViaGoogleUseCase = get(),
                saveSignInDataUseCase = get()
            )
        }
        viewModel<SignUpViewModel> {
            SignUpViewModel(
                singUpUseCase = get(),
                saveSignInDataUseCase = get()
            )
        }
    }
}
