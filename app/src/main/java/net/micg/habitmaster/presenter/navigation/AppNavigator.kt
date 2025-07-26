package net.micg.habitmaster.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.micg.habitmaster.feature.authorization.presenter.ui.screenSignIn.SignInScreen
import net.micg.habitmaster.feature.authorization.presenter.ui.screenSignUp.SignUpScreen

@Composable
fun AppNavigator(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Destinations.SIGN_IN) {
        composable(Destinations.SIGN_IN) {
            SignInScreen(
                modifier,
                onSignIn = {},
                onSignUpClicked = { navController.navigate(Destinations.SIGN_UP) }
            )
        }
        composable(Destinations.SIGN_UP) {
            SignUpScreen(
                modifier,
                onSignUp = { navController.navigate(Destinations.SIGN_IN) }
            )
        }
    }
}
