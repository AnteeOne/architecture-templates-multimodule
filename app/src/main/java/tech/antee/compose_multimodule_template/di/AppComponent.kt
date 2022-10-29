package tech.antee.compose_multimodule_template.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tech.antee.compose_multimodule_template.MyApplication
import tech.antee.compose_multimodule_template.di.qualifiers.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, FeaturesModule::class])
interface AppComponent : AppProvider {

    fun inject(app: MyApplication)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context
        ): AppComponent
    }
}
