package com.politeh.helper.ui.task

import com.politeh.helper.database.models.Task
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

interface TaskContract {

    interface View {

        fun getTask(): Task

        fun showDatePickerDialog(date: LocalDate)

        fun showTimePickerDialog(time: LocalTime)

        fun setName(name: String)

        fun setIsDone(isDone: Boolean)

        fun setDate(date: String)

        fun setTime(time: String)

        fun getNameContent(): String

        fun getIsDoneContent(): Boolean

        fun getDateContent(): String

        fun getTimeContent(): String

        fun showDateClearBtn()

        fun showTimeViews()

        fun showTimeClearBtn()

        fun hideDateClearBtn()

        fun hideTimeViews()

        fun hideTimeClearBtn()

        fun onSuperBackPressed()

        fun showAlertDialog()

        fun closeActivity()
    }


    interface ActionListener {

        fun onSaveMenuBtnClicked()

        fun onDeleteMenuBtnClicked()

        fun onDateBtnClicked()

        fun onDatePicked(date: LocalDate)

        fun onDateClearBtnClicked()

        fun onTimeBtnClicked()

        fun onTimePicked(time: LocalTime)

        fun onTimeClearBtnClicked()

        fun onBackPressed()
    }

}