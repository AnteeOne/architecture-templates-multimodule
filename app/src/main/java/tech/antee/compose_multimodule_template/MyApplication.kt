package tech.antee.compose_multimodule_template

import android.app.Application
import tech.antee.compose_multimodule_template.di.AppProvider

// TODO("Implement your app")
class MyApplication : Application() {

    lateinit var appProvider: AppProvider

//    override fun onCreate() {
//        super.onCreate()
//        appProvider = DaggerMyApplicationComponent.factory().create(this).apply {
//            inject(this@App)
//        }
//    }
}

val Application.appProvider: AppProvider
    get() = (this as MyApplication).appProvider