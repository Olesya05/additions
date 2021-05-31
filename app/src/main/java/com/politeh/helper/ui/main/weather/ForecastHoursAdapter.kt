package com.politeh.helper.ui.main.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.politeh.helper.R
import com.politeh.helper.network.models.weatherforecast.forecast.Hour
import com.politeh.helper.ui.utils.DateTimeStringFormatter
import com.politeh.helper.ui.utils.StringProvider

class ForecastHoursAdapter(
    var hoursForecast: List<Hour>,
    private val dateTimeStringFormatter: DateTimeStringFormatter,
    private val stringProvider: StringProvider
): RecyclerView.Adapter<ForecastHourHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastHourHolder {
        return ForecastHourHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_forecast_hour, parent, false),
            dateTimeStringFormatter,
            stringProvider
        )
    }


    override fun getItemCount(): Int {
        return hoursForecast.count()
    }


    override fun onBindViewHolder(holder: ForecastHourHolder, position: Int) {
        holder.bindHour(hoursForecast[position])
    }


}