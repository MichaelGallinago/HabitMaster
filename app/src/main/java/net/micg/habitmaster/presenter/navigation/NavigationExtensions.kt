package net.micg.habitmaster.presenter.navigation

import androidx.navigation.NavHostController

fun NavHostController.navigateFromAuth() =
    navigate(Destinations.HABIT_LIST) { popUpTo(0) { inclusive = true } }
