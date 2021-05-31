package com.politeh.helper.ui.task

import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.politeh.helper.HelperApplication
import com.politeh.helper.R
import com.politeh.helper.database.models.Task
import com.politeh.helper.ui.base.activities.BaseActivity
import com.politeh.helper.ui.task.fragments.datepicker.DatePickerFragment
import com.politeh.helper.ui.task.fragments.datepicker.newInstance
import com.politeh.helper.ui.task.fragments.timepicker.TimePickerFragment
import com.politeh.helper.ui.task.fragments.timepicker.newInstance
import kotlinx.android.synthetic.main.activity_task.*
import kotlinx.android.synthetic.main.fragment_date_picker.view.*
import java.time.LocalDate
import java.time.LocalTime
import javax.inject.Inject

class TaskActivity:
    BaseActivity(R.layout.activity_task),
    TaskContract.View,
    DatePickerFragment.OnDatePickerListener,
    TimePickerFragment.OnTimePickerListener
{


    companion object;


    @Inject
    lateinit var presenter: TaskPresenter




    override fun injectDependencies() {
        (applicationContext as HelperApplication).getAppComponent()
            .createTaskComponent()
            .create(this)
            .inject(this)
    }


    override fun init() {
        presenter.init()
        initButtons()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_task_activity, menu)
        return true
    }


    override fun getTask(): Task {
        return extractExtras(intent).task
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.saveTaskMenuBtn -> {
                presenter.onSaveMenuBtnClicked()
                true
            }

            R.id.deleteTaskMenuBtn -> {
                presenter.onDeleteMenuBtnClicked()
                true
            }

            android.R.id.home -> {
                onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun initButtons() {

        taskDateEt.setOnClickListener {
            presenter.onDateBtnClicked()
        }

        taskTimeEt.setOnClickListener {
            presenter.onTimeBtnClicked()
        }

        clearDateBtn.setOnClickListener {
            taskDateEt.setText("")
            taskTimeEt.setText("")
            presenter.onDateClearBtnClicked()
        }

        clearTimeBtn.setOnClickListener {
            taskTimeEt.setText("")
            presenter.onTimeClearBtnClicked()
        }
    }


    override fun showDatePickerDialog(date: LocalDate) {
        val dialog = DatePickerFragment.newInstance(date)
        dialog.show(supportFragmentManager, DIALOG_DATE)
    }


    override fun onDatePicked(date: LocalDate) {
        presenter.onDatePicked(date)
    }


    override fun showTimePickerDialog(time: LocalTime) {
        val dialog = TimePickerFragment.newInstance(time)
        dialog.show(supportFragmentManager, DIALOG_DATE)
    }


    override fun onTimePicked(time: LocalTime) {
        presenter.onTimePicked(time)
    }


    override fun setName(name: String) {
        taskNameEt.setText(name)
    }


    override fun setIsDone(isDone: Boolean) {
        taskIsDoneCb.isChecked = isDone
    }


    override fun setDate(date: String) {
        taskDateEt.setText(date)
    }


    override fun setTime(time: String) {
        taskTimeEt.setText(time)
    }


    override fun getNameContent(): String {
        return taskNameEt.text.toString()
    }


    override fun getIsDoneContent(): Boolean {
        return taskIsDoneCb.isChecked
    }


    override fun getDateContent(): String {
        return taskDateEt.text.toString()
    }


    override fun getTimeContent(): String {
        return taskTimeEt.text.toString()
    }


    override fun showDateClearBtn() {
        clearDateBtn.visibility = View.VISIBLE
    }


    override fun showTimeViews() {
        taskTimeEt.visibility = View.VISIBLE
        timeImv.visibility = View.VISIBLE
    }


    override fun showTimeClearBtn() {
        clearTimeBtn.visibility = View.VISIBLE
    }


    override fun hideDateClearBtn() {
        clearDateBtn.visibility = View.GONE
    }


    override fun hideTimeViews() {
        taskTimeEt.visibility = View.GONE
        timeImv.visibility = View.GONE
    }


    override fun hideTimeClearBtn() {
        clearTimeBtn.visibility = View.GONE
    }


    override fun onBackPressed() {
        presenter.onBackPressed()
    }


    override fun onSuperBackPressed()
    {
        super.onBackPressed()
    }


    override fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle(R.string.close_alert_title)
            .setMessage(R.string.close_alert_text)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                onSuperBackPressed()
            }
            .create()
            .show()
    }


    override fun closeActivity() {
        finish()
    }


}