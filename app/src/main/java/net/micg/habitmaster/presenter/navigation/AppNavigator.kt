package net.micg.habitmaster.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.micg.habitmaster.feature.authorization.presenter.ui.screenSignIn.SignInScreen
import net.micg.habitmaster.feature.authorization.presenter.ui.screenSignUp.SignUpScreen
import net.micg.habitmaster.feature.habits.presenter.ui.screenCreateHabit.CreateHabitScreen
import net.micg.habitmaster.feature.habits.presenter.ui.screenHabitList.HabitListScreen
import net.micg.habitmaster.feature.social.presenter.ui.screenFriends.FriendsScreen
import net.micg.habitmaster.feature.social.presenter.ui.screenProfile.ProfileScreen

@Composable
fun AppNavigator(
    modifier: Modifier = Modifier,
    startDestination: String = Destinations.SIGN_IN
) {
    val navController = rememberNavController()
    NavHost(navController, startDestination) {
        composable(Destinations.SIGN_IN) {
            SignInScreen(
                modifier = modifier,
                onSignIn = navController::navigateFromAuth,
                onSignUpClicked = { navController.navigate(Destinations.SIGN_UP) }
            )
        }
        composable(Destinations.SIGN_UP) {
            SignUpScreen(
                modifier = modifier,
                onSignUp = navController::navigateFromAuth
            )
        }
        composable(Destinations.HABIT_LIST) {
            HabitListScreen(
                modifier = modifier,
                onAddHabitClick = { navController.navigate(Destinations.CREATE_HABIT) },
                onProfileClick = { navController.navigate(Destinations.PROFILE) }
            )
        }
        composable(Destinations.CREATE_HABIT) {
            CreateHabitScreen(modifier)
        }
        composable(Destinations.PROFILE) {
            ProfileScreen(modifier)
        }
        composable(Destinations.FRIENDS) {
            FriendsScreen(modifier)
        }
    }
}

private fun NavHostController.navigateFromAuth() =
    navigate(Destinations.HABIT_LIST) { popUpTo(0) { inclusive = true } }
