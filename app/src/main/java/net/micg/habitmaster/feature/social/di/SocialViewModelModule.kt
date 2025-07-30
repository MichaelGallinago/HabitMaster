package net.micg.habitmaster.feature.social.di

import androidx.lifecycle.viewmodel.compose.viewModel
import net.micg.habitmaster.feature.habits.presenter.ui.screenCreateHabit.CreateHabitViewModel
import net.micg.habitmaster.feature.habits.presenter.ui.screenHabitList.HabitListViewModel
import net.micg.habitmaster.feature.social.presenter.ui.screenFriends.FriendsViewModel
import net.micg.habitmaster.feature.social.presenter.ui.screenProfile.ProfileViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

object SocialViewModelModule {
    val viewModelModule = module {
        viewModel<FriendsViewModel> {
            FriendsViewModel()
        }

        viewModel<ProfileViewModel> {
            ProfileViewModel()
        }
    }
}
