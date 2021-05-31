package com.politeh.helper.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.politeh.helper.database.models.Task.Companion.TABLE_NAME
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@Entity(
    tableName = TABLE_NAME
)
data class Task(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = ID) var id: Int,
    @ColumnInfo(name = NAME) var name: String,
    @ColumnInfo(name = DATE) var date: LocalDate?,
    @ColumnInfo(name = TIME) var time: LocalTime?,
    @ColumnInfo(name = IS_DONE) var isDone: Boolean,
    @ColumnInfo(name = LIST_ID) var listId: Int
): Serializable {


    companion object {

        const val TABLE_NAME = "tasks"
        const val ID = "id"
        const val NAME = "name"
        const val DATE = "date"
        const val TIME = "time"
        const val IS_DONE = "is_done"
        const val LIST_ID = "list_id"
    }


    constructor(): this(
        id = 0,
        name = "",
        date = null,
        time = null,
        isDone = false,
        listId = 1
    )
}