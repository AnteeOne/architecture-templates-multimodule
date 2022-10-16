package tech.antee.compose_multimodule_template.multi_compose

import android.content.Context
import androidx.compose.runtime.compositionLocalOf

interface CommonProvider {
    val context: Context
}

val LocalCommonProvider = compositionLocalOf<CommonProvider> { error("No common provider found!") }
