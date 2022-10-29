package tech.antee.compose_multimodule_template.di

import androidx.compose.runtime.compositionLocalOf
import tech.antee.compose_multimodule_template.multi_compose.Destinations

interface AppProvider {
    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }
