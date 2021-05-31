package com.politeh.helper.ui.task.fragments.datepicker

import java.time.LocalDate

interface DatePickerContract {

    interface View {

        fun setDateToDialog(year: Int, month: Int, day: Int)

        fun sendOkResult(date: LocalDate)
    }


    interface ActionListener {

        fun onCreateDialog(date: LocalDate)

        fun onDialogOkButtonClicked(year: Int, month: Int, dayOfMonth: Int)
    }

}