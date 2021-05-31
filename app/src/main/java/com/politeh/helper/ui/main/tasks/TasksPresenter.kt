package com.politeh.helper.ui.main.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.politeh.helper.data.repositories.tasks.TasksRepository
import com.politeh.helper.database.daos.TaskDao
import com.politeh.helper.database.models.Task
import com.politeh.helper.ui.base.mvp.presenters.BasePresenter

class TasksPresenter(
    private val view: TasksContract.View,
    private val tasksRepository: TasksRepository
): BasePresenter(), TasksContract.ActionListener {


    override lateinit var tasks: LiveData<List<Task>>




    override fun init() {
        tasks = tasksRepository.getTasks()
    }


    override fun onItemClickedListener(task: Task) {
        view.launchTaskActivity(task)
    }


    override fun onAddTaskMenuBtnClicked() {
        view.launchTaskActivity(Task())
    }


    override fun onItemCheckChanged(position: Int, isChecked: Boolean) {
        val newTask = tasks.value!![position]
        tasksRepository.updateTask(newTask.copy(isDone = isChecked))
    }


}