package tech.antee.compose_multimodule_template.data.local.di

import dagger.Module

@Module(includes = [RoomModule::class])
interface LocalModule
