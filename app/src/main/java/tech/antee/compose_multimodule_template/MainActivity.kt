package tech.antee.compose_multimodule_template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import tech.antee.compose_multimodule_template.di.LocalAppProvider
import tech.antee.compose_multimodule_template.styles.theme.MyApplicationTheme

// TODO("Implement your app")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                GlobalDependenciesProvider {
                    Navigation()
                }
            }
        }
    }

    @Composable
    private fun Navigation(modifier: Modifier = Modifier) {
        val navController = rememberNavController()
        val destinations = LocalAppProvider.current.destinations
//        val someFeature = destinations.find<SomeFeature>()
//        val anotherFeature = destinations.find<AnotherFeature>()

//        Box(modifier.fillMaxSize()) {
//            NavHost(navController, someFeature.featureRoute) {
//                with(someFeature) { composable(navController, destinations) }
//                with(anotherFeature) { composable(navController, destinations) }
//            }
//        }
    }

    @Composable
    private fun GlobalDependenciesProvider(
        content: @Composable () -> Unit
    ) {
        CompositionLocalProvider(
            LocalAppProvider provides application.appProvider,
            content = content
        )
    }
}
