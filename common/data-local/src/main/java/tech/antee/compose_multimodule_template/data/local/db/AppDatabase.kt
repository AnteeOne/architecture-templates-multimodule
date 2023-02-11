package tech.antee.compose_multimodule_template.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import tech.antee.compose_multimodule_template.data.local.dao.AppDao
import tech.antee.compose_multimodule_template.data.local.entities.MockEntity

@Database(
    entities = [MockEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao


    companion object {
        const val NAME = "mock-app-database"
    }
}


