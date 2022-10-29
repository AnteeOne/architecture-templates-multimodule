package tech.antee.compose_multimodule_template.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import tech.antee.compose_multimodule_template.data.local.dao.AppDao

@Database(
    entities = [],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao


    companion object {
        const val NAME = "app-database"
    }
}


