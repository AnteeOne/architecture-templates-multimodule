plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
}

dependencies {
    projectImplementation(Modules.coreStrings)

    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.Coroutines.kotlinCore)
    implementation(Deps.inject)
}
