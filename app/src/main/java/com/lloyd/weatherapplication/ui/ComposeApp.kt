package com.lloyd.weatherapplication.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lloyd.weatherapplication.ui.dashboard.DashboardActivity
import com.lloyd.weatherapplication.ui.details.DetailActivity


@Composable
fun ComposeApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.DASHBOARD
    ) {
        composable(Route.DASHBOARD) { backStackEntry ->
            DashboardActivity(
                onUserClick = { location ->
                    // In order to discard duplicated navigation events, we check the Lifecycle
                    if (backStackEntry.lifecycle.currentState == Lifecycle.State.RESUMED) {
                        navController.navigate("${Route.DETAIL}/$location")
                    }
                }
            )
        }
        composable(
            route = "${Route.DETAIL}/{${Argument.LOCATION}}",
            arguments = listOf(
                navArgument(Argument.LOCATION) {
                    type = NavType.StringType
                }
            ),
        ) {
            DetailActivity()
        }
    }
}

object Route {
    const val DASHBOARD = "dashboard"
    const val DETAIL = "detail"
}
object Argument {
    const val LOCATION = "location"
}