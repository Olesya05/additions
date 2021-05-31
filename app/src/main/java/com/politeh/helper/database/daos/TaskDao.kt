package com.politeh.helper.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.politeh.helper.database.models.Task

@Dao
interface TaskDao {


    @Query("SELECT * FROM tasks")
    fun getTasks() : LiveData<List<Task>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)


    @Update
    fun updateTask(task: Task)


    @Delete
    fun deleteTask(task: Task)


}