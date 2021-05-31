package com.politeh.helper.ui.task.fragments.timepicker

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import com.politeh.helper.HelperApplication
import com.politeh.helper.R
import kotlinx.android.synthetic.main.fragment_time_picker.view.*
import java.time.LocalTime
import javax.inject.Inject

class TimePickerFragment: DialogFragment(), TimePickerContract.View{


    companion object;


    @Inject
    lateinit var presenter: TimePickerPresenter

    private lateinit var timeDialog: View
    private lateinit var callback: OnTimePickerListener




    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is OnTimePickerListener) {
            callback = context
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        (requireContext().applicationContext as HelperApplication).getAppComponent()
            .createTimePickerComponent()
            .create(this)
            .inject(this)

        presenter.onCreateDialog(extractExtras(requireArguments()).taskTime)

        return AlertDialog.Builder(requireContext())
            .setView(timeDialog)
            .setTitle(R.string.date_picker_title)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                presenter.onDialogOkButtonClicked(
                    timeDialog.time_picker.hour,
                    timeDialog.time_picker.minute
                )
            }
            .create()
    }


    override fun setTimeToDialog(hours: Int, minutes: Int) {
        timeDialog = LayoutInflater.from(requireActivity()).inflate(R.layout.fragment_time_picker, null)
        with(timeDialog.time_picker) {
            setIs24HourView(true)
            hour = hours
            minute = minutes
        }
    }


    override fun sendOkResult(time: LocalTime) {
        callback.onTimePicked(time)
    }




    interface OnTimePickerListener {

        fun onTimePicked(time: LocalTime)
    }


}