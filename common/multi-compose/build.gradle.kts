plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.kotlinKapt)
    id(Plugins.compose)
}

dependencies {
    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)

    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.viewModel)
    implementation(Deps.Compose.navigation)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)
}
