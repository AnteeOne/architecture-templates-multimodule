package tech.antee.compose_multimodule_template.multi_compose

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.composable

/**
 * Base interface for new feature. Use [ComposableFeature]
 * for implementation base simple case and [GraphFeature] if feature has
 * nested navigation and contains its own navigation subgraph. Use this interfaces extension function
 * instead standard navigation library for implementing multi-module navigation
 **/
interface Feature {

    val featureRoute: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()
}

/**
 * Use this interface for implementation base simple case.
 **/
interface ComposableFeature : Feature {

    fun NavGraphBuilder.composable(
        navController: NavHostController,
        destinations: Destinations
    ) {
        composable(featureRoute, arguments, deepLinks) { backStackEntry ->
            Composable(navController, destinations, backStackEntry)
        }
    }

    @Composable
    fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    )
}

/**
 * Use this interface if the feature has nested navigation and contains its own navigation subgraph
 **/
interface GraphFeature : Feature {

    fun NavGraphBuilder.navigation(navController: NavHostController, destinations: Destinations)
}
