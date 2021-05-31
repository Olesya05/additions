package com.politeh.helper.data.repositories.tasks

import androidx.lifecycle.LiveData
import com.politeh.helper.database.models.Task

interface TasksRepository {

    fun getTasks(): LiveData<List<Task>>

    fun saveTask(task: Task)

    fun updateTask(task: Task)

    fun deleteTask(task: Task)
}