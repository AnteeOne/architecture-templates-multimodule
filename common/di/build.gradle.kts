plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.kotlinKapt)
}

dependencies {
    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)
}
