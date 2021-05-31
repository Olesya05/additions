package com.politeh.helper.ui.task.fragments.timepicker

import com.politeh.helper.ui.base.mvp.presenters.BasePresenter
import com.politeh.helper.ui.task.fragments.datepicker.DatePickerContract
import java.time.LocalDate
import java.time.LocalTime

class TimePickerPresenter(
    private val view: TimePickerContract.View
): BasePresenter(), TimePickerContract.ActionListener {


    override fun onCreateDialog(time: LocalTime) = view.setTimeToDialog(
        time.hour,
        time.minute
    )


    override fun onDialogOkButtonClicked(hours: Int, minutes: Int) {
        view.sendOkResult(LocalTime.of(hours, minutes))
    }


}