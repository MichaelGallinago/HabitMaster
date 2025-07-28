package net.micg.habitmaster.di.modules

import net.micg.habitmaster.presenter.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

object MainViewModelModule {
    val viewModelModule = module {
        viewModel<MainViewModel> {
            MainViewModel(
                getSignInDataUseCase = get(),
                signInUseCase = get()
            )
        }
    }
}
