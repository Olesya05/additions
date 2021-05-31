package com.politeh.helper.ui.task.fragments.timepicker

import java.time.LocalDate
import java.time.LocalTime

interface TimePickerContract {

    interface View {

        fun setTimeToDialog(hours: Int, minutes: Int)

        fun sendOkResult(time: LocalTime)
    }


    interface ActionListener {

        fun onCreateDialog(time: LocalTime)

        fun onDialogOkButtonClicked(hours: Int, minutes: Int)
    }

}