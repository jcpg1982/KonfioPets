package pe.com.master.machines.konfiopets.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.com.master.machines.design.utils.Utils.backEnterTransition
import pe.com.master.machines.design.utils.Utils.backExitTransition
import pe.com.master.machines.design.utils.Utils.forwardEnterTransition
import pe.com.master.machines.design.utils.Utils.forwardExitTransition
import pe.com.master.machines.home.route.HomeRoute
import pe.com.master.machines.home.screen.HomeScreen

@Composable
fun NavigationWrapper(
    modifier: Modifier = Modifier,
    startDestination: Any
) {

    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        enterTransition = { forwardEnterTransition },
        exitTransition = { forwardExitTransition },
        popEnterTransition = { backEnterTransition },
        popExitTransition = { backExitTransition }
    ) {

        composable<HomeRoute> {
            HomeScreen(
                /*navigateToHome = {
                    navController.navigate(HomeRoute) {
                        popUpTo<SplashRoute> { inclusive = true }
                        launchSingleTop = true
                    }
                }*/
            )
        }
    }

}