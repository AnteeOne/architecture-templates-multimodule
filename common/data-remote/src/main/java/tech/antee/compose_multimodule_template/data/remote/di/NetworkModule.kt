package tech.antee.compose_multimodule_template.data.remote.di

import dagger.Module

@Module(
    includes = [RetrofitModule::class, NetworkSourcesModule::class]
)
interface NetworkModule
