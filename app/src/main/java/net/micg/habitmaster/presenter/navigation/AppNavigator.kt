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

@Composable
fun AppNavigator(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Destinations.SIGN_IN) {
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
                onAddHabitClick = { navController.navigate(Destinations.CREATE_HABIT) }
            )
        }
        composable(Destinations.CREATE_HABIT) {
            CreateHabitScreen(modifier)
        }
    }
}

private fun NavHostController.navigateFromAuth() =
    navigate(Destinations.HABIT_LIST) { popUpTo(0) { inclusive = true } }
