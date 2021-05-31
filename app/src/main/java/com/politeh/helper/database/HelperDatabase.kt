package com.politeh.helper.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.politeh.helper.database.HelperDatabase.Companion.VERSION
import com.politeh.helper.database.converters.Converters
import com.politeh.helper.database.daos.TaskDao
import com.politeh.helper.database.models.Task

@Database(
    entities = [
        Task::class
    ],
    version = VERSION
)
@TypeConverters(Converters::class)
abstract class HelperDatabase: RoomDatabase() {


    companion object {

        const val NAME = "helper_database.db"
        const val VERSION = 6
    }


    abstract val taskDao: TaskDao
}