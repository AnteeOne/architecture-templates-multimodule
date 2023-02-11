package tech.antee.compose_multimodule_template

import android.app.Application
import tech.antee.compose_multimodule_template.di.AppProvider
import tech.antee.compose_multimodule_template.di.DaggerAppComponent

// TODO("Implement your app")
class MyApplication : Application() {

    lateinit var appProvider: AppProvider

    override fun onCreate() {
        super.onCreate()
        appProvider = DaggerAppComponent.factory().create(this).apply {
            inject(this@MyApplication)
        }
    }
}

val Application.appProvider: AppProvider
    get() = (this as MyApplication).appProvider