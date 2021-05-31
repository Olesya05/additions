package com.politeh.helper.data.stores.tasks

import androidx.lifecycle.LiveData
import androidx.room.*
import com.politeh.helper.database.daos.TaskDao
import com.politeh.helper.database.models.Task

class TasksDatabaseStore(
    private val taskDao: TaskDao
) {


    fun getTasks() : LiveData<List<Task>> {
        return taskDao.getTasks()
    }


    fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }


    fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }


    fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }


}