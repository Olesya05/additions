package com.politeh.helper.ui.main.weather

import com.politeh.helper.network.models.weatherforecast.Location
import com.politeh.helper.network.models.weatherforecast.CurrentWeather
import com.politeh.helper.network.models.weatherforecast.forecast.Forecast
import java.time.LocalDate

interface WeatherContract {

    interface View {

        fun setDate(date: String, day: String)

        fun updateScreen(currentWeather: CurrentWeather, forecast: Forecast)

        fun setAutoCompleteAdapter(locationList: MutableList<String>)
    }


    interface ActionListener {

        fun updateWeather(requestParameter: String)

        fun onTextChange(text: String)
    }

}