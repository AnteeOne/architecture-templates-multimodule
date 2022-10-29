package tech.antee.compose_multimodule_template.data.di

import dagger.Module
import tech.antee.compose_multimodule_template.data.local.di.LocalModule
import tech.antee.compose_multimodule_template.data.remote.di.NetworkModule

@Module(
    includes = [
        NetworkModule::class,
        LocalModule::class
    ]
)
interface DataModule
