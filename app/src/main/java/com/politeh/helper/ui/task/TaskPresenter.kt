package com.politeh.helper.ui.task

import com.politeh.helper.data.repositories.tasks.TasksRepository
import com.politeh.helper.database.models.Task
import com.politeh.helper.ui.base.mvp.presenters.BasePresenter
import com.politeh.helper.ui.utils.DateTimeStringFormatter
import java.time.LocalDate
import java.time.LocalTime

class TaskPresenter(
    private val view: TaskContract.View,
    private val tasksRepository: TasksRepository,
    private val dateTimeStringFormatter: DateTimeStringFormatter
): BasePresenter(), TaskContract.ActionListener {


    private lateinit var task: Task
    private lateinit var newTask: Task




    override fun init() {
        super.init()
        task = view.getTask()
        newTask = task.copy()

        view.setIsDone(task.isDone)
        if(task.name.isNotEmpty()) {
            view.setName(task.name)
        }
        refreshDateViews()
    }


    private fun refreshDateViews() = with(view) {
        if (task.date == null) {
            hideDateClearBtn()
            hideTimeViews()
            hideTimeClearBtn()
        } else {
            setDate(dateTimeStringFormatter.getFullDateString(task.date)!!)
            showDateClearBtn()
            refreshTimeViews()
        }
    }


    private fun refreshTimeViews() = with(view) {
        showTimeViews()

        if (task.time == null) {
            hideTimeClearBtn()
        } else {
            setTime(task.time.toString())
            showTimeClearBtn()
        }
    }


    override fun onSaveMenuBtnClicked() {
        with(task) {
            name = view.getNameContent()
            isDone = view.getIsDoneContent()

            date = dateTimeStringFormatter.getDateFromString(view.getDateContent())

            val timeString = view.getTimeContent()
            time = if(timeString.isNotEmpty()) {
                LocalTime.parse(timeString)
            } else { null }
        }

        tasksRepository.saveTask(task)
        view.closeActivity()
    }


    override fun onDeleteMenuBtnClicked() {
        tasksRepository.deleteTask(task)
        view.closeActivity()
    }


    override fun onDateBtnClicked() {
        view.showDatePickerDialog(task.date ?: LocalDate.now())
    }


    override fun onDatePicked(date: LocalDate) {
        task.date = date
        refreshDateViews()
    }


    override fun onDateClearBtnClicked() {
        task.date = null
        onTimeClearBtnClicked()
    }


    override fun onTimeBtnClicked() {
        view.showTimePickerDialog(task.time ?: LocalTime.now())
    }


    override fun onTimePicked(time: LocalTime) {
        task.time = time
        refreshDateViews()
    }


    override fun onTimeClearBtnClicked() {
        task.time = null
        refreshDateViews()
    }


    override fun onBackPressed() {
        with(newTask) {
            name = view.getNameContent()
            isDone = view.getIsDoneContent()
        }

        if(task == newTask)
        {
            view.onSuperBackPressed()
        } else {
            view.showAlertDialog()
        }
    }

}