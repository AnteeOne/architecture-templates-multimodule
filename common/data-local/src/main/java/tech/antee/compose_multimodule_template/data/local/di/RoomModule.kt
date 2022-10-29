package tech.antee.compose_multimodule_template.data.local.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import tech.antee.compose_multimodule_template.data.local.dao.AppDao
import tech.antee.compose_multimodule_template.data.local.db.AppDatabase
import tech.antee.compose_multimodule_template.di.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun appDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        AppDatabase.NAME
    ).build()

    @Provides
    @Singleton
    fun appDao(db: AppDatabase): AppDao = db.appDao()
}
