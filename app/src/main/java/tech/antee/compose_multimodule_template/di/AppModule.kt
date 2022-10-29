package tech.antee.compose_multimodule_template.di

import dagger.Module
import tech.antee.compose_multimodule_template.data.di.DataModule

@Module(
    includes = [DataModule::class]
)
interface AppModule
